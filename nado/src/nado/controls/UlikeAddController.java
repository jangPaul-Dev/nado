package nado.controls;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.UserDao;
import nado.vo.Ulike;
import nado.vo.User;

@Component("/user/ulikeAdd.do")
public class UlikeAddController implements Controller, DataBinding {
	
	UserDao userDao = null;
	
	public UlikeAddController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// key값 이름, 자동으로 생성해야 할 클래스 타입
		return new Object[] {
			"ulike", nado.vo.Ulike.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Ulike ulike = (Ulike)model.get("ulike");
        
		int result = userDao.insertInterest(ulike);		
			
		return "redirect:../auth/login.do"; 

	}
}



//if(ulike.getFood() == null) {
//return "/jsp/user/ulike.jsp"; //jsp에서 넘어가기 때문에 if로 다시 검사 X .do로 들어오면 계속 들어감..
//
//}else {
//ServletContext ctx = ((HttpSession)model.get("session")).getServletContext();
//int no = (int) ctx.getAttribute("uno");
//ctx.removeAttribute("uno");
//
//int result = userDao.insertInterest(ulike);		
//return "redirect:../auth/login.do"; 
//}
