package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImp;

public class DeleteMessage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sn = request.getParameter("sn");
		
		String res = new DeleteDaoImp().deleteMessage(Integer.parseInt(sn));
		HttpSession session = request.getSession();
		if (res.equals("deleted")) {
			session.setAttribute("msg", "data deleted successfully");
			response.sendRedirect("readmessage.jsp");
		} else {
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("readmessage.jsp");
		}
	}

}
