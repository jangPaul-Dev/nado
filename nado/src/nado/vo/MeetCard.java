package nado.vo;

import java.util.Date;

public class MeetCard  {
	protected int mno;
	protected String mtitle;
	protected Date mdate;
	protected String mcontent;
	protected String mimg;
	protected int maxuser;
	protected String endyn; 
	protected String moption;
	
	public int getMno() {
		return mno;
	}
	public MeetCard setMno(int mno) {
		this.mno = mno;
		return this;
	}
	public String getMtitle() {
		return mtitle;
	}
	public MeetCard setMtitle(String mtitle) {
		this.mtitle = mtitle;
		return this;
	}
	public Date getMdate() {
		return mdate;
	}
	public MeetCard setMdate(Date mdate) {
		this.mdate = mdate;
		return this;
	}
	public String getMcontent() {
		return mcontent;
	}
	public MeetCard setMcontent(String mcontent) {
		this.mcontent = mcontent;
		return this;
	}
	public String getMimg() {
		return mimg;
	}
	public MeetCard setMimg(String mimg) {
		this.mimg = mimg;
		return this;
	}
	public int getMaxuser() {
		return maxuser;
	}
	public MeetCard setMaxuser(int maxuser) {
		this.maxuser = maxuser;
		return this;
	}
	public String getEndyn() {
		return endyn;
	}
	public MeetCard setEndyn(String endyn) {
		this.endyn = endyn;
		return this;
	}
	public String getMoption() {
		return moption;
	}
	public MeetCard setMoption(String moption) {
		this.moption = moption;
		return this;
	}
	

	
}
