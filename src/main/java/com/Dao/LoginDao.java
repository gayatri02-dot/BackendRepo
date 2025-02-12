package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.LoginBean;
import com.Util.DBConnection;

public class LoginDao {

	public String authUserLogin(LoginBean obj) throws SQLException, ClassNotFoundException {
		
		String uname = obj.getUsername();
		String upwd = obj.getPassword();
		
		Connection con = DBConnection.getDataConnection();
		if (con == null) {
		    throw new SQLException("Failed to establish a database connection.");
		}
		
		PreparedStatement stmt = con.prepareStatement("select User, Pass from UserTable where User=? and Pass=?");
		
		stmt.setString(1, uname);
		stmt.setString(2, upwd);
		
		try(ResultSet rs = stmt.executeQuery()){
		
		if(rs.next()) {
			return "success";
		}
		}
		
		
		
		return "Invalid Info";
	}

}
