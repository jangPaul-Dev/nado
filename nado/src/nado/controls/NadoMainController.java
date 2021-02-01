package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.MeetCardDao;

import nado.vo.MeetCard;

import nado.vo.User;

@Component("/main/main.do")
public class NadoMainController implements Controller {

	MeetCardDao meet = null;
	
	public NadoMainController setMeetDao(MeetCardDao meet) {
		this.meet = meet;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("meetcards",meet.selectList());
		
		return "/jsp/main/Main.jsp";
	}


}
