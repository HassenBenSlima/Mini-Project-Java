package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnseignantDAO_IMPL;
import model.Enseignant;

/**
 * Servlet implementation class EnseignantController
 */
@WebServlet("/EnseignantController")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Enseignant enseignantEdit = new Enseignant();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnseignantController() {
		super();
		
	}

	private EnseignantDAO_IMPL dao;

	@Override
	public void init() throws ServletException {
		dao = new EnseignantDAO_IMPL();
		super.init();

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
		String action = request.getParameter("action");
		
		if (action != null) {
			
			if (action.equals("Enregistrer")) {
		
				String adresse = request.getParameter("adresse");
				String cin = request.getParameter("cin");
				String email = request.getParameter("email");
				String mat=request.getParameter("matriculefiscal");
				String motpass =request.getParameter("cin");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				int tel = Integer.parseInt(request.getParameter("tel"));
				int responsableb;
				if (request.getParameter("responsableb").equals("0"))
					responsableb = 0;
				else
					responsableb = 1;
				
				
				dao.add(new Enseignant( adresse,cin, email,  mat,  motpass, nom,  prenom,  responsableb,  tel));
			}

			else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));
				 enseignantEdit = dao.findById(code);
				request.setAttribute("enseignant", enseignantEdit);
			} else if (action.equals("Modifier")) {
			
				enseignantEdit.setAdresse(request.getParameter("adresse"));
				enseignantEdit.setCin(request.getParameter("cin"));
				enseignantEdit.setEmail(request.getParameter("email"));
				enseignantEdit.setMatriculefiscal(request.getParameter("matriculefiscal"));
				enseignantEdit.setNom(request.getParameter("nom"));
				enseignantEdit.setPrenom(request.getParameter("prenom"));
	            enseignantEdit.setTel(Integer.parseInt(request.getParameter("tel")));
			
				int responsableb;
				if (request.getParameter("responsableb").equals("resp"))
					responsableb = 1;
				else
					responsableb = 0;
				
				enseignantEdit.setResponsableb(responsableb);
				
				dao.edit(enseignantEdit);
				
			}
		}
		//
		request.setAttribute("enseignants", dao.findAll());
		request.getRequestDispatcher("/Enseignant.jsp").forward(request, response);
	}

}
