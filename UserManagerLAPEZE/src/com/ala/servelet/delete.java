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
 * Servlet implementation class delete
 */
@WebServlet("/del_user")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/users.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailParam = "emailParam";
		String param = request.getParameter(emailParam);
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, PUser> users = (HashMap<String, PUser>) session.getAttribute("users");
		
		for(Iterator<Entry<String, PUser>> it = users.entrySet().iterator(); it.hasNext(); ) {
		    Entry<String, PUser> entry = it.next();
		    if(entry.getKey().contains(param)) {
		        it.remove();
		    }
		}
		
		response.sendRedirect( request.getContextPath() + "/users" );
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
