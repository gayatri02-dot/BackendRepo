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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.DestiInfoBean;
import com.Dao.DestiInfoDao;

@WebServlet("/ShowAllInfoServlet")
public class ShowAllInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowAllInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DestiInfoBean> destinations = new ArrayList();
		DestiInfoDao ddao = new DestiInfoDao();
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("ShowAllInfo.jsp");
		
		try {
			
			destinations = ddao.allDestiInfo();
			
			if(destinations != null && destinations.isEmpty()) {
				out.println("Destinations are not available!!");
			}
			else {
				out.println("Destinations == "+destinations.size());
			}
			request.setAttribute("Destinations", destinations);
			
			rd.forward(request, response);
			
			
			
			
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
