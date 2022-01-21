package com.mouritech;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CustomerRegistration")
public class CustomerRegistration extends HttpServlet {
	
	static Connection con;
	static PreparedStatement pstmt;
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//read the data enter in html
		String customerName = request.getParameter("cname");
		String customerEmail = request.getParameter("email");
		String customerPassword = request.getParameter("password");
		out.println("<h1>customerName ="+customerName+ "customerEmail ="+customerEmail+"customerPassword ="+customerPassword+"</h1>");
		
		con = DBconnection.getDBConnection();
		String insertCustomer = "insert into customer_reg values(?,?,?);";
		pstmt=con.prepareStatement(insertCustomer);
		pstmt.setString(1,customerName);
		pstmt.setString(2,customerEmail);
		pstmt.setString(3,customerPassword);
		int i=pstmt.executeUpdate();
		
		if(i != 0) {
			out.println("inserted successfully!");
		}
		else
		{
			out.println("not inserted..");
		}
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
