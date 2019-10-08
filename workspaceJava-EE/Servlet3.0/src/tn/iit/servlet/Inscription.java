package tn.iit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<h1>Inscription :</h1>");

		out.println("<form method='post' action='InscriptionControle'>");
		out.println("Nom : <input  type='text' name='nom'<br> ");
		out.println("Prénom : <input  type='text' name='prenom'<br> ");
		out.println("login : <input  type='text' name='login'<br> ");
		out.println("Mot de passe : <input  type='text' name='pswd'<br> ");
		out.println("<input type='submit' value='Inscription' />");
		out.println("</form>");
	

		

	}
}
