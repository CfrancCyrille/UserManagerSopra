package ralleg.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_PAGE = "/WEB-INF/login.jsp";
	public static final String VIEW_PAGE_INDEX = "/WEB-INF/index.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Display page
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpSevletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usrLogin = request.getParameter("username");
		String usrPwd = request.getParameter("password");

		String error = "";
		boolean connected = false;
		boolean errorStatus = false;

		HttpSession session = request.getSession();

		if (session != null) {

			HashMap<String, User> users = (HashMap<String, User>) session.getAttribute("users");

			if (session.getAttribute("currentUser") != null) {
				connected = true;
			}

			if (users != null) {

				if (usrLogin != null) {

					if (usrPwd != null) {
						if (!users.containsKey(usrLogin)) {
							error = "Nom d'utilisateur ou mot de passe incorrect.";
							errorStatus = true;
						} else {
							if (!users.get(usrLogin).getPwd1().equals(usrPwd)) {
								error = "Nom d'utilisateur ou mot de passe incorrect.";
								errorStatus = true;
							} else {
								session.setAttribute("currentUser", users.get(usrLogin).getName());
								this.getServletContext().getRequestDispatcher(VIEW_PAGE_INDEX).forward(request,
										response);
							}
						}
					} else {
						error = "Veuillez entrer un mot de passe.";
						errorStatus = true;
					}
				} else {
					error = "Veuillez entrer un nom d'utilisateur.";
					errorStatus = true;
				}

			} else {
				error = "Il n'y a pas d'utilisateur enregistré.";
				errorStatus = true;
			}

			request.setAttribute("error", error);
			request.setAttribute("errorStatus", errorStatus);
			request.setAttribute("connected", connected);

		}

		this.getServletContext().getRequestDispatcher(VIEW_PAGE).include(request, response);

	}

}
