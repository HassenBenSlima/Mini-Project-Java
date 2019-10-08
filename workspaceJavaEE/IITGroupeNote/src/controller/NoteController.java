package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO_IMPL;
import dao.MatiereDAO_IMPL;
import dao.NoteDAO_IMPL;
import model.Matiere;
import model.Note;

/**
 * Servlet implementation class NoteController
 */          
@WebServlet("/NoteController")
public class NoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoteController() {
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
		MatiereDAO_IMPL dao = new MatiereDAO_IMPL();
		EtudiantDAO_IMPL dao2 = new EtudiantDAO_IMPL();
		NoteDAO_IMPL dao3 = new NoteDAO_IMPL();
		//
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("Valider")) {
				int codeM = Integer.parseInt(request.getParameter("codeM"));
				int codeET = Integer.parseInt(request.getParameter("codeEt"));
				float noteTp = Float.parseFloat(request.getParameter("noteTP"));
				float noteDS = Float.parseFloat(request.getParameter("noteDs"));
				float noteExam = Float.parseFloat(request.getParameter("noteExam"));
				float NotePresentielle = Float.parseFloat(request.getParameter("NotePresentielle"));
				int compostage = Integer.parseInt(request.getParameter("compostage"));
				
				//dao3.add(new Note(compostage,noteTp,noteDS,noteExam,NotePresentielle));
			}

			else if (action.equals("supp")) {
				int code = Integer.parseInt(request.getParameter("id"));
				dao3.delete(code);
			} else if (action.equals("edit")) {
				int code = Integer.parseInt(request.getParameter("cod"));
				Note n = dao3.findById(code);
				request.setAttribute("note", n);
			} else if (action.equals("Update")) {
				int codeM = Integer.parseInt(request.getParameter("codeM"));
				int codeET = Integer.parseInt(request.getParameter("codeET"));
				float noteTp = Float.parseFloat(request.getParameter("noteTP"));
				float noteDS = Float.parseFloat(request.getParameter("noteDS"));
				float noteExam = Float.parseFloat(request.getParameter("noteExam"));
				float NotePresentielle = Float.parseFloat(request.getParameter("NotePresentielle"));
				int compostage = Integer.parseInt(request.getParameter("compostage"));
				//dao3.edit(new Note(codeM,codeET,compostage,noteTp,noteDS,noteExam,NotePresentielle));;
			}
		}

		//
		request.setAttribute("matiere", dao.findAll());
		request.setAttribute("etudiant", dao2.findAll());
		request.getRequestDispatcher("/Note.jsp").forward(request, response);

	}

}
