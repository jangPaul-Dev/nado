package spms.bind;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;


public class ServletRequestDataBinders {
	/* request : 매개변수 추출
	 * dataType : 클래스 타입으로 객체 생성
	 * dataName : 매개변수 이름
	 * */
	public static Object bind(ServletRequest request,
							 Class<?> dataType,
							 String dataName) throws Exception {
		// 생성해야 할 대상이 PrimitiveType일 경우(형변환을 해줘야할 경우를 말하는건가..?)
		if(isPrimitiveType(dataType)) {
			return createValueObject(dataType, 
						request.getParameter(dataName));
		}
		// 일반 vo객체일 경우
		else {
			//브라우저가 보낸 매개변수들의 이름을 Set에 담는다.
			Set<String> paramNames = request.getParameterMap().keySet();
			
			//클래스 타입대로 객체 생성
			Object dataObject = dataType.newInstance();
			
			Method m = null; //VO의 Setter를 찾아서 저장
			//브라우저가 보낸 매개변수를 1개씩 접근한다.
			for(String paramName : paramNames) {
				//매개변수에 해당하는 Setter 얻기
				/*
				 * ex) no 매개변수 -> m은 setNo를 가리킨다.
				 * email -> m은 setEmail를 가리킨다.
				 * password -> m은 setPassword를 가리킨다.
				 * 
				 * */
				m = findSetter(dataType, paramName);
				if(m != null) {
					//dataObject객체의 m 메서드를 호출한다.
					//첫 번째 매개변수에 클라이언트의 매개변수 값을 대입
					//invoke : 메서드의 정보를 가지고 해당하는 메서드를 호출하는 것
					m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], 
							request.getParameter(paramName)));
				}
			}
			return dataObject; //브라우저가 보낸 변수값까지 객체에 저장한 후 생성한 객체를 통으로 리턴.
		}
	}
	
	private static Method findSetter(Class<?> type, String name) {
		Method[] methods = type.getMethods();
		
		String propName = null;
		for(Method m: methods) {
			if(!m.getName().startsWith("set"))
				continue;
				
			//Property 프로퍼티 : Set을 제외한 이름 
			propName = m.getName().substring(3);
			propName = propName.toLowerCase();	//toLowerCase(); 소문자로
			
			//name으로 넘겨준 이름과 프로퍼티가 같으면 해당 프로퍼티의 setter를 찾았다
			if(propName.equals(name.toLowerCase())) {
				return m;
			}
			
		}

		return null;
	}

	private static boolean isPrimitiveType(Class<?> type) {
		if(type.getName().equals("int") || type==Integer.class ||
			type.getName().equals("long") || type==Long.class ||
			type.getName().equals("float") || type==Float.class ||
			type.getName().equals("double") || type==Double.class ||
			type.getName().equals("boolean") || type==Boolean.class ||
			type==Date.class || type==String.class) {
			return true;
		}
		return false;
	}
	
	private static Object createValueObject(Class<?> type, String value) {
		if(type.getName().equals("int") || type==Integer.class)
			return new Integer(value);
		else if(type.getName().equals("float") || type==Float.class)
			return new Float(value);
		else if(type.getName().equals("double") || type==Double.class)
			return new Double(value);
		else if(type.getName().equals("long") || type==Long.class)
			return new Long(value);
		else if(type.getName().equals("boolean") || type==Boolean.class)
			return new Boolean(value);
		else if(type==Date.class)
			return java.sql.Date.valueOf(value);
		else
			return value;
	}
}





