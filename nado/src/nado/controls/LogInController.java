package nado.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.UserDao;
import nado.dao.MySqlUserDao;
import nado.vo.Ulike;
import nado.vo.User;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
	
	UserDao userDao = null;
	
	public LogInController setUserDao(UserDao userDao) {
		this.userDao =  userDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"loginInfo", nado.vo.User.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User loginInfo = (User)model.get("loginInfo");
		
		
		//아이디가 없으면
		if(loginInfo.getuId() == null) {
			return "/jsp/auth/LogInForm.jsp";
		
		}
		//아이디가 있으면
		else {
			User user = userDao.exist(loginInfo.getuId(),loginInfo.getuPwd());
			//둘다 값이 있고, 맞으면 (uid,upwd)
			if(user != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("user", user);
				
//				Ulike ulike = userDao.selectUserInterest(user.getuNo());
				
				//로그인과 동시에 ulike 객체에 값 받아오기?
//				model.put("ulikes", userDao.selectMoreList()); //>> 가능한가?	
				
				return "redirect:../main/main.do";
				
				
			//둘중에 하나라도 틀리면
			}else {
				return "/jsp/auth/LogInFail.jsp";
			}
		}
	}

}





