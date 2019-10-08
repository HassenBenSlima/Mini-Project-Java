package iit.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Bonjour Servlet");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentification() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String err = (String) request.getAttribute("erreur");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		out.println("<h1> Authentification:</h1>");

		if (err != null) {
			out.println("<h1> " + err + "</h1>");

		}
		out.println("<form method='post' action='AuthControle'> ");
		if (login != null) {
			out.println("Login: <input type='text' value='" + login + "'name='login'/>");
		} else {
			out.println("Login: <input type='text' name='login'/>");
		}

		out.println("Mot de passe: <input type='text' name='pass'/></br></br>");
		out.println("<input value='connect' type='submit' /></br>");
		out.println("</form>");

	}

}
