package nado.dao;

import java.util.List;

import nado.vo.Ulike;
import nado.vo.User;

public interface MyPageDao {

//	public List<User> selectList() throws Exception;
	public List<Ulike> selectMyLike() throws Exception;
}
