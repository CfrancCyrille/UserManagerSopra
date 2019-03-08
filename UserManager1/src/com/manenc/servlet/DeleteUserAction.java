package com.manenc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manenc.model.User;

@WebServlet("/DelUser")
public class DeleteUserAction extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public DeleteUserAction() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String EmailSup = request.getParameter("em");
		HttpSession session = request.getSession();
		
		Map<String, User> users = (HashMap<String, User>)session.getAttribute("users");
		
		users.remove(EmailSup);
		
		response.sendRedirect("http://localhost:8080/UserManager1/users");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
