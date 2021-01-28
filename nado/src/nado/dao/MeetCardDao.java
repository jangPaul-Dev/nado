package nado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import nado.vo.MeetCard;
import nado.vo.Ulike;

public class MeetCardDao {
	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public MeetCard MeetCard() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		Ulike ulike = new Ulike();
		int myUserNo = ulike.getUlike_uno(); // 현재 로그인 한 사용자 번호
		String sqlSelect = "SELECT w_uno,w_mno FROM writer " + "\r\n" + "WHERE w_uno=" + myUserNo;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			
			MeetCard myMeetCard = new MeetCard();
			while (rs.next()) {
				myMeetCard.setmNo(rs.getInt("mNo"))
						.setmContent(rs.getString("mContent"))
						.setmDate(rs.getDate("mdate"));
			}
			return myMeetCard;

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
