package com.Bean;

public class SigninBean {
	String susername;
	String spassword;
	public SigninBean() {
		super();
	}
	public SigninBean(String susername, String spassword) {
		super();
		this.susername = susername;
		this.spassword = spassword;
	}
	public String getSusername() {
		return susername;
	}
	public void setSusername(String susername) {
		this.susername = susername;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	@Override
	public String toString() {
		return "SigninBean [susername=" + susername + ", spassword=" + spassword + "]";
	}
	
}
