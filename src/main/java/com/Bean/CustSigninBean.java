package com.Bean;

public class CustSigninBean {
	String susername;
	String spassword;
	String name;
	String lname;
	String mail;
	int number;
	public CustSigninBean() {
		super();
	}
	public CustSigninBean(String susername, String spassword, String name, String lname, String mail, int number) {
		super();
		this.susername = susername;
		this.spassword = spassword;
		this.name=name;
		this.lname= lname;
		this.mail=mail;
		this.number=number;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "CustSigninBean [susername=" + susername + ", spassword=" + spassword + ", name=" + name + ", lname="
				+ lname + ", mail=" + mail + ", number=" + number + "]";
	}
	
	
}

