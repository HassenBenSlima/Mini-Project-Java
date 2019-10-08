package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO_IMPL;
import dao.GroupeDAO_IMPL;
import model.Etudiant;
import model.Groupe;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/EtudiantController")
public class EtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Etudiant etudiantEdit = new Etudiant();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantController() {
		super();
	
	}

	private EtudiantDAO_IMPL dao;

	@Override
	public void init() throws ServletException {
		dao = new EtudiantDAO_IMPL();

		super.init();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null) {

			if (action.equals("Enregistrer")) {

				String adresse = request.getParameter("adresse");
				String cin = request.getParameter("cin");
				int code_groupe = Integer.parseInt(request.getParameter("codeGroupe"));
				Groupe groupe = new GroupeDAO_IMPL().findById(code_groupe);
				String email = request.getParameter("email");
				String motpass = request.getParameter("cin");
				String nom = request.getParameter("nom");
				int numinsci = Integer.parseInt(request.getParameter("numinsci"));
				String prenom = request.getParameter("prenom");
				int tel = Integer.parseInt(request.getParameter("tel"));

				dao.add(new Etudiant(adresse, cin, email, motpass, nom, numinsci, prenom, tel, groupe));
			}

			else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));
				etudiantEdit = dao.findById(code);
				request.setAttribute("etudiant", etudiantEdit);
			} else if (action.equals("Modifier")) {

				etudiantEdit.setAdresse(request.getParameter("adresse"));
				etudiantEdit.setCin(request.getParameter("cin"));
				etudiantEdit.setGroupe(new GroupeDAO_IMPL().findById(Integer.parseInt(request.getParameter("codeGroupe"))));
				etudiantEdit.setEmail(request.getParameter("email"));
				etudiantEdit.setNom(request.getParameter("nom"));
				etudiantEdit.setNuminsci(Integer.parseInt(request.getParameter("numinsci")));
				etudiantEdit.setPrenom(request.getParameter("prenom"));
				etudiantEdit.setTel(Integer.parseInt(request.getParameter("tel")));
				dao.edit(etudiantEdit);
			}
		}
		GroupeDAO_IMPL gr = new GroupeDAO_IMPL();

		request.setAttribute("group", gr.findAll());
		request.setAttribute("etudiants", dao.findAll());
		request.getRequestDispatcher("/Etudiant.jsp").forward(request, response);
	}

}
