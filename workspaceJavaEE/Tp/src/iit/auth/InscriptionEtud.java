package iit.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class InscriptionEtud
 */
@WebServlet("/InscriptionEtud")
public class InscriptionEtud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionEtud() {
		super();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<h1> Inscription: Cette Etudiant n'est pas inscrit</h1>");
		out.println("<form method='post' action='InscriptionControle'> ");
		out.println("Nom:          <input type='text' name='nom'/></br>");
		out.println("Prenom:       <input type='text' name='prenom'/></br>");
		out.println("Login:        <input type='text' name='login'/></br>");
		out.println("Mot de passe: <input type='text' name='pass'/></br></br>");
		out.println("<input value='Inscription' type='submit' />");
		out.println("</form>");

	}
}
