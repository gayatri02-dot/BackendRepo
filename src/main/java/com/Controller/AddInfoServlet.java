package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.Bean.DestiInfoBean;
import com.Dao.DestiInfoDao;

@WebServlet("/AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

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
	}

}
