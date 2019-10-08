package tn.iit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentification
 */
@WebServlet(urlPatterns = { "/Authentification", "/iit.tn" }

)
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		System.out.println("Bonjour");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String erreur = (String) request.getAttribute("erreur");
		if (erreur != null)
			out.println("<h1 style=\"color:red\">" + erreur + "</h1>");

		out.println("<h1>Authentification :</h1>");
		out.println("<form method='post' action='AuthControle' >" + "Login : <input  type='text' name='login' value=' "
				+ ((login != null) ? login : "") + "'/><br>" + "  	MP : <input  type='text' name='mp' />"
				+ "  	<br>" + "  	 <input type='submit' value='Go' />" + "</form>");

		out.println("<form method='post' action='Inscription'>");

		out.println("<input type='submit' value='Inscription' />");
		out.println("</form>");

	}

}


