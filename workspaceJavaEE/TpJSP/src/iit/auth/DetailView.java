package iit.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iit.auth.enities.Etudiant;

/**
 * Servlet implementation class DetailView
 */
@WebServlet("/DetailView")
public class DetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Etudiant> etuds = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Etudiant e = (Etudiant) request.getAttribute("courant");

		PrintWriter out = response.getWriter();
		out.println("<h1>Authentification : Welcome</h1>");
		out.println("Your Login : " + e.getLogin() + "<br>");
		out.println("Your Password : " + e.getPassword() + "<br>");
		out.println("Your Name : " + e.getNom() + "<br>");
		out.println("Your lastname : " + e.getPrenom() + "<br>");
		out.println("<form method='post' action='Authentification'> ");
		out.println("<input value='Deconnect' type='submit' />");
		out.println("</form > ");

	}
}
