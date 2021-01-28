package nado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nado.vo.MeetCard;
import nado.vo.MyTimeLine;
import nado.vo.Ulike;
import nado.vo.User;

public class MySqlMyPageDao extends UserDao {
		
	public List<User> myWriteList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		int curUserNo = Ulike.getUlike_uno();	// 현재 로그인 한 사용자 번호, VO에서 받아오기
		final String sqlSelect = "SELECT w_uno,w_mno FROM writer " + "\r\n"
				+ "WHERE w_uno=" + curUserNo;

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<User> myWrite = new ArrayList<User>();

			while (rs.next()) {
				myWrite.add(new MeetCard()
						.setmNo(rs.getInt("mNo"))
						.setmContent(rs.getString("mContent"))
						.setmDate(rs.getDate("mdate")));
				myWrite.add(new User()
						.setuId(rs.getString("uid")));
			}

			return myWrite;

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
