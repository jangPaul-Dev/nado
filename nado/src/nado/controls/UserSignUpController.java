package nado.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.UserDao;
import nado.vo.Ulike;
import nado.vo.User;

@Component("/user/signup.do")
public class UserSignUpController implements Controller, DataBinding {
	
	UserDao userDao = null;
	
	public UserSignUpController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// key값 이름, 자동으로 생성해야 할 클래스 타입
		return new Object[] {
			"user", nado.vo.User.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User newUser = (User)model.get("user");
		
		if(newUser.getuId() == null) {
			return "/jsp/user/SignUp.jsp"; 
		
		}else {
			userDao.insert(newUser);

			User user = userDao.selectOne(newUser.getuId());
			model.put("user", user);
			
			return "/jsp/user/Ulike.jsp";

		}
	}

}

//User user = userDao.selectOne(newUser.getuId());
////model.put("uno", user.getuNo());
//HttpSession session = (HttpSession)model.get("session");
//session.getServletContext().setAttribute("uno", user.getuNo());
//User user = userDao.selectOne(newUser.getuId());
//model.put("user", user);
//return "/jsp/user/Ulike.jsp";
//return "../auth/login.do"; 

//${uno}
