package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatiereDAO_IMPL;
import model.Etudiant;
import model.Matiere;

/**
 * Servlet implementation class MatiereController
 */
@WebServlet("/MatiereController")
public class MatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Matiere matiereEdit =new Matiere ();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatiereController() {
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
		MatiereDAO_IMPL dao = new MatiereDAO_IMPL();
		String action = request.getParameter("action");
		if (action != null) {
			
			if (action.equals("Enregistrer")) {
				//int code = Integer.parseInt(request.getParameter("code"));
				String libelle = request.getParameter("libelle");
				int volumeC = Integer.parseInt(request.getParameter("volumeC"));
				int volumeTd = Integer.parseInt(request.getParameter("volumeTd"));
				int volumeTp = Integer.parseInt(request.getParameter("volumeTp"));
				int coefficient = Integer.parseInt(request.getParameter("coefficient"));
				int credit = Integer.parseInt(request.getParameter("credit"));
				dao.add(new Matiere(coefficient,  credit,  libelle,  volumeC,  volumeTd,  volumeTp));
			}

			else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));
			    matiereEdit = dao.findById(code);
				request.setAttribute("matiere", matiereEdit);
			} else if (action.equals("Modifier")) {
				String libelle = request.getParameter("libelle");
				int volumeC = Integer.parseInt(request.getParameter("volumeC"));
				int volumeTd = Integer.parseInt(request.getParameter("volumeTd"));
				int volumeTp = Integer.parseInt(request.getParameter("volumeTp"));
				int coefficient = Integer.parseInt(request.getParameter("coefficient"));
				int credit = Integer.parseInt(request.getParameter("credit"));
				matiereEdit.setCoefficient(coefficient);
				matiereEdit.setCredit(credit);
				matiereEdit.setLibelle(libelle);
				matiereEdit.setVolumeC(volumeC);
				matiereEdit.setVolumeTd(volumeTd);
				matiereEdit.setVolumeTp(volumeTp);
	
                dao.edit(matiereEdit);

			 }
		}
		request.setAttribute("matieres", dao.findAll());
		request.getRequestDispatcher("/Matiere.jsp").forward(request, response);

	}

}
