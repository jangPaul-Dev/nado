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
		
		return "redirect:login.do";
	}

}





