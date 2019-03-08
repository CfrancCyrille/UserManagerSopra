package adel.com.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	public static final String FIELD_LOGIN = "login";
	public static final String FIELD_PASSWORD = "password";
	public static String VIEW_PAGES_URL = "/WEB-INF/login.jsp";
       
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionMessage = null;
		Boolean atLeastOneError = false;
		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
		String login = request.getParameter(FIELD_LOGIN);
		String pass = request.getParameter(FIELD_PASSWORD);
		User newUser = null;
			if(users.get(login) != null)
			{
				newUser = users.get(login);
				try {
					pass += newUser.getSalt();
					pass = newUser.hash(pass);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(newUser.getPassword().equals(pass))
				{
					System.out.println("jui connecté !");
					session.removeAttribute("loggedUser");
					session.setAttribute("loggedUser", newUser);
					actionMessage = "Authentification réussie.";
					request.setAttribute("actionMessage", actionMessage);
					this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
				}
				else 
				{
					atLeastOneError = true;
				}
			}
			else 
			{
				atLeastOneError = true;
			}
			
			if(atLeastOneError)
			{
				actionMessage = "Erreur d'authentification.";
				request.setAttribute("actionMessage", actionMessage);
				this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
			}
	}

}
