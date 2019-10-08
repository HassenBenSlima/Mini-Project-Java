package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatiereDAO_IMPL;
import dao.NiveauDAO_IMPL;
import model.Matiere;
import model.Niveau;

/**
 * Servlet implementation class NiveauController
 */
@WebServlet("/NiveauController")
public class NiveauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Niveau niveauEdit=new Niveau();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NiveauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NiveauDAO_IMPL dao=new  NiveauDAO_IMPL();
		String action = request.getParameter("action");
		if (action != null) {
			
			if (action.equals("Enregistrer")) {
				String nom = request.getParameter("nom");
				int nbrgroupe = Integer.parseInt(request.getParameter("nbrgroupe"));
				dao.add(new Niveau(nbrgroupe,nom));
			}

			else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));
			     niveauEdit = dao.findById(code);
				request.setAttribute("niveau", niveauEdit);
				
				
			} else if (action.equals("Modifier")) {
			
				String nom = request.getParameter("nom");
				int nbrgroupe = Integer.parseInt(request.getParameter("nbrgroupe"));
				niveauEdit.setNom(nom);
				niveauEdit.setNbrgroupe(nbrgroupe);
				dao.edit(niveauEdit);

			 }
		}
		request.setAttribute("niveaux", dao.findAll());
		request.getRequestDispatcher("/Niveau.jsp").forward(request, response);

	}

}
