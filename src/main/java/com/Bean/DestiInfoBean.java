package com.Bean;

public class DestiInfoBean {
	
	int did;
	String dname;
	String ddis;
	int dprice;

	public DestiInfoBean() {
		super();
	}
	

	public DestiInfoBean( int did, String dname, String ddis, int dprice) {
		super();
		this.did = did;
		this.dname = dname;
		this.ddis = ddis;
		this.dprice = dprice;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdis() {
		return ddis;
	}

	public void setDdis(String ddis) {
		this.ddis = ddis;
	}

	public int getDprice() {
		return dprice;
	}

	public void setDprice(int dprice) {
		this.dprice = dprice;
	}


	@Override
	public String toString() {
		return "DestiInfoBean [did=" + did +", dname=" + dname + ", ddis=" + ddis + ", dprice=" + dprice + "]";
	}
	
	

}
