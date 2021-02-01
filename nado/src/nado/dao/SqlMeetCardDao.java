package nado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nado.annotation.Component;
import nado.vo.MeetCard;

import nado.vo.User;

/*@Component("MeeCardDao")*/
public class SqlMeetCardDao implements MeetCardDao {
	//DB연결을 위한 CONNECTION
	DataSource co = null;
	
	public void setDataSource(DataSource ds) {
		this.co = ds;
	}
	
	
	@Override
	public List<MeetCard> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MeetCard> meetcards = new ArrayList<MeetCard>();	
		
		final String sqlSelect = 
				"SELECT mno, mtitle, mdate, mcontent, mimg, maxuser, endyn, moption FROM meetcard order by MDATE desc";

		
		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = co.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);
					
			
			while(rs.next()) {
				meetcards.add(new MeetCard()
						.setMno(rs.getInt("mno"))
						.setMtitle(rs.getString("mtitle"))
						.setMdate(rs.getDate("mdate"))
						.setMcontent(rs.getString("mcontent"))
						.setMimg(rs.getString("mimg"))
						.setMaxuser(rs.getInt("maxuser"))
						.setEndyn(rs.getString("endyn"))
						.setMoption(rs.getString("moption"))
				);
			}		
		return meetcards;
		
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
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}


	@Override
	public int insert(MeetCard meetcard) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		/*
		 * final String sqlInsert =
		 * "INSERT INTO meetcard (MDATE, MCONTENT, MIMG, MAXUSER,ENDYN)\r\n" +
		 * "VALUES(NOW(),'모여라 인간들아~~', '/img/testimag.jpg', 5, 'N');";
		 */
		
		final String sqlInsert = "INSERT INTO meetcard (mtitle, MCONTENT, MIMG, MAXUSER,MDATE,moption)\r\n" + 
				"VALUES(?,?, ?, ?, NOW(),?);";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = co.getConnection();

			stmt = connection.prepareStatement(sqlInsert);
			
			stmt.setString(1, meetcard.getMtitle());
			stmt.setString(2, meetcard.getMcontent());
			stmt.setString(3, meetcard.getMimg());
			stmt.setInt(4, meetcard.getMaxuser());
			stmt.setString(5, meetcard.getMoption());

			result = stmt.executeUpdate();

			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 다 썼으면 반납하자
			try {
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	
	
	
	@Override
	public List<MeetCard> selectMyPage() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		
		int myUserNo = user.getuNo(); // 현재 로그인 한 사용자 번호
		final String sqlSelect = "SELECT w_mno FROM writer WHERE w_uno=" + myUserNo +" ORDER BY w_mno DESC LIMIT 10;";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = co.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<MeetCard> myMeet = new ArrayList<MeetCard>();			
			
			while (rs.next()) {
				myMeet.add(new MeetCard()
					.setMno(rs.getInt("mno"))
					.setMdate(rs.getDate("mdate"))
					.setMcontent(rs.getString("mcontent"))
					.setMimg(rs.getString("mimg"))
					.setMaxuser(rs.getInt("maxuser"))
					.setEndyn(rs.getString("endyn"))						
				);
			}
			return myMeet;
		
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
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
