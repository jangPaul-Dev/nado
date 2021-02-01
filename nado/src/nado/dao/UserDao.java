package nado.dao;

import java.util.List;

import nado.vo.Ulike;
import nado.vo.User;

/* 굳이 MemberDao 인터페이스를 만든 이유는?
 * 
 * 향후 Oracle, SQL-Server, ...... 확장해 나갈때
 * 이 인터페이스를 상속받아서 기능은 각 DBMS별로 특성에 맞게 구현하되
 * 메서드의 역할/리턴값은 동일하게 해줌으로써
 * DBMS의 교체를 매우 쉽게 해준다
 * */
public interface UserDao {

	public int insert(User user) throws Exception; //연정-회원가입 쿼리
	public int insertInterest(Ulike ulike) throws Exception;//연정: 회원 관심사 생성
    public User selectOne(String id) throws Exception;//연정-ulike를 위한 회원번호
    public User exist(String uId, String uPwd) throws Exception;//연정 -로그인, 주옥: 로그인 성공시, 전체 데이터 vo 
    
    //현정
	/* public User selectOne(int no) throws Exception; */
	/* public List<User> selectList() throws Exception; */
	/* public int update(User user) throws Exception; */
	
	
	//소정
	public List<User> selectList() throws Exception; //씀
	public List<Ulike> selectMoreList() throws Exception; //씀
	public User selectOne(User uid) throws Exception; 
	public int delete(int to_user) throws Exception;


}
