package labede.com.servlet;

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
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_PAGE="/WEB-INF/register.jsp";
	final String FIELD_EMAIL = "email";
	final String FIELD_PWD = "pwd";
	final String FIELD_PWD2 = "pwd2";
	final String NAME = "name";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Reset validation feedback attributes
		String msgErrorEmail="";
		String msgErrorPwd="";
		String msgErrorName="";
		String msgValidation="";
		String valueEmail="";
		String valueName="";
		request.setAttribute("valueEmail", valueEmail);	
		request.setAttribute("valueName", valueName);	
		request.setAttribute("msgErrorEmail", msgErrorEmail);
		request.setAttribute("msgErrorPwd", msgErrorPwd);
		request.setAttribute("msgErrorName", msgErrorName);
		request.setAttribute("msgValidation", msgValidation);
		
		// Display page
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
		if ( users == null ) {
			users = new HashMap<String, User>();
		}
		
		// Read parameters values
		String email=request.getParameter(FIELD_EMAIL);
		String pwd1=request.getParameter(FIELD_PWD);
		String pwd2=request.getParameter(FIELD_PWD2);
		String name=request.getParameter(NAME);
		
		String actionMessage = "";
		Map<String, String> errors = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();
		
		User newUser = null;
		request.setAttribute("newUser", newUser);
		
		
		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("errorStatus", false);
		
		// Validate parameters
		// Email address parameter
		String msgErrorMail = validateEmail(email);
		if(msgErrorMail!=null) {
			errors.put(FIELD_EMAIL, msgErrorMail);
			form.put(FIELD_EMAIL, email);
		}
		else {
			form.put(FIELD_EMAIL, email);
		}
		// Password parameters...
		String msgErrorPwd = validatePwd(pwd1, pwd2);
		if(msgErrorPwd!=null) {
			errors.put(FIELD_PWD, msgErrorPwd);
			errors.put(FIELD_PWD2, msgErrorPwd);		
		}
		
		// Form validation
		if(msgErrorMail == null && msgErrorPwd == null){
			users.put( newUser.getEmail(), newUser );
			session.setAttribute( "users", users );
			actionMessage = "Inscription réussie";
		}
		else {
			actionMessage = "Inscription impossible";
		}
		
		// Set validation feedback attributes
		request.setAttribute("actionMessage", actionMessage);
		
		// Display page again !
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).include(request, response);
	}
	
	private String validateEmail( String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return "Veuillez saisir une adresse mail valide";
			}
		} else {
			return "L'adresse mail est obligatoire";
		}
		return null;
	}
	
	private String validatePwd(String pwd1, String pwd2) {
		if(pwd1 == null || pwd2 == null) {
			return "Mot de passe obligatoire";
		}
		if(pwd1.length() < 5) {
			return "Mot de passe trop court";
		}
		if(!pwd1.equals(pwd2)) {
			return "Mots de passe non identiques";
		}
		return null;
	}

}
