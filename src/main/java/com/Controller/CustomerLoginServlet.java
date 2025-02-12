package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.Bean.CustLoginBean;
import com.Dao.CustLoginDao;



@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
	    response.getWriter().write("<h1>LoginServlet invoked successfully</h1>");
		
		String name = request.getParameter("username");
		response.getWriter().write(name);
		String pass = request.getParameter("password");
		response.getWriter().write(pass);
		
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("Home1.html");
		RequestDispatcher rd2 = request.getRequestDispatcher("Index1.html");
			
		
		
		CustLoginBean lgnben = new CustLoginBean();
		
		lgnben.setUsername(name);
		lgnben.setPassword(pass);
		
		
		CustLoginDao lgndao = new CustLoginDao();
		
			
			
			try {
				String result = lgndao.custauthrLogin(lgnben);
				//response.getWriter().write("Authentication result: " + result);
				
				if(result.equals("success")) {
					//response.getWriter().write("<h3>Login successful! Redirecting to Home.jsp...</h3>");

					
					rd1.forward(request, response);
				}
				else {
					out.print("invalid!");
					rd2.include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
			
			
		
		
		
	}

}