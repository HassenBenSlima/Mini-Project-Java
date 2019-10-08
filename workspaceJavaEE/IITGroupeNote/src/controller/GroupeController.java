package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupeDAO_IMPL;
import dao.NiveauDAO_IMPL;
import model.Etudiant;
import model.Groupe;
import model.Niveau;

/**
 * Servlet implementation class GroupeController
 */
@WebServlet("/GroupeController")
public class GroupeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Groupe groupeEdit=new Groupe();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupeController() {
		super();
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
		GroupeDAO_IMPL dao = new GroupeDAO_IMPL();
		NiveauDAO_IMPL dao2 = new NiveauDAO_IMPL();
		
		String action = request.getParameter("action");
		if (action != null) {
			
			if (action.equals("Enregistrer")) {
		      int n = Integer.parseInt(request.getParameter("niv"));
				
				Niveau niveau= new NiveauDAO_IMPL().findById(n);
				String nom = request.getParameter("nom");
				String abreviation = request.getParameter("abrev");
				
				dao.add(new Groupe( abreviation,nom,niveau));
			} else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));

				groupeEdit = dao.findById(code);
				request.setAttribute("groupe", groupeEdit);
			} else if (action.equals("Modifier")) {
			
				int n = Integer.parseInt(request.getParameter("niv"));
				
		     	Niveau niveau= new NiveauDAO_IMPL().findById(n);
				String nom = request.getParameter("nom");
				String abreviation = request.getParameter("abrev");
				groupeEdit.setNiveau(niveau);
				groupeEdit.setNom(nom);
				groupeEdit.setAbreviation(abreviation);
				dao.edit(groupeEdit);

			}
		}
	

		request.setAttribute("groups", dao.findAll());
		request.setAttribute("niveau", dao2.findAll());
		request.getRequestDispatcher("/Groupe.jsp").forward(request, response);
	}

}
