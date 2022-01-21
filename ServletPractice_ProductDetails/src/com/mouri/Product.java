package com.mouri;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ProductDetails")
public class Product extends HttpServlet {
	static Connection con; // = null;
	static PreparedStatement pstmt; // = null;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			//Here the text to be printed on the browser
			PrintWriter out = response.getWriter();
			//read the data entered in the html
			String prod_id = request.getParameter("prod_id");
		
			String prod_name = request.getParameter("prod_name");
			String prod_category = request.getParameter("prod_category");
			String prod_brand = request.getParameter("prod_brand");
			String prod_price = request.getParameter("prod_price");
			out.println("<h1> Product id = " +prod_id + "product Name = "+prod_name+
					"Product Category = "+prod_category + "Product Brand" + prod_brand+"product price" + prod_price + "</h1>");
			con = DBConnection.getDBConnection();
			String insertProduct = "insert into product values(?,?,?,?,?);";
			
			pstmt = con.prepareStatement(insertProduct);
			
			pstmt.setString(1, prod_id);
			pstmt.setString(2, prod_name);
			pstmt.setString(3, prod_price);
			pstmt.setString(4, prod_brand);
			pstmt.setString(5, prod_category);
			int i = pstmt.executeUpdate();
			if(i != 0) {
				out.println("inserted successfully");
			}else {
				out.println("Not inserted");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}		
		}
	}