package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertDaoImp;

public class SaveMessage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		//Validation
		
		//dao
		String res = new InsertDaoImp().saveMessage(name, email, message);
		HttpSession session = request.getSession();
		if(res.equals("saved"))
		{
			session.setAttribute("msg", "message sent successfully");
			response.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("index.jsp");
		}
	}

}
