package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.Bean.CustSigninBean;
import com.Dao.CustSigninDao;

@WebServlet("/CustomerSigninServlet")
public class CustomerSigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerSigninServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("susername");
		String spass = request.getParameter("spassword");
		String cpass = request.getParameter("cpassword");
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String mail = request.getParameter("mail");
		int num = Integer.parseInt(request.getParameter("number"));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Index1.html");
		
		CustSigninBean sgnbn = new CustSigninBean();
		sgnbn.setSusername(sname);
		sgnbn.setSpassword(spass);
		sgnbn.setName(name);
		sgnbn.setLname(lname);
		sgnbn.setMail(mail);
		sgnbn.setNumber(num);
		CustSigninDao sgndao = new CustSigninDao();
		
		try {
			String result = sgndao.addcustomer(sgnbn);
			if(result.equals("success")) {
				//response.getWriter().write("<h3>Login successful! Redirecting to Home.jsp...</h3>");

				
				rd.forward(request, response);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}