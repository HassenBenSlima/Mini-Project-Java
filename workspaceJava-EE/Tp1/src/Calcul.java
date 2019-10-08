
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calcul
 */
@WebServlet(initParams = { @WebInitParam(name = "Param1", value = "10"),
		@WebInitParam(name = "Param2", value = "20") }, urlPatterns = { "/Calcul", "/iit.tn" }

)
public class Calcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int param1, param2;

	@Override
	public void init(ServletConfig config) throws ServletException {

		param1 = Integer.parseInt(config.getInitParameter("Param1"));
		param2 = Integer.parseInt(config.getInitParameter("Param2"));
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1>Calcul :</h1>");
		out.println(param1 + param2);

	}

}
