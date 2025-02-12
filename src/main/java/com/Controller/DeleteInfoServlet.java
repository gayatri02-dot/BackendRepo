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

@WebServlet("/DeleteInfoServlet")
public class DeleteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int did = Integer.parseInt(request.getParameter("did"));
		
		try {
			DestiInfoBean dbean = new DestiInfoBean();
			
			dbean.setDid(did);
			
			DestiInfoDao ddao = new DestiInfoDao();
			
			String result = ddao.deleteinfo(dbean);
			
			PrintWriter out = response.getWriter();
			
			if(result == "success") {
				out.println("Value Deleted Successfully!!");
			}
			else
				out.println("Value Not Deleted!!");
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("DeleteInfo.jsp");
		rd.forward(request, response);
		
	}

}
