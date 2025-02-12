package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.SigninBean;
import com.Util.DBConnection;

public class SigninDao {

	public String adduser(SigninBean obj) throws ClassNotFoundException, SQLException {
		
		String user = obj.getSusername();
		String pass = obj.getSpassword();
		
		Connection con = DBConnection.getDataConnection();
		
		PreparedStatement stmt = con.prepareStatement("insert into UserTable values (?, ?)");
		
		stmt.setString(1, user);
		stmt.setString(2, pass);
		
		int rs = stmt.executeUpdate();
		
		if(rs>0) {
			return "success";
		}
		else {
			return "fail";
		}
		
	}
	
}