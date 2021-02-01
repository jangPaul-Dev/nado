package nado.vo;

import java.sql.Date;

public class User {
	protected int uNo;
	protected String uId;
	protected String uPwd;
	protected String uName;
	protected Date uBirth;	
	protected String uSex;
	protected int uphoneNum;
	protected String uemail;
	protected String uaddress;
	protected String useYn;

	public int getuNo() {
		return uNo;
	}
	public User setuNo(int uNo) {
		this.uNo = uNo;
		return this;
	}
	public String getuId() {
		return uId;
	}
	public User setuId(String uId) {
		this.uId = uId;
		return this;
	}
	public String getuPwd() {
		return uPwd;
	}
	public User setuPwd(String uPwd) {
		this.uPwd = uPwd;
		return this;
	}
	public String getuName() {
		return uName;
	}
	public User setuName(String uName) {
		this.uName = uName;
		return this;	
	}
	
	public Date getuBirth() {
		return uBirth;
	}
	
	public User setuBirth(Date uBirth) {
		this.uBirth = uBirth;
		return this;
	}

	public String getuSex() {
		return uSex;
	}
	public User setuSex(String uSex) {
		this.uSex = uSex;
		return this;
	}
	public int getUphoneNum() {
		return uphoneNum;
	}
	public User setUphoneNum(int uphoneNum) {
		this.uphoneNum = uphoneNum;
		return this;
	}
	public String getUemail() {
		return uemail;
	}
	public User setUemail(String uemail) {
		this.uemail = uemail;
		return this;
	}
	public String getUaddress() {
		return uaddress;
	}
	public User setUaddress(String uaddress) {
		this.uaddress = uaddress;
		return this;
	}
	public String getUseYn() {
		return useYn;
	}
	public User setUseYn(String useYn) {
		this.useYn = useYn;
		return this;
	}
}
