package com.bit2016.bookmall.vo;

public class MemberVo {
	private long no;
	private String name;
	private long ph;
	private String email;
	private String pw;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPh() {
		return ph;
	}

	public void setPh(long ph) {
		this.ph = ph;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", ph=" + ph + ", email=" + email + ", pw=" + pw + "]";
	}

}
