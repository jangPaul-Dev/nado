package nado.vo;

import java.util.Date;

public class User {
	protected int uNo;
	protected String uId;
	protected String uPwd;
	protected String uName;
	protected Date uBirth;		// 14:17 추가
	protected String uSex;
	protected int phoneNum;
	protected String email;
	protected String address;
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
	public int getPhoneNum() {
		return phoneNum;
	}
	public User setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public User setAddress(String address) {
		this.address = address;
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
