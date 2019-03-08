package com.ala.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/login.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD = "pwd";
	public static String ACTIONMESSAGE = "Echec de la connexion";
	public static Boolean ACTIONMESSAGEBOOLEAN = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msgErrorEmail="";
		String msgErrorPwd="";
		String msgValidation="";
		request.setAttribute("msgErrorEmail", msgErrorEmail);
		request.setAttribute("msgErrorPwd", msgErrorPwd);
		request.setAttribute("msgValidation", msgValidation);
		

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter(FIELD_EMAIL);
		String pwd = request.getParameter(FIELD_PWD);
		
		
		
		HashMap<String, String> form = new HashMap<String,String>();
		
		HashMap<String, String> errors = new HashMap<String, String>();
		
		String errMsg = validateEmail(email) ;
		if(errMsg!=null){
			errors.put(FIELD_EMAIL, errMsg);
		}
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, PUser> users = (HashMap<String, PUser>) session.getAttribute("users");

		for(Iterator<Entry<String, PUser>> it = users.entrySet().iterator(); it.hasNext(); ) {
		    Entry<String, PUser> entry = it.next();
		    if(entry.getKey().equals(email) && entry.getValue().getPwd().equals(pwd)) {
		    	ACTIONMESSAGE = "Succès de la connexion"; 
				ACTIONMESSAGEBOOLEAN = true;
				PUser user = new PUser(email, entry.getValue().getNom(), entry.getValue().getPwd());
				session.setAttribute( "newUser", user );
		    }
		}
		
		form.put(FIELD_EMAIL, email);
		 
		 // Set validation feedback attributes
		 request.setAttribute("form", form);
		 request.setAttribute("errors", errors);
		 request.setAttribute("actionMessage", ACTIONMESSAGE);
		 this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request,response);
	}
}	