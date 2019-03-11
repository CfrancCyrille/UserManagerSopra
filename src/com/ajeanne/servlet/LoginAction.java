package com.ajeanne.servlet;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL = "/WEB-INF/login.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
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
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("email") != null) {
			HttpSession session = request.getSession();

			Map<String, User> users = (Map<String, User>) session.getAttribute("users");

			if (users.containsKey(request.getParameter("email"))) {
				if (users.get(request.getParameter("email")).getPasswd().equals(request.getParameter("pwd"))) {
					session.setAttribute("login", users.get(request.getParameter("email")).getName());
					response.sendRedirect(request.getContextPath() + "/Index");
				} else {
					request.setAttribute("errors", "Le mot de passe est inccorect.");
				}
			} else {
				request.setAttribute("errors", "Utilisateur incorrect");
			}

		} else {
			request.setAttribute("errors", "Veuillez renseigner un utilisateur");
		}
		
		doGet(request, response);
	}
}
