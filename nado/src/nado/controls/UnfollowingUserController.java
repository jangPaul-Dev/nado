package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.UserDao;

@Component("user/unfollwing.do")
public class UnfollowingUserController implements Controller, DataBinding {

	UserDao userDao = null;
	
	public UnfollowingUserController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
//		Integer from_user = (Integer)model.get("form_user");
//		userDao.delete(from_user);		
		Integer to_user = (Integer)model.get("to_user");		
		userDao.delete(to_user);
		
		return "redirect:more.do";
	}


	@Override
	public Object[] getDataBinders() {
		return new Object[] {
//				"from_user", Integer.class,
				"to_user", Integer.class
		};
	}

}
