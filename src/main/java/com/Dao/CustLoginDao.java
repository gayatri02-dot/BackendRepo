package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.CustLoginBean;
import com.Util.DBConnection;

public class CustLoginDao {
	public String custauthrLogin(CustLoginBean obj) throws SQLException, ClassNotFoundException {
		System.out.println("dao called");
		String uname = obj.getUsername();
		System.out.println(uname);
		String upwd = obj.getPassword();
		System.out.println(upwd);
		
		Connection con = DBConnection.getDataConnection();
		
		PreparedStatement stmt = con.prepareStatement("select CustId, Pass from CustomerTable where CustId=? and Pass=?");
		
		stmt.setString(1, uname);
		stmt.setString(2, upwd);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			return "success";
		}
		
		
		
		
		return "Invalid Info";
	}
}