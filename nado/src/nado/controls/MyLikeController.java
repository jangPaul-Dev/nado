package nado.controls;

import java.util.Map;

import nado.dao.SqlMyPageDao;

public class MyLikeController implements Controller {

	SqlMyPageDao myLike = null;
	
	public MyLikeController selectMyLike(SqlMyPageDao myLike) throws Exception {
		this.myLike = myLike;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("myLike", myLike.selectMyLike());
		
		return "/jsp/myPage/myLike.jsp";
	}
}
