package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.Bean.DestiInfoBean;
import com.Dao.DestiInfoDao;

@WebServlet("/SearchInfoServlet")
public class SearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dname = request.getParameter("dname");
		
		DestiInfoDao ddao = new DestiInfoDao();
		List<DestiInfoBean> destinations = null;
		
		try {
			if(dname != null || dname!="") {
				destinations = ddao.searchDestiByName(dname);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("alldestinations", destinations);
		
		RequestDispatcher rd = request.getRequestDispatcher("Home1.jsp");
		rd.include(request, response);
		
	}

}
