package tn.iit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String mp = request.getParameter("mp");
		User currentUser = null;
		ServletContext ctx = getServletContext();

		ArrayList<User> listUser = (ArrayList<User>) ctx.getAttribute("listUilisateur");
		if (listUser == null)
			getServletContext().getRequestDispatcher("/Inscription").forward(request, response);
		else
			for (User user : listUser) {
				if (login.equals(user.getLogin()) && mp.equals(user.getPswd())) {
					currentUser = user;
					break;
				}
			}
		if (currentUser != null)

			getServletContext().getRequestDispatcher("/DetailView").forward(request, response);
		else
			getServletContext().getRequestDispatcher("/Inscription").forward(request, response);

	}
}
