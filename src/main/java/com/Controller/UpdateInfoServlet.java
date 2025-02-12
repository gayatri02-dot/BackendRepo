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

@WebServlet("/UpdateInfoServlet")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateInfoServlet() {
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
		
		try {
			DestiInfoBean dbean = new DestiInfoBean();
			
			dbean.setDid(did);
			dbean.setDname(dname);
			dbean.setDdis(ddis);
			dbean.setDprice(dprice);
			
			DestiInfoDao ddao = new DestiInfoDao();
			
			String result = ddao.updateinfo(dbean);
			
			PrintWriter out = response.getWriter();
			
			if(result == "success") {
				out.println("Value updated Successfully!!");
			}
			else
				out.println("Value Not Updated!!");
			request.setAttribute("updateResult", result);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        
		RequestDispatcher rd = request.getRequestDispatcher("UpdateInfo.jsp");
		rd.forward(request, response);
		
	}

}
