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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_PAGE="/WEB-INF/users.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
		String mail = request.getParameter("user_to_delete");
		users.remove(mail);
		
		// return on user list page
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// return on user list page
		this.getServletContext().getRequestDispatcher(VIEW_PAGE).forward(request, response);
	}

}
