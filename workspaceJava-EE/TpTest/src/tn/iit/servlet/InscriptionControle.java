package tn.iit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InscriptionControle
 */
@WebServlet("/InscriptionControle")
public class InscriptionControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String pswd = request.getParameter("pswd");
		User user = new User(nom, prenom, login, pswd);

		ServletContext ctx = getServletContext();
		ArrayList<User> listUilisateur = (ArrayList) ctx.getAttribute("listUilisateur");

		if (listUilisateur == null) {
			listUilisateur = new ArrayList<User>();
			listUilisateur.add(user);
			ctx.setAttribute("listUilisateur", listUilisateur);

		} else {
			listUilisateur.add(user);
			ctx.setAttribute("listUilisateur", listUilisateur);

		}
		for (User user2 : listUilisateur) {
			System.out.println(user2);
		}
		getServletContext().getRequestDispatcher("/DetailInscription").forward(request, response);

	}

}
