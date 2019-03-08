package com.ferrap.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ferrap.model.User;
import com.ferrap.utils.HashUtils;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_VIEW_PAGE = "/WEB-INF/login.jsp";
       

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(URL_VIEW_PAGE).forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String Email = request.getParameter("Email");
		String Mdp = request.getParameter("Password");
		
		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>)session.getAttribute("users");
		
		if(Email != null || Mdp != null)
		{
			if(users != null) 
			{
				User user = users.get(Email);
				
				String mdpUserHash = user.getMdp();
				String mdpHash = HashUtils.HashString(Mdp + user.getSalt());
				
				if(mdpUserHash.equals(mdpHash))
				{
					request.setAttribute("msgLogin", "Connection success");
				}
				else
				{
					request.setAttribute("msgLogin", "Mot de passe inconnu");
				}
				
			}
			else
			{
				System.out.println("Aucun utilisateur");
				request.setAttribute("msgLogin","Aucun utilisateur");
			}
		}
		else
		{
			request.setAttribute("msgLogin","Erreur syntaxe");
		}
		
		request.setAttribute("email",Email);
		
			
		
		doGet(request, response);
	}

}
