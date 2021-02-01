package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.bind.DataBinding;
import nado.dao.MeetCardDao;

import nado.vo.MeetCard;

@Component("/main/meetAdd.do")
public class NadoAddController implements Controller , DataBinding{

	MeetCardDao meet = null;
	
	public NadoAddController setMeetDao(MeetCardDao meet) {
		this.meet = meet;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {	
		//필터링된 데이터를 가져와서  insert로 보낸다. 작업이 완료되면 페이지를 바로 다시 메인으로 보낸다.
		MeetCard meetcard = (MeetCard)model.get("meetcard");
		meet.insert(meetcard);
		return "redirect:main.do";
	}

	@Override
	//가져온 데이터를 필터링한다.
	public Object[] getDataBinders() {
		return new Object[] {
				"meetcard", nado.vo.MeetCard.class
			};
	}
	
	
}





