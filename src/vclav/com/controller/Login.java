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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String TEMPLATE_URL_LOGIN = "/WEB-INF/user/login.jsp";
	public static final String FIELD_LOGIN = "login";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(TEMPLATE_URL_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpSevletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login = request.getParameter("email");
		String password = request.getParameter("password");
		HashMap<String, String> errors = new HashMap<String, String>();
		String msg = null;

		if ((msg = validate(login, password)) != null) { errors.put(FIELD_LOGIN, msg); }

		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
		if (users == null)
		{
			errors.put(FIELD_LOGIN, "Login ou mot de passe incorrect !");
		} else
		{
			User user = users.get(login);
			if (user == null || user.getPassword() != password)
			{
				errors.put(FIELD_LOGIN, "Login ou mot de passe incorrect !");
			} else
			{
				request.setAttribute("user", user);
			}
		}
		

		if (!errors.isEmpty())
		{
			HashMap<String, String> form = new HashMap<String, String>();
			form.put(FIELD_LOGIN, login);
			request.setAttribute("form", form);
			request.setAttribute("errors", errors);
			request.setAttribute("errorStatus", true);
		} else
		{
			request.setAttribute("errorStatus", false);
		}

		this.getServletContext().getRequestDispatcher(TEMPLATE_URL_LOGIN).forward(request, response);
	}

	private String validate(String login, String password)
	{
		if (password == null || login.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
		{
			return "Login ou mot de passe incorrect !";
		}

		return null;
	}
}
