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
 * Servlet implementation class DeleteUserAction
 */
@WebServlet(name = "Delete", urlPatterns = {"/del-user"})
public class DeleteUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/UserManager4/users";
	
	public static final String FIELD_EMAIL = "email";

	public static Map<String, User> users;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String emailSupp = request.getParameter("em");
		HttpSession session = request.getSession();
		users = (HashMap<String, User>) session.getAttribute("users" );
		
		users.remove(emailSupp);
		response.sendRedirect(VIEW_PAGES_URL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
