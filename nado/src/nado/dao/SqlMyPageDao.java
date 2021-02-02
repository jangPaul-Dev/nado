package nado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nado.annotation.Component;
import nado.vo.Ulike;
import nado.vo.User;

@Component("/UlikeDao")
public class SqlMyPageDao implements MyPageDao {
	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
//	public List<User> selectList() throws Exception {
//		Connection connection = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		User user = new User();
//		int myUserNo = user.getuNo();
//		
//		
//		return null;
//	}
//
	// mypage의 관심사에서 보여줄 정보
	public List<Ulike> selectMyLike() throws Exception {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		
		int myUserNo = user.getuNo();
		final String likeSqlSelect = "SELECT * FROM ulike WHERE ulike_uno = " + myUserNo + " LIKE 'Y%';";

		try {
			ArrayList<Ulike> myLike = new ArrayList<Ulike>();

			rs = stmt.executeQuery(likeSqlSelect);
			while (rs.next()) {
				myLike.add(new Ulike().setFood(rs.getString("food")).setTravel(rs.getString("travel"))
						.setPhoto(rs.getString("photo")).setMovie(rs.getString("movie"))
						.setReading(rs.getString("reading")).setVolunteer(rs.getString("volunteer"))
						.setHealth(rs.getString("health")).setBuying(rs.getString("buying"))
						.setGame(rs.getString("game")).setEtc(rs.getString("etc"))
						.setDevelopment(rs.getString("development")).setConcert(rs.getString("concert")));
			}
			
			//System.out.println(myLike);
			//myLike를 풀어서, 배열에 넣는다.
			
			/* String[] ResultMyLike = null; */
//			ResultMyLike =
			/* ResultMyLike = (toString(myLike).equals("y")); */
			return myLike;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
 
	
}
