package nado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nado.vo.Ulike;
//import nado.annotation.Component;
import nado.vo.User;

//@Component("userDao")
public class MySqlUserDao implements UserDao{

	DataSource ds = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	//연정: 회원가입 쿼리
	@Override
	public int insert(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO user(uid, upwd, uname, ubirth, usex, uphoneNum, uemail, uaddress)" + "\r\n"
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
			stmt.setInt(6, user.getUphoneNum()); //ereor! not null이면 안넘어감 하하
			stmt.setString(7, user.getUemail()==null?"":user.getUemail());   //ereor! not null이면 안넘어감 하하
			stmt.setString(8, user.getUaddress()==null?"":user.getUaddress());   //ereor! not null이면 안넘어감 하하
					
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

	//연정: Ulike를 위한 회원번호
	@Override
		public User selectOne(String id) throws Exception {
			Connection connection = null;
			User user = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			final String sqlSelectOne = "SELECT UNO,UID FROM USER" + " WHERE UID=?";

			try {
				// 커넥션풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();
				stmt = connection.prepareStatement(sqlSelectOne);
				stmt.setString(1, id);
				rs = stmt.executeQuery();
				if (rs.next()) {
					user = new User().setuNo(rs.getInt("uno")).setuId(rs.getString("uid"));
			
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
			

		//연정
		//+주옥 : 로그인 성공시, 전체 데이터 vo에 넣어준다.
	@Override
		public User exist(String userId, String userPwd) throws Exception {
			Connection connection = null;
			User user = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlExist = 
					"SELECT uno, uid, upwd, uname, ubirth, usex, uphonenum, uemail, uaddress, useyn \r\n" + 
					"FROM USER  WHERE UID=? AND UPWD=?";

			try {
				// 커넥션풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();
				
				stmt = connection.prepareStatement(sqlExist);
				stmt.setString(1, userId);
				stmt.setString(2, userPwd);
				rs = stmt.executeQuery();
				if (rs.next()) {
					
					//0131 주옥 추가 :  vo에 객체담기
					user = new User().setuNo(rs.getInt("uno"))
									.setuId(rs.getString("uid"))
									.setuPwd(rs.getString("upwd"))
									.setuName(rs.getString("uname"))
									.setuBirth(rs.getDate("ubirth"))
									.setuSex(rs.getString("usex"))
									.setUphoneNum(rs.getInt("uphoneNum"))
									.setUemail(rs.getString("uemail"))
									.setUaddress(rs.getString("uaddress"))
									.setUseYn(rs.getString("useYn"));

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
	
	//연정: 회원 관심사 생성
		@Override
		public int insertInterest(Ulike ulike) throws Exception {
			Connection connection = null;
			int result = 0;
			PreparedStatement stmt = null;
			User user = new User();
			System.out.println(user.getuNo());
			
			
			final String sqlInsert = "INSERT INTO ULIKE(ulike_uno, food, travel, photo, movie, reading, volunteer, health, buying, game, etc, development, concert)" + "\r\n"
					                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				// 커넥션풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();

				stmt = connection.prepareStatement(sqlInsert);
				stmt.setInt(1, ulike.getUlike_uno()); //방금 회원가입한 user의 uno(자동생성) 
				stmt.setString(2, ulike.getFood());
				stmt.setString(3, ulike.getTravel());
				stmt.setString(4, ulike.getPhoto());
				stmt.setString(5, ulike.getMovie());
				stmt.setString(6, ulike.getReading());
				stmt.setString(7, ulike.getVolunteer());
				stmt.setString(8, ulike.getHealth());
				stmt.setString(9, ulike.getBuying());
				stmt.setString(10, ulike.getGame());
				stmt.setString(11, ulike.getEtc());
				stmt.setString(12, ulike.getDevelopment());
				stmt.setString(13, ulike.getConcert());
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

// 내가 팔로잉한 친구 목록 (소정)
	@Override
	public List<User> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		final String sqlSelect = "SELECT DISTINCT user.uId, user.uName, user.uBirth, user.uSex" + "\r\n" + 
								  "FROM user, follow" + "\r\n"+ "where user.uno=follow.from_user";


		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(new User().setuId(rs.getString("uId"))
									.setuName(rs.getString("uName"))
									.setuBirth(rs.getDate("uBirth"))
									.setuSex(rs.getString("uSex")));
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
	
	// 소정 
	// 내가 팔로잉한 친구 더보기??
	@Override
	public List<Ulike> selectMoreList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT *" + "\r\n" + 
								 "FROM user,ulike" + "\r\n"+
								 "WHERE user.uno=ulike.ulike_uno";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<Ulike> ulikes = new ArrayList<Ulike>();

			while (rs.next()) {
				ulikes.add(new Ulike().setUlike_uno(rs.getInt("Ulike_uno"))
										.setFood(rs.getString("food"))
										.setTravel(rs.getString("travel"))
										.setPhoto(rs.getString("photo"))
										.setMovie(rs.getString("movie"))
										.setReading(rs.getString("reading"))
										.setVolunteer(rs.getString("volunteer"))
										.setHealth(rs.getString("health"))
										.setBuying(rs.getString("buying"))
										.setGame(rs.getString("game"))
										.setEtc(rs.getString("etc"))
										.setDevelopment(rs.getString("development"))
										.setConcert(rs.getString("concert")));
			}

			return ulikes;

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



// 소정
@Override
public int delete(int to_user) throws Exception {
	Connection connection = null;
	int result = 0;
	Statement stmt = null;
	final String sqlDelete = "DELETE FROM follow WHERE to_user=";

	try {
		// 커넥션풀에서 Connection객체를 빌려온다
		connection = ds.getConnection();

		stmt = connection.createStatement();
		
		result = stmt.executeUpdate(sqlDelete + to_user);

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


	// 소정
@Override
	public User selectOne(User uid) throws Exception {
		Connection connection = null;
	//				Ulike ulike = null;
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		final String sqlSelectOne = "SELECT * FROM user,ulike WHERE user.uno=ulike.ulike_uno AND UID=";
	
		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectOne + uid);
			if (rs.next()) {
				user = new User().setuId(rs.getString("uId"))
						         .setuBirth(rs.getDate("uBirth"))
						         .setUaddress(rs.getString("address"));
	
	
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
	
		return uid;
	}



}
