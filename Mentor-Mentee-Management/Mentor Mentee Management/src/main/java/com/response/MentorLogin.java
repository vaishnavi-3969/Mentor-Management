package com.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connection.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/login")
public class MentorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		try 
		{
			String email=request.getParameter("email");
			String pass=request.getParameter("password");
	
		    Connection con=DBConnection.getC();
		    Statement st=con.createStatement();
		    ResultSet rs =st.executeQuery("select * from registration where email='"+email+"' and password='"+pass+"' ");
		    if(rs.next())
		    {
		    	response.sendRedirect("index.html");
		    }
		    else
		    {
		    	response.sendRedirect("login.jsp");
		    }
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		out.flush();
		out.close();


	}
	public void destroy()
	{
		super.destroy();
	}

		
		
		
	}


