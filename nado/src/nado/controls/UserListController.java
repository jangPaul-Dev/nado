package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.dao.UserDao;


@Component("/user/list.do")
public class UserListController implements Controller {

	UserDao userDao = null;
	
	public UserListController setUserDao(UserDao userDao) {
		this.userDao=userDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("users", userDao.selectList());
		
		return "/user/UserList.jsp";
	}

}
