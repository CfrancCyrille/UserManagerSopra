package com.ala.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import com.ala.servelet.PUser;

/**
 * Servlet implementation class registerServelet
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/register.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2= "pwd2";
	public static final String FIELD_NAME = "name";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Reset validation feedback attributes
		String msgErrorEmail="";
		String msgErrorPwd="";
		String msgErrorName="";
		String msgValidation="";
		request.setAttribute("msgErrorEmail", msgErrorEmail);
		request.setAttribute("msgErrorPwd", msgErrorPwd);
		request.setAttribute("msgErrorName", msgErrorName);
		request.setAttribute("msgValidation", msgValidation);
		// Display page
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
		
	}
	
	private String validateEmail( String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return new String("Veuillez saisir une adresse mail valide");
			}
		} else {
			return new String("L'adresse mail est obligatoire");
		}
		return null;
	}
	private String validatePwd(String pwd1, String pwd2){
		if (pwd1 != null && pwd2 != null) {	
			if ( ! (pwd1.equals(pwd2)) ) {
				return new String("Veuillez saisir les mêmes mots de passe");
			}
			if(pwd1.length() < 3 || pwd2.length() < 3) {
				return new String("Veuillez saisir un mot de passe de plus de 3 caractère");
			}
		} else {
			return new String("Les mots de passes sont obligatoires");
		}
		return null;
	}
	private String validateName(String name){
		if ( name == null || name.trim().length() == 0 ) {
			return new String("Le nom est obligatoire");
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		// Read parameters values
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);
		
		HashMap<String, String> form = new HashMap<String,String>();
		
		HashMap<String, String> errors = new HashMap<String, String>();
		
		String errMsg = validateEmail(email) ;
		if(errMsg!=null){
			errors.put(FIELD_EMAIL, errMsg);
		}
		
		errMsg = validateName(name);
		if(errMsg!=null){
			errors.put(FIELD_NAME, errMsg);
		}
		
		errMsg = validatePwd(pwd1, pwd2);
		if(errMsg!=null){
			errors.put(FIELD_PWD1, errMsg);
			errors.put(FIELD_PWD2, errMsg);
		}
		String actionMessage = null;
		Boolean actionMessageBoolean = false;
		if (errors.isEmpty()) {
			actionMessage = "Succès de l'inscription"; 
			actionMessageBoolean = true;
		}else {
			actionMessage = "Echec de l'inscription";
		}
		
		form.put(FIELD_EMAIL, email);
		form.put(FIELD_PWD1, pwd1);
		form.put(FIELD_PWD2, pwd2);
		form.put(FIELD_NAME, name);
		 
		 // Set validation feedback attributes
		 request.setAttribute("form", form);
		 request.setAttribute("errors", errors);
		 request.setAttribute("actionMessage", actionMessage);
		 HttpSession session = request.getSession();
		 if (actionMessageBoolean) {
			 PUser user = new PUser(email, name, pwd1);
			 @SuppressWarnings("unchecked")
			Map<String, PUser> users = (HashMap<String, PUser>) session.getAttribute("users");
			 if(users==null){
				users = new HashMap<String, PUser>();
			}
			 users.put(user.getEmail(), user);
			 session.setAttribute( "users", users );
			 
		}
		 // Display page again !
		 this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request,response);
		 }
}
