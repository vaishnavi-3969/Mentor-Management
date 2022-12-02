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
 * Servlet implementation class Task
 */
@WebServlet("/task")
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try 
		{
			
			
		    Connection con=DBConnection.getC();
		    PreparedStatement ps=con.prepareStatement("insert into task(task_date,task_description)values(?,?)");
		
			String date=request.getParameter("date");
			
			String des=request.getParameter("description");
			
			
		
	

			ps.setString(1,date);
			ps.setString(2,des);
	
			
		    ps.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("/task.jsp");
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

