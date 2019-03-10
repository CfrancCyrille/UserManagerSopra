package cfranc.com.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cfranc.com.bean.User;

/**
 * Servlet implementation class InfoSystem
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_FORM="/WEB-INF/register.jsp";
	public static Map<String, String> error = new HashMap<String, String>();
	public static Map<String, String> form = new HashMap<String, String>();
	public static String actionMessage = "Succès de l'inscription";
	public static Boolean errorStatus = false;
	
	public static Map<String, User> users;
	
	public static final String FIELD_NAME = "name";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_EMAIL = "email";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String validateEmail( String email ){	
    	if ( email != null && email.trim().length() != 0 ) {
    	if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
    		return "Veuillez saisir une adresse mail valide";
    	}
    	else {
    		return null;
    	}
    	} else {
    		return "L'adresse mail est obligatoire";
    	}
    }
    
    private String validatePwd(String pwd1, String pwd2) {
    	if ( pwd1 != null && pwd1.trim().length() != 0 && pwd2 != null && pwd2.trim().length() != 0 ) {
        	if ( !pwd1.equals(pwd2)) {
        	return "Les deux mots de passe ne sont pas identiques !";
        	}
        	else {
        		return null;
        	}
    	}
        	else {
        		return "Le mot de passe est obligatoire";
        	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_FORM).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter(FIELD_EMAIL);
		String pwd1=request.getParameter(FIELD_PWD1);
		String pwd2=request.getParameter(FIELD_PWD2);
		String name=request.getParameter(FIELD_NAME);
		
		String errorEmail = validateEmail(email);
		String errorPwd = validatePwd(pwd1, pwd2);
		User newUser=null;
		
		HttpSession session = request.getSession();
		
		
		if (errorEmail != null)
		{
			error.put(FIELD_EMAIL, errorEmail);	
		}
		else {
			error.put(FIELD_EMAIL, errorEmail);
			form.put(FIELD_EMAIL, email);
		}
		
		if (errorPwd != null)
		{
			error.put(FIELD_PWD1, errorPwd);
		}
		else {
			error.put(FIELD_PWD1, errorPwd);
			form.put(FIELD_PWD1, pwd1);
			form.put(FIELD_PWD2, pwd2);
		}
		
		
		form.put(FIELD_NAME, name);
		
		if (errorEmail != null || errorPwd != null)
		{
			actionMessage = "Echec de l'inscription";
			errorStatus = false;
		}
		else {
			newUser=new User(name,email,pwd1);
			newUser.setName(name);
			newUser.setPwd(pwd1);
			newUser.setEmail(email);
			request.setAttribute("newUser", newUser);
			actionMessage = "Succès de l'inscription";
			errorStatus = true;
			
			users = (HashMap<String, User>) session.getAttribute("users" );
			if(users==null){
				users = new HashMap<String, User>();
			}
			
			users.put( newUser.getEmail(), newUser );
			session.setAttribute( "users", users );
		}
		
		request.setAttribute("error", error);
		request.setAttribute("form", form);
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("errorStatus", errorStatus);
		
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_FORM).forward(request, response );
	}

}
