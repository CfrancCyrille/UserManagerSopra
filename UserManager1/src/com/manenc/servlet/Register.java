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
import com.manenc.utils.HashUtils;
import com.manenc.utils.ValideField;


@WebServlet("/Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static String URL_VIEW_PAGE = "/WEB-INF/register.jsp";
       
    public Register() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		this.getServletContext().getRequestDispatcher(URL_VIEW_PAGE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String PasswordConfirm = request.getParameter("PasswordConfirm");
		String Pseudo = request.getParameter("Pseudo");
		
		String msgErrorEmail = ValideField.ValidateEmail(Email);
		String msgErrorPassword = ValideField.ValidatePassword(Password, PasswordConfirm);
		String msgErrorPseudo = ValideField.ValidatePseudo(Pseudo);
		
		String msgValidation = "";
		
		if(msgErrorEmail == "" && msgErrorPassword == "" && msgErrorPseudo == "") 
		{
			msgValidation = "<p style=\"color:green;\">Register success</p><br>";
			
			String salt = HashUtils.RandomSalt();
			String mdpUser = HashUtils.HashString(Password + salt);
			
			User user = new User(Email, mdpUser, Pseudo, salt);
			
			
			HttpSession session = request.getSession();
			Map<String, User> users = (HashMap<String, User>)session.getAttribute("users");
			
			if(users == null) 
			{
				users = new HashMap<String, User>();
			}
			
			users.put(user.getEmail(), user);
			
			request.setAttribute("user",user);
			request.setAttribute("isSuccess", true);
			session.setAttribute("users", users);
			
		}
		else
		{
			msgValidation = "<p style=\"color:red;\">Sign-up failed</p><br>";
			request.setAttribute("isSuccess", false);
		}
		
		Map<String, String> form = new HashMap<String, String>();
		form.put("email", Email);
		form.put("pwd", Password);
		form.put("pwdConfirm", PasswordConfirm);
		form.put("pseudo",Pseudo);
		
		Map<String, String> error = new HashMap<String, String>();
		error.put("email", msgErrorEmail);
		error.put("pwd", msgErrorPassword);
		error.put("pseudo", msgErrorPseudo);
		
		request.setAttribute("form",form);
		request.setAttribute("error", error);
		request.setAttribute("msgValidation", msgValidation);		
		
		
		this.getServletContext().getRequestDispatcher(URL_VIEW_PAGE).forward(request, response );
	}

}
