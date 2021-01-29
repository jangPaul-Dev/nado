package nado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import nado.annotation.Component;
import nado.vo.User;

//@Component("userDao")
public class MySqlUserDao implements UserDao{

	DataSource ds = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public List<User> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT mno,mname,email,cre_date" + "\r\n" + "FROM members" + "\r\n"
				+ "ORDER BY mno ASC";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(new User().setuNo(rs.getInt("mno")));
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

	public int insert(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO user(uid, upwd, uname, ubirth, usex, phoneNum, email, address)" + "\r\n"
				                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, user.getuId());
			stmt.setString(2, user.getuPwd());
			stmt.setString(3, user.getuName());
			stmt.setDate(4, user.getuBirth());
			stmt.setString(5, user.getuSex());
			stmt.setInt(6, user.getPhoneNum());
			stmt.setString(7, user.getEmail());
			stmt.setString(8, user.getAddress());
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

	public int delete(int no) throws Exception {
		Connection connection = null;
		int result = 0;
		Statement stmt = null;
		final String sqlDelete = "DELETE FROM USER WHERE UNO=";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			result = stmt.executeUpdate(sqlDelete + no);

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

	public User selectOne(int no) throws Exception {
		Connection connection = null;
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;

		final String sqlSelectOne = "SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS" + " WHERE MNO=";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectOne + no);
			if (rs.next()) {
				user = new User().setuNo(rs.getInt("MNO")).setEmail(rs.getString("EMAIL"))
						.setuName(rs.getString("MNAME"));

			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}

			// 다 썼으면 반납하자
			try {
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	public int update(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlUpdate = "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()" + " WHERE MNO=?";
		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getuName());
			stmt.setInt(3, user.getuNo());
			result = stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
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

	public User exist(String userId, String userPwd) throws Exception {
		Connection connection = null;
		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sqlExist = "SELECT UNO, UNAME FROM USER" + " WHERE UID=? AND UPWD=?";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			
			stmt = connection.prepareStatement(sqlExist);
			stmt.setString(1, userId);
			stmt.setString(2, userPwd);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User().setuNo(rs.getInt("UNO"))
								.setuName(rs.getString("UNAME"));
//				user = new User().setuId(rs.getString("UID"));
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			
			try {
				if(connection != null)
					connection.close();// 다 썼으면 반납하자
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return user;
	}
}
