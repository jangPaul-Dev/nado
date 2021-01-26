package nado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nado.vo.MyTimeLine;
import spms.dao.DataSource;

public class MySqlMyPageDao implements MemberDao {
	
	
	public List<MyTimeLine> myWriteList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		javax.sql.DataSource ds = null;
		int curUserNo;	// 현재 로그인 한 사용자 번호, VO에서 받아오기
		final String sqlSelect = "SELECT uno,mno " + "\r\n" + "FROM writer " + "\r\n"
				+ "WHERE uno=" + curUserNo;

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<MyTimeLine> myWrite = new ArrayList<MyTimeLine>();

			while (rs.next()) {
				myWrite.add(new MyTimeLine().setMno(rs.getInt("mno"))
						.setUid(rs.getString("uid"))
						.setMcontext(rs.getString("mcontext"))
						.setMdate(rs.getDate("mdate")));
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

			/* ds에서 제공하는 Connection객체의 close()의 의미는
			 * 연결을 종료하는 것이 아니라
			 * 객체를 ds내부의 커넥션 풀에 반납한다는 의미이다
			 * */
			try {
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
