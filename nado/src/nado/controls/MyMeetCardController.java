package nado.controls;

import java.util.Map;

import nado.dao.SqlMeetCardDao;

public class MyMeetCardController implements Controller {

	SqlMeetCardDao myMeetCard = null;
	
	public MyMeetCardController selectMyPage(SqlMeetCardDao myMeetCard) throws Exception {
		this.myMeetCard = myMeetCard;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("myMeetCard", myMeetCard.selectMyPage());
		
		return "/jsp/myPage/myPage.jsp";
	}

}
