package adel.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CycleDeVie
 */
@WebServlet("/CycleDeVie")
public class CycleDeVie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int count = 0;
    final String DATE_COOKIE_KEY = "A";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CycleDeVie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter out = response.getWriter();
		//out.println("QUE TREPASSE SI JE FAIBLIS <br>");
		//count++
		//out.println(count);
		
		Cookie[] allCookies = request.getCookies();
		String lastDate = "";
		
		PrintWriter out = response.getWriter();
		if(allCookies != null){			
		for (int i = 0; i < allCookies.length; i++) {
			 Cookie cookie = allCookies[i];
			 if(cookie.getName().equals(DATE_COOKIE_KEY)){
			 lastDate = URLDecoder.decode(cookie.getValue(), "UTF-8");
			 out.print("Bienvenue ! Dernière visite le "+lastDate);
			 break;
			 }
			 }
		}else {
			 out.print("Bienvenue !");
		}
		String currentDate=(new Date()).toString();	
		Cookie dateCookie = new Cookie(DATE_COOKIE_KEY,URLEncoder.encode(currentDate.toString(), "UTF-8"));
		response.addCookie(dateCookie);
		
		HttpSession session = request.getSession();
		Integer count = (Integer)session.getAttribute("count");
		if (count == null) count = new Integer(1);
		else count = new Integer(count.intValue() + 1);
		session.setAttribute("count", count);
		response.getWriter().append("Vous avez visité cette page " + count + "fois.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
