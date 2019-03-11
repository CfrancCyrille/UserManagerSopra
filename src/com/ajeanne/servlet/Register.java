package com.ajeanne.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";
	private static String FIELD_EMAIL = "email";
	private static String FIELD_PWD1 = "pwd1";
	private static String FIELD_PWD2 = "pwd2";
	private static String FIELD_NAME = "name";

	private boolean errorStatus = false;
	private User newUser = null;

	private HashMap<String, String> form;
	private HashMap<String, String> errors;
	private String actionMessage;

	private String validateEmail(String email) {
		String msg = null;
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				msg = "Veuillez saisir une adresse email valide";
			}
		} else {
			msg = "L'adresse mail est obligatoire";

		}
		return msg;
	}

	private String validatePwd(String pwd1, String pwd2) {
		String msg = null;

		if (!pwd1.equals(pwd2)) {
			msg = "Les deux mots de passe ne correspondent pas";
		} else if (pwd1.length() < 3) {
			msg = "mot de passe invalide";
		}
		return msg;
	}

	private void validateName(String name) throws Exception {

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		Map<String, User> users = (Map<String, User>) session.getAttribute("users");
		if (users == null) {
			users = new HashMap<String, User>();
		}

		if (newUser != null) {
			users.put(newUser.getEmail(), newUser);
			session.setAttribute("users", users);
		}

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getErrors().clear();
		getForm().clear();
		// TODO Auto-generated method stub
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);

		String errMsg = validateEmail(email);
		if (errMsg != null) {
			getErrors().put(FIELD_EMAIL, errMsg);
		} else {
			getForm().put(FIELD_EMAIL, email);
		}

		getForm().put(FIELD_NAME, name);

		errMsg = validatePwd(pwd1, pwd2);
		if (errMsg != null) {
			getErrors().put(FIELD_PWD1, errMsg);
		} else {
			getForm().put(FIELD_PWD1, pwd1);
			getForm().put(FIELD_PWD2, pwd2);
		}

		if (getErrors().isEmpty()) {
			actionMessage = "Succès de l'inscription";
			newUser = new User(email, name, pwd1);
			request.setAttribute("newUser", newUser);
			errorStatus = false;
		} else {
			actionMessage = "Echec de l'inscription";
			errorStatus = true;
		}

		request.setAttribute("form", getForm());
		request.setAttribute("errors", getErrors());
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("errorStatus", errorStatus);
		doGet(request, response);
	}

	private HashMap<String, String> getForm() {
		// TODO Auto-generated method stub
		if (form == null) {
			form = new HashMap<String, String>();
		}
		return form;
	}

	private HashMap<String, String> getErrors() {
		// TODO Auto-generated method stub
		if (errors == null) {
			errors = new HashMap<String, String>();
		}
		return errors;
	}

}
