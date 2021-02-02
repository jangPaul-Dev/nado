package nado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nado.annotation.Component;
import nado.vo.User;
@Component("myProfile")
public class SqlMyProfileDao  {
	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public List<User> selectMyProfile() throws Exception {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		/*User user = new User();

		int myUserNo = user.getuNo();
		System.out.println(myUserNo);*/
		

		try { // 커넥션풀에서 Connection객체를 빌려온다 
			connection = ds.getConnection(); 
			stmt =connection.createStatement();		
			final String sqlSelect = "SELECT * FROM user";
			User mypage = null;
			rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {
				mypage =new User().setuId(rs.getString("uid"))
					  .setuSex(rs.getString("usex"))
					  .setUaddress(rs.getString("uaddress"));
			}
			return mypage;

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
