package nado.controls;

import java.util.Map;

import nado.annotation.Component;
import nado.dao.SqlMyProfileDao;

@Component("/myPage/myPage.do")
public class MyProfileController implements Controller {

	SqlMyProfileDao myProfile = null;

	public MyProfileController selectMyProfile(SqlMyProfileDao myProfile) throws Exception {
		this.myProfile = myProfile;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("myProfile", myProfile.selectMyProfile());
		
		return "/jsp/myPage/myPage.jsp";
	}
}
