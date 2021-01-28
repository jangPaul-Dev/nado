package nado.vo;

import java.sql.Date;

public class MeetCard {
	protected int mNo;
	protected Date mDate;
	protected String mContent;
	protected String mImg;
	protected int maxUser;
	protected String endYn;
	
	
	public int getmNo() {
		return mNo;
	}
	public MeetCard setmNo(int mNo) {
		this.mNo = mNo;
		return this;
	}
	public Date getmDate() {
		return mDate;
	}
	public MeetCard setmDate(Date mDate) {
		this.mDate = mDate;
		return this;
	}
	public String getmContent() {
		return mContent;
	}
	public MeetCard setmContent(String mContent) {
		this.mContent = mContent;
		return this;
	}
	public String getmImg() {
		return mImg;
	}
	public MeetCard setmImg(String mImg) {
		this.mImg = mImg;
		return this;
	}
	public int getMaxUser() {
		return maxUser;
	}
	public MeetCard setMaxUser(int maxUser) {
		this.maxUser = maxUser;
		return this;
	}
	public String getEndYn() {
		return endYn;
		
	}
	public MeetCard setEndYn(String endYn) {
		this.endYn = endYn;
		return this;
	}
	
}
