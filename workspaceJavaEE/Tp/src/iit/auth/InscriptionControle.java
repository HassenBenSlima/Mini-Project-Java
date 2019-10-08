package iit.auth;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iit.auth.enities.Etudiant;

/**
 * Servlet implementation class InscriptionControle
 */
@WebServlet("/InscriptionControle")
public class InscriptionControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionControle() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		Etudiant e = new Etudiant(nom, prenom, login, pass);

		ServletContext ctx = getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<Etudiant> listUser = (ArrayList<Etudiant>) ctx.getAttribute("listUser");

		if (listUser == null) {
			listUser = new ArrayList<>();
			listUser.add(e);

			request.setAttribute("courant", e);

			getServletContext().getRequestDispatcher("/DetailView").forward(request, response);

		} else {
			listUser.add(e);
			request.setAttribute("courant", e);

			getServletContext().getRequestDispatcher("/DetailView").forward(request, response);
		}

		ctx.setAttribute("listUser", listUser);
		for (Etudiant ee : listUser) {
			System.out.println(ee.getNom());
		}
	}

}
