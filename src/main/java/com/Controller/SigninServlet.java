package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.Bean.SigninBean;
import com.Dao.SigninDao;

@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SigninServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("susername");
		String spass = request.getParameter("spassword");
		String cpass = request.getParameter("cpassword");
		
		RequestDispatcher rd = request.getRequestDispatcher("Index.html");
		
		SigninBean sgnbn = new SigninBean();
		sgnbn.setSusername(sname);
		sgnbn.setSpassword(spass);
		SigninDao sgndao = new SigninDao();
		
		try {
			String result = sgndao.adduser(sgnbn);
			if(result.equals("success")) {
				//response.getWriter().write("<h3>Login successful! Redirecting to Home.jsp...</h3>");

				
				rd.forward(request, response);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

