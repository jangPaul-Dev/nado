package nado.dao;

import java.util.List;

import nado.vo.User;

/* 굳이 MemberDao 인터페이스를 만든 이유는?
 * 
 * 향후 Oracle, SQL-Server, ...... 확장해 나갈때
 * 이 인터페이스를 상속받아서 기능은 각 DBMS별로 특성에 맞게 구현하되
 * 메서드의 역할/리턴값은 동일하게 해줌으로써
 * DBMS의 교체를 매우 쉽게 해준다
 * */
public interface UserDao {

	public List<User> selectList() throws Exception;
	public int insert(User user) throws Exception;
	public int delete(int no) throws Exception;
	public User selectOne(int no) throws Exception;
	public int update(User user) throws Exception;
	public User exist(String uId, String uPwd) throws Exception;
}
