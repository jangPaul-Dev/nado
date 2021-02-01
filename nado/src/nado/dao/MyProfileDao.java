package nado.dao;

import java.util.List;

import nado.vo.User;

public interface MyProfileDao {
	public List<User> selectMyProfile() throws Exception;
}
