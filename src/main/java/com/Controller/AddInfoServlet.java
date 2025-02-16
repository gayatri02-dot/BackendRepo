package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.DestiInfoBean;
import com.Dao.DestiInfoDao;
import com.Util.DBConnection;

@WebServlet("/AddInfoServlet")

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10, // 10MB
	    maxRequestSize = 1024 * 1024 * 50, // 50MB
	    location = "E:/Backend Project/Travel Data Project/src/main/webapp/AllImages/" // Ensure this folder exists
	)
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	private static final String UPLOAD_DIRECTORY = "E:/Backend Project/Travel Data Project/src/main/webapp/AllImages/";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int did = Integer.parseInt(request.getParameter("did"));
		String dname = request.getParameter("dname");
		String ddis = request.getParameter("ddis");
		int dprice = Integer.parseInt(request.getParameter("dprice"));
		
		RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
		RequestDispatcher rd2 =request.getRequestDispatcher("Login.html");
		
		PrintWriter out = response.getWriter();
		
		DestiInfoBean disifbean = new DestiInfoBean();
		disifbean.setDid(did);
		disifbean.setDname(dname);
		disifbean.setDdis(ddis);
		disifbean.setDprice(dprice);
		
		DestiInfoDao disifdao = new DestiInfoDao();
		
		try {
			
			String result = disifdao.addinfo(disifbean);
			
			if(result == "success") {
				out.println("Information Added Successfully!!!");
				rd1.forward(request, response);
			}
			else {
				out.println("Error Occure!!!");
				rd2.include(request, response);
			}
			
			
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		

	        PrintWriter out1 = response.getWriter();
	        
	        // Ensure directory exists
	        File uploadDir = new File(UPLOAD_DIRECTORY);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs(); // Create directory if not present
	        }

	        // Get the uploaded file
	        Part filePart = request.getPart("file");
	        String fileName = filePart.getSubmittedFileName();

//	        if (fileName != null && !fileName.isEmpty()) {
//	            String filePath = UPLOAD_DIRECTORY + fileName;
//	            filePart.write(filePath); // Save file to folder

	            try (Connection con = DBConnection.getDataConnection()) {
	                String sql = "INSERT INTO images (img_id, filename) VALUES (?, ?)";
	                PreparedStatement stmt = con.prepareStatement(sql);
	                stmt.setInt(1, did);
	                stmt.setString(2, fileName);
	                stmt.executeUpdate();
	                stmt.close();

	                out1.println("Image uploaded successfully!");
	            } catch (Exception e) {
	                e.printStackTrace();
	                out1.println("Error saving image name.");
	            }
//	        } else {
//	            out.println("Please select a file.");
//	        }
	    }

	

}
