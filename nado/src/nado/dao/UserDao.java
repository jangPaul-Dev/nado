package nado.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import nado.vo.User;

public class UserDao {
	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public List<User> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT *" + "\r\n" + "FROM user" + "\r\n";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(new User().setuName(rs.getString("uname")).setuId(rs.getString("uid"))); // mypage에서 필요해서
																									// 넣었습니다
			}
			return users;

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
	
	} // List<USER> end
} // class end
