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
 * Servlet implementation class AuthControle
 */
@WebServlet("/AuthControle")
public class AuthControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthControle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		Etudiant currentUser = null;
		ServletContext ctx = getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<Etudiant> listUser = (ArrayList<Etudiant>) ctx.getAttribute("listUser");
		
		if (listUser != null) {
			for (Etudiant etudiant : listUser) {
				if (etudiant.getLogin().equals(login) && etudiant.getPassword().equals(pass)) {
					currentUser = etudiant;
					System.out.println(currentUser);

				}
			}
		}

		if (currentUser != null) {
			System.out.println(currentUser + "detailView");
			request.setAttribute("courant", currentUser);

			getServletContext().getRequestDispatcher("/DetailView").forward(request, response);
		} else {
			System.out.println(currentUser + "InscriptionEtud");
			String error = "Veuillez verifier vos parametre!!";
			request.setAttribute("erreur", error);
			getServletContext().getRequestDispatcher("/InscriptionEtud").forward(request, response);

		}
	}
}
