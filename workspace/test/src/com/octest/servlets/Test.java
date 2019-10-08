package com.octest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		//recuperer des variable avec URL
		
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		
		
		/*******/
		request.setAttribute("heure", "soir");
		
		String message= "Au revoir";
	request.setAttribute("variable",message);
	
	
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp")
		.forward(request, response);
		
		
		
		
	
		
		
	/*response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	
	PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='UTF-8'>");
	out.println("<title>Test</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>بسم الله الرحمان الرحيم</p>");
	out.println("</body>");
	out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
