package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Bean.DestiInfoBean;
import com.Util.DBConnection;

public class DestiInfoDao {
	
	
//	public DestiInfoDao(){
//		Connection con = DBConnection.getDataConnection();
//	}

	public String addinfo(DestiInfoBean obj) throws SQLException, ClassNotFoundException {
		
		int did = obj.getDid();
		String dname = obj.getDname();
		String ddis = obj.getDdis();
		int dprice = obj.getDprice();
		
		Connection con = DBConnection.getDataConnection();
		PreparedStatement stmt = con.prepareStatement("insert into DestiInfo values(?, ?, ?, ?)");
		stmt.setInt(1, did);
		stmt.setString(2, dname);
		stmt.setString(3, ddis);
		stmt.setInt(4, dprice);
		
		int result =stmt.executeUpdate();
		if(result>0) {
			return "success";
		}
		else {
			return "fail";
		}
		
	}
	
	public String updateinfo(DestiInfoBean obj) throws SQLException, ClassNotFoundException {

		int did =obj.getDid();
		String dname = obj.getDname();
		String ddis = obj.getDdis();
		int dprice = obj.getDprice();
		
		Connection con = DBConnection.getDataConnection();
		PreparedStatement stmt = con.prepareStatement("Update DestiInfo set DestiName=?, DestiDiscription=?, DestiPrice=? where DestiId=?");
		
		
		stmt.setString(1, dname);
		stmt.setString(2, ddis);
		stmt.setInt(3, dprice);
		stmt.setInt(4, did);
		
		int result =stmt.executeUpdate();
		if(result>0) {
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String deleteinfo(DestiInfoBean obj) throws SQLException, ClassNotFoundException {

		int did =obj.getDid();
		
		Connection con = DBConnection.getDataConnection();
		PreparedStatement stmt = con.prepareStatement("Delete from DestiInfo where DestiId=?");
		
		stmt.setInt(1, did);
		
		int result =stmt.executeUpdate();
		if(result>0) {
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public List<DestiInfoBean> searchDestiByName(String dname) throws SQLException, ClassNotFoundException {
        List<DestiInfoBean> destis = new ArrayList<>();
        
        try (
        	Connection con = DBConnection.getDataConnection();
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DestiInfo WHERE DestiName = ?")) {
            pstmt.setString(1, dname);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	DestiInfoBean desti = new DestiInfoBean();
            	desti.setDid(rs.getInt("DestiId"));
            	desti.setDname(rs.getString("DestiName"));
            	desti.setDdis(rs.getString("Destidiscription"));
            	desti.setDprice(rs.getInt("DestiPrice"));
                destis.add(desti);
            }
        }
        return destis;
    }
	
	public List<DestiInfoBean> allDestiInfo() throws SQLException, ClassNotFoundException {
        List<DestiInfoBean> destis = new ArrayList<>();
        Connection con = DBConnection.getDataConnection();
        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DESTIINFO")) {
            ResultSet rs1 = pstmt.executeQuery();
            
            while (rs1.next()) {
            	DestiInfoBean desti = new DestiInfoBean();
            	desti.setDid(rs1.getInt("DestiId"));
            	desti.setDname(rs1.getString("DestiName"));
            	desti.setDdis(rs1.getString("Destidiscription"));
            	desti.setDprice(rs1.getInt("DestiPrice"));
            	System.out.println(desti);
                destis.add(desti);
            }
        }
        return destis;
    }
	

}
