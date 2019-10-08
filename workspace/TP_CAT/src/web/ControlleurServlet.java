package web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;


@WebServlet(name="cs",urlPatterns={"*.php"})
public class ControlleurServlet extends HttpServlet {
	
	private IProduitDao metier;
	
	
	@Override
	public void init() throws ServletException {
		metier=new ProduitDaoImpl();//couplage forte
	}
	
	protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
				String path=request.getServletPath();
				if(path.equals("/index.php")){

					request.getRequestDispatcher("produits.jsp").forward(request, response);
					
				}
				else if(path.equals("/chercher.php")){
					String motCle=request.getParameter("motCle");
					
					ProduitModel model =new ProduitModel();
					model.setMotCle(motCle);
					List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
					model.setProduits(produits);
					request.setAttribute("model", model);

					request.getRequestDispatcher("produits.jsp").forward(request, response);

				}else if (path.equals("/Saisie.php")) {
					request.setAttribute("produit", new Produit());
					request.getRequestDispatcher("SaisieProduits.jsp").forward(request, response);

					
				}else if (path.equals("/SaveProduit.php")&&(request.getMethod().equals("POST"))) {
				String des =request.getParameter("designation");
				double prix =Double.parseDouble(request.getParameter("prix"));
				int quantite=Integer.parseInt(request.getParameter("quantite"));
					Produit p =metier.save(new Produit(des, prix, quantite));
					request.setAttribute("produit",p);
					request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

					
				}else if (path.equals("/Supprime.php")) {
					Long id=Long.parseLong(request.getParameter("id"));
					metier.deleteProduit(id);
					//request.getRequestDispatcher("produits.jsp").forward(request, response);//
					// ON VA FAIRE LA REDIRECTION
					response.sendRedirect("chercher.php?motCle=");
				
				}else if (path.equals("/Edit.php")) {
				Long id=Long.parseLong(request.getParameter("id"));
				Produit p=metier.getProduit(id); 
				request.setAttribute("produit", p);
				request.getRequestDispatcher("EditProduit.jsp").forward(request, response);

				
				}else if (path.equals("/UpdateProduit.php")&&(request.getMethod().equals("POST"))) {
				Long id=Long.parseLong(request.getParameter("id"));
				String des =request.getParameter("designation");
				double prix =Double.parseDouble(request.getParameter("prix"));
				int quantite=Integer.parseInt(request.getParameter("quantite"));
				Produit p = new Produit(des, prix, quantite);
				p.setId(id);
				metier.update(p);
				request.setAttribute("produit", p);
				request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
				
				}else {
					response.sendError(org.apache.catalina.connector.Response.SC_NOT_FOUND);
				}
				
	}

	protected void doPost(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException {
						doGet(request, response);
	}

}
  