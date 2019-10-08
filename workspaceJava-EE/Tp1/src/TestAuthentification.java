
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAuthentification
 */
@WebServlet("/TestAuthentification")
public class TestAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("password");

		PrintWriter out = response.getWriter();
		if ("hassen".equals(login) && "hassen".equals(pass)) {
			out.println("<h1>Authentification : Welcom</h1>");
			out.println("Your Login : " + login.toString() + "<br>");
			out.println("Your Password : " + pass.toString() + "<br>");
		} else  if ("hssouna".equals(login) && "hssouna".equals(pass)) {
			
			response.sendRedirect("/Tp1/success.html");
	
		}else {
			out.println("Failed authentification");

		}
		
	
	}

}
