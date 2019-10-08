package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnseignantDAO_IMPL;
import dao.GroupeDAO_IMPL;
import dao.GroupenseignantDAO_IMPL;
import dao.MatiereDAO_IMPL;
import dao.NiveauDAO_IMPL;
import dao.NoteDAO_IMPL;
import model.Enseignant;
import model.Etudiant;
import model.Groupe;
import model.Groupeenseignant;
import model.Matiere;
import model.Niveau;
import model.Note;

/**
 * Servlet implementation class GroupeEnseignantController
 */
@WebServlet("/GroupeEnseignantController")
public class GroupeEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Groupe groupe =new Groupe();
	private Groupeenseignant groupeEnEdit= new Groupeenseignant();
	private int id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupeEnseignantController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		GroupeDAO_IMPL groupeDAO = new GroupeDAO_IMPL();
	
		
		if (action == null) {
		
		request.setAttribute("groups", groupeDAO.findAll());
		request.getRequestDispatcher("/Groupeenseignant.jsp").forward(request, response);
		}else{
	
			
			if(action.equals("aff")){		
				id= Integer.parseInt(request.getParameter("id"));
			
				}
		
			if(action.equals("Recherche")){		
				String rperiode=request.getParameter("rperiode") ;
				String rannee=request.getParameter("rannee") ;
				groupe	= groupeDAO.Recherche( id, rannee , rperiode );
				request.setAttribute("groupe", groupe);
				}
			
			if (action.equals("Enregistrer")) {
			      int cEnseignant = Integer.parseInt(request.getParameter("enseignant"));
			      int cMatiere = Integer.parseInt(request.getParameter("matiere"));
			      
			      
			      Enseignant enseignant= new EnseignantDAO_IMPL().findById(cEnseignant);
			      Matiere matiere =new MatiereDAO_IMPL().findById(cMatiere);
				  String semestre = request.getParameter("semestre");
				  java.util.Date date= new java.util.Date();
				  SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
				
				  
				  int compostage =(int)(Math.random() * ((99000 - 10000) + 1)) + 10000;
				  for (Etudiant et : groupe.getEtudiants()) {
					  compostage+=137; 
					new NoteDAO_IMPL().add(new Note(compostage,matiere,et));
					}
				 
			      new GroupenseignantDAO_IMPL().add(new Groupeenseignant( dataFormat.format(date) ,new java.util.Date(),  semestre,  enseignant,  groupe,
				  			 matiere)); 
				} else if (action.equals("supp")) {
					int code = Integer.parseInt(request.getParameter("id"));
					Groupeenseignant ge =new GroupenseignantDAO_IMPL().findById(code);
					
					  for (Note nt : ge.getMatiere().getNotes()) {
						
						 System.out.println(ge.getGroupe().getCode()+" HH "+ nt.getEtudiant().getGroupe().getCode()); 
						if(ge.getGroupe().getCode()==nt.getEtudiant().getGroupe().getCode() )
						{new NoteDAO_IMPL().delete(nt.getId());}
						}
					
					
					new GroupenseignantDAO_IMPL().delete(code);
				} else if (action.equals("edit")) {
					int code = Integer.parseInt(request.getParameter("cod"));
					groupeEnEdit = new GroupenseignantDAO_IMPL().findById(code);
					request.setAttribute("groupeEnEdit", groupeEnEdit);
				
				
				} else if (action.equals("Modifier")) {
				
				      int cEnseignant = Integer.parseInt(request.getParameter("enseignant"));
				      int cMatiere = Integer.parseInt(request.getParameter("matiere"));
				      Enseignant enseignant= new EnseignantDAO_IMPL().findById(cEnseignant);
				      Matiere matiere =new MatiereDAO_IMPL().findById(cMatiere);
				   
					  String semestre = request.getParameter("semestre");
					  groupeEnEdit.setSemestre(semestre);
					  groupeEnEdit.setEnseignant(enseignant);
					  groupeEnEdit.setMatiere(matiere);
					  java.util.Date date= new java.util.Date();
				
					 groupeEnEdit.setDateAffectation(date);
				      new GroupenseignantDAO_IMPL().edit(groupeEnEdit);
				      
				}
			if(!action.equals("Recherche")){		
				groupe	= groupeDAO.findById(id);
				request.setAttribute("groupe", groupe);
				}


			request.setAttribute("enseignants", new EnseignantDAO_IMPL().findAll());
			request.setAttribute("matieres", new MatiereDAO_IMPL().findAll());
			
		    request.getRequestDispatcher("/Affectation.jsp").forward(request, response);
		}
		
		
		
	}

}
