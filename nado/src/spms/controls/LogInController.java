package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.dao.MySqlMemberDao;
import spms.vo.Member;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
	
	MemberDao memberDao = null;
	
	public LogInController setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member loginInfo = (Member)model.get("loginInfo");
		//아이디가 없으면
		if(loginInfo.getEmail() == null) {
			return "/auth/LogInForm.jsp";
			
		}else {
			
			Member member = memberDao.exist(loginInfo.getEmail(),loginInfo.getPassword());
			//둘다 값이 있고, 맞으면 (e-mail,pwd)
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../member/list.do";
				
			//둘중에 하나라도 틀리면
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"loginInfo", spms.vo.Member.class	
		};
	}

}





