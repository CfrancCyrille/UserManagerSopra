package adel.com.servlet;

import java.io.Console;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PASSWORD = "password";
	public static final String FIELD_CONFIRMPASSWORD = "confirmPassword";
	public static final String FIELD_NAME = "name";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorStatus", true);
		// Display page
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PASSWORD);
		String pwd2 = request.getParameter(FIELD_CONFIRMPASSWORD);
		String name = request.getParameter(FIELD_NAME);
		String actionMessage = null;

		Map<String, String> errors = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();

		String errMsg = validateEmail(email);
		if (errMsg != null) {
			errors.put(FIELD_EMAIL, errMsg);

		} else {
			form.put(FIELD_EMAIL, email);
		}
		String errMsgMdp = validatePwd(pwd1, pwd2);
		if (errMsgMdp != null) {
			errors.put(FIELD_PASSWORD, errMsgMdp);
		} else {
			form.put(FIELD_PASSWORD, pwd1);
			form.put(FIELD_CONFIRMPASSWORD, pwd2);
		}
		if (errMsg == null && errMsgMdp == null) {
			User newUser = new User();
			String salt = generate(6);
			try {
				salt = newUser.hash(salt);
				pwd1 += salt;
				pwd1 = newUser.hash(pwd1);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newUser = new User(name, email, pwd1, salt);
			request.setAttribute("newUser", newUser);
			request.setAttribute("errorStatus", false);
			actionMessage = "Succès de l'inscription";
			HttpSession session = request.getSession();
			Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
			if (users == null) {
				users = new HashMap<String, User>();
			}
			users.put( newUser.getEmail(), newUser );
			session.setAttribute( "users", users );
		} else {
			request.setAttribute("errorStatus", true);
			actionMessage = "Échec de l'inscription";
			form.put(FIELD_NAME, name);
		}

		

		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);

		// Display page again !
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);

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
		if (!pwd1.equals(pwd2)) {
			return "Le champ de mot de passe et de confirmation doivent être identiques";
		} else if (pwd1 != null && pwd1.length() < 8) {
			return "Veuillez saisir un mot de passe valide (au minimum 8 caractères";
		}
		return null;
	}
	
	public String generate(int length){
	    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String pass = "";
	    for(int x=0;x<length;x++)
	    {
	       int i = (int)Math.floor(Math.random() * 62);
	       pass += chars.charAt(i);
	    }
	    return pass;
	}
}
