package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.Bean.LoginBean;
import com.Dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		session.setAttribute("user", name);
		
		RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("Index.html");	
		
		
		LoginBean lgnben = new LoginBean();
		
		lgnben.setUsername(name);
		lgnben.setPassword(pass);
		
		
		LoginDao lgndao = new LoginDao();
		
		try {
			
			String result = lgndao.authUserLogin(lgnben);
			
			if("success".equals(result)) {
				
				rd1.forward(request, response);
			}
			else {
				rd2.include(request, response);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		
	}

}
