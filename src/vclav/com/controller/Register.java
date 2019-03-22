package vclav.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vclav.com.bean.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String VIEW_PAGES_URL = "/WEB-INF/user/register.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_PASSWORD = "password";
	public static final String FIELD_PASSWORD_REPEAT = "passwordRepeat";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter(FIELD_NAME);
		String email = request.getParameter(FIELD_EMAIL);
		String password = request.getParameter(FIELD_PASSWORD);
		String passwordRepeat = request.getParameter(FIELD_PASSWORD_REPEAT);
		HashMap<String, String> flashMessage = new HashMap<String, String>();
		HashMap<String, String> errors = new HashMap<String, String>();
		String msg = null;
		
		if((msg = validateName(name)) != null) { errors.put(FIELD_NAME, msg); }
		if((msg = validateEmail(email)) != null) { errors.put(FIELD_EMAIL, msg); }
		if((msg = validatePassword(password, passwordRepeat)) != null) { errors.put(FIELD_PASSWORD, msg); }
		
		if(!errors.isEmpty())
		{
			HashMap<String, String> form = new HashMap<String, String>();
			form.put(FIELD_NAME, name);
			form.put(FIELD_EMAIL, email);
			
			flashMessage.put("type", "danger");
			flashMessage.put("message", "Echec de l'inscription");
			
			request.setAttribute("flashMessage", flashMessage);
			request.setAttribute("form", form);
			request.setAttribute("errors", errors);
			request.setAttribute("errorStatus", true);
		} else
		{
			User user = new User(name, email, password);
			HttpSession session = request.getSession();
			Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
			if (users == null)
			{
				users = new HashMap<String, User>();
			}
			users.put(email, user);
			session.setAttribute("users", users);

			flashMessage.put("type", "success");
			flashMessage.put("message", "Succès de l'inscription");

			request.setAttribute("flashMessage", flashMessage);
			request.setAttribute("user", user);
			request.setAttribute("errorStatus", false);
		}
		
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}
	

	private String validateEmail(String email)
	{
		if (email == null || email.trim().length() == 0) 
		{
			return "L'adresse mail est obligatoire";
		}

		if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) 
		{
			return "Veuillez saisir une adresse mail valide";
		}

		return null;
	}

	private String validateName(String name) 
	{
		final int minLenght = 3;

		if (name != null && name.trim().length() != 0 && name.trim().length() < minLenght)
		{
			return "Le nom doit faire au moins " + minLenght + " caractères";
		}

		return null;
	}

	private String validatePassword(String pwd1, String pwd2) 
	{
		final int minLenght = 8;

		if (pwd1 == null || pwd1.trim().length() == 0) 
		{
			return "Le mot de passe est obligatoire";
		}

		if (pwd1.trim().length() < minLenght) 
		{
			return "Le mot de passe doit faire au moins " + minLenght + " caractères";
		}

		if (!pwd1.contentEquals(pwd2)) 
		{
			return "Les mots de passe de sont pas identiques";
		}

		return null;
	}
}
