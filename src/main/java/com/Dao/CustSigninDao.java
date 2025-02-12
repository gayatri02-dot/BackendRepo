package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.CustSigninBean;
import com.Util.DBConnection;

public class CustSigninDao {

	public String addcustomer(CustSigninBean obj) throws ClassNotFoundException, SQLException {
		
		String user = obj.getSusername();
		String pass = obj.getSpassword();
		String name = obj.getName();
		String lname =obj.getLname();
		String mail =obj.getMail();
		int num =obj.getNumber();
		
		Connection con = DBConnection.getDataConnection();
		
		PreparedStatement stmt = con.prepareStatement("insert into CustomerTable values (?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, user);
		stmt.setString(2, pass);
		stmt.setString(3, name);
		stmt.setString(4, lname);
		stmt.setString(5, mail);
		stmt.setInt(6, num);
		
		int rs = stmt.executeUpdate();
		
		if(rs>0) {
			return "success";
		}
		else {
			return "fail";
		}
		
	}
	
}

