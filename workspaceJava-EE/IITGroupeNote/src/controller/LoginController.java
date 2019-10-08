package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EnseignantDAO_IMPL;
import dao.EtudiantDAO_IMPL;
import model.Enseignant;
import model.Etudiant;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");
		String type = request.getParameter("type");
		System.out.println(type);
		if (action.equals("Sign")) {
			if (type.equals("2")) {
				EtudiantDAO_IMPL dao = new EtudiantDAO_IMPL();
				Etudiant currentStudent = dao.checkLogin(userName, userPassword);
				if (currentStudent != null) {
					request.getSession().setAttribute("nom", currentStudent.getNom());
					request.getRequestDispatcher("/EtudiantController").forward(request, response);
				}
			}

			else if (type.equals("1")) {
				EnseignantDAO_IMPL dao2 = new EnseignantDAO_IMPL();
				Enseignant currentenseignant =dao2.checkLogin(userName, userPassword);
				if (currentenseignant!=null) {
					request.getSession().setAttribute("nom", currentenseignant.getNom());
					request.getRequestDispatcher("/EnseignantController").forward(request, response);
				}
			}
		}
	}

}
