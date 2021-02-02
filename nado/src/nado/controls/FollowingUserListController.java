package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.dao.UserDao;

@Component("/user/list.do")
public class FollowingUserListController implements Controller {
	/* DI(Dependency Injection)으로 변경한 이유
	 * 1) 클래스간의 의존성을 낮추기 위해
	 * 2) MemberDao 인터페이스를 선언하고 상속구현함으로써 
	 *    다른 DBMS로의 전환을 용이하게 하려고
	 * 3) 나중에 변경할 자동화 작업에 사용하려고
	 * */
	
	UserDao userDao = null;
	
	public FollowingUserListController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("users", userDao.selectList());
		return "/jsp/user/FollowingUserList.jsp";
	}

}

