package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.dao.UserDao;

@Component("/user/like.do")
public class FollowingUserLikeListController implements Controller {

	UserDao userDao = null;
	
	public FollowingUserLikeListController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("ulikes", userDao.selectMoreList());
		
		return "/jsp/user/FollowingUserLikeList.jsp";
	}

}

