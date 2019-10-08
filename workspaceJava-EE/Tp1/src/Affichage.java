
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Affichage
 */
@WebServlet("/Affichage")
public class Affichage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String code = request.getParameter("code");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		String[] centre = request.getParameterValues("centre");
		String message = request.getParameter("message");

		PrintWriter out = response.getWriter();
		out.println("<h1>Affichge :</h1>");
		out.println("Civilité : " + civilite.toString() + "<br>");
		out.println("Nom : " + nom.toString() + "<br>");
		out.println("Prenom :" + prenom.toString() + "<br>");
		out.println("Adresse :" + adresse.toString() + "<br>");
		out.println("Code : " + code.toString() + "<br>");
		out.println("Ville : " + ville.toString() + "<br>");
		out.println("Pays : " + pays.toString() + "<br>");
		out.println("Centres d\"interets : " + "<br>");
		for (String c : centre) {
			out.println(c.toString() + " ");
		}
		out.println("<br>");
		out.println("Message :" + message.toString() + "<br>");

	}

}



