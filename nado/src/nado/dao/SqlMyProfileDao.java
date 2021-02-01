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
		User user = new User();

		int myUserNo = user.getuNo();
		System.out.println(myUserNo);
		

		try { // 커넥션풀에서 Connection객체를 빌려온다 
			connection = ds.getConnection(); 
			stmt =connection.createStatement();		
			final String sqlSelect = "SELECT * FROM user WHERE uno = ";
			rs = stmt.executeQuery(sqlSelect+myUserNo);
			

			
			ArrayList<User> myProfile = new ArrayList<User>();

			while (rs.next()) {
				myProfile.add(new User().setuId(rs.getString("uid")).setuSex(rs.getString("usex"))
						.setUaddress(rs.getString("address")));
			}
			return myProfile;

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
