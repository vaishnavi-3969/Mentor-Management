package com.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/mentor")
public class Mentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		try 
		{
			
			
		    Connection con=DBConnection.getC();
		    PreparedStatement ps=con.prepareStatement("insert into mentor_registration(name,contact,email,age,gender,branch,password)values(?,?,?,?,?,?,?)");
		
			String name=request.getParameter("name");
			System.out.println("Name"+name);
			String contact=request.getParameter("contact");
			System.out.println("Name"+contact);
			String email=request.getParameter("email");
			System.out.println("Name"+email);
			String age=request.getParameter("age");
			System.out.println("Name"+age);
			String gender=request.getParameter("gender");
			System.out.println("Name"+gender);
			
			String branch=request.getParameter("branch");
			System.out.println("Name"+branch);
			String pass=request.getParameter("password");
	
	

			ps.setString(1,name);
			ps.setString(2,contact);
			ps.setString(3,email);
			ps.setString(4,age);
			ps.setString(5,gender);
			ps.setString(6,branch);
			ps.setString(7,pass);
		
			
		    ps.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("/add_mentor.jsp");
			rd.forward(request, response);
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


