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
 * Servlet implementation class DetailInscription
 */
@WebServlet("/DetailInscription")
public class DetailInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String pswd = request.getParameter("pswd");

		out.println("<h1 style='color:blue'>Inscription succes :</h1>");
		out.println(" Bienvenue Mr " + nom + " " + prenom + "<br>");
		out.println(" Informations :<br>");
		out.println(" Login:" + login + "<br>");
		out.println(" Mot de passe:" + pswd + "<br>");
		ServletContext ctx = getServletContext();
		ArrayList<User> listUilisateur = (ArrayList) ctx.getAttribute("listUilisateur");
	
			out.println("<html>");
			out.println("<table border='1'>");
			out.println("<th>Nom</th>");
			out.println("<th>Prenom</th>");
			out.println("<th>Login</th>");
			out.println("<th>Password</th>");
			for (User user : listUilisateur) {
			out.println("<tr>");
			out.println("<td>" + user.getNom() + "</td>");
			out.println("<td>" + user.getPrenom() + "</td>");
			out.println("<td>" + user.getLogin() + "</td>");
			out.println("<td>" + user.getPswd() + "</td>");
			out.println("</tr>");
			}
			out.println("<table>");
			out.println("</html>");
			

		
	 
 	 

	}
}
