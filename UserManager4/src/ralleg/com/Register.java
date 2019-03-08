package ralleg.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_PAGE = "/WEB-INF/register.jsp";

	private static final String FIELD_EMAIL = "email";

	private static final String FIELD_PWD1 = "pwd1";

	private static final String FIELD_PWD2 = "pwd2";

	private static final String FIELD_NAME = "name";

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

		// Display page
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
		if (users == null) {
			users = new HashMap<String, User>();
		}

		// Read parameters values
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);

		// Validate parameters
		// Message d'erreur validation des champs
		Map<String, String> errors = new HashMap<String, String>();

		// Stocke mes champs corrects
		Map<String, String> form = new HashMap<String, String>();

		// Email address parameter
		String msgErrorEmail = validateEmail(email);
		if (msgErrorEmail != null) {
			errors.put(FIELD_EMAIL, msgErrorEmail);
		} else {
			form.put(FIELD_EMAIL, email);
		}

		// Password parameters...
		String msgErrorPwd = validatePwd(pwd1, pwd2);
		if (msgErrorPwd != null) {
			errors.put(FIELD_PWD1, msgErrorPwd);
		} else {
			form.put(FIELD_PWD1, pwd1);
		}

		// Name parameter...
		String msgErrorName = validateName(name);
		if (msgErrorName != null) {
			errors.put(FIELD_NAME, msgErrorName);
		} else {
			form.put(FIELD_NAME, name);
		}

		// Form validation
		String actionMessage = "";
		if (msgErrorEmail == null && msgErrorName == null && msgErrorPwd == null) {
			actionMessage = "Succès de l'inscription";
			User newUser = null;
			newUser = new User(name, email, pwd1);
			users.put(newUser.getEmail(), newUser);
			session.setAttribute("users", users);
			request.setAttribute("user", newUser);
		} else {
			request.setAttribute("errorStatus", false);
			actionMessage = "Echec de l'inscription";
		}

		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);

		// Display page again !
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).include(request, response);
	}

	private String validateEmail(String email) {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				return "Veuillez saisir une adresse mail valide";
			}
		} else {
			return "L'adresse mail est obligatoire";
		}
		return null;
	}

	private String validatePwd(String pwd1, String pwd2) {
		if (pwd1 == null || pwd1.length() < 3) {
			return "mot de passe invalide";
		}
		if (!pwd1.equals(pwd2)) {
			return "Les mots de passes ne sont pas identiques";
		}
		return null;
	}

	private String validateName(String name) {
		return null;
	}

}
