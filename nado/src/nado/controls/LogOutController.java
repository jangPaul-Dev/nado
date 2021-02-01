package nado.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import nado.annotation.Component;

@Component("/auth/logout.do")
public class LogOutController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		System.out.println("나 들어왓니?");
		
		return "redirect:login.do";
	}

}





