package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupeDAO_IMPL;
import dao.MatiereDAO_IMPL;
import dao.NoteDAO_IMPL;
import model.Groupe;
import model.Matiere;
import model.Note;

/**
 * Servlet implementation class NoteCompostageController
 */
@WebServlet("/NoteCompostageController")
public class NoteCompostageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Groupe> groups ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteCompostageController() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupeDAO_IMPL groupeDAO = new GroupeDAO_IMPL();
		String action = request.getParameter("action");
		if(action==null)
		{	request.setAttribute("groups", groupeDAO.findAll());	
		}
        else if(action.equals("Recherche")){	
        		String rperiode=request.getParameter("rperiode");
       			String rannee=request.getParameter("rannee"); 
       			
        		if(request.getParameter("codeGroupe")!=null){
        		    int codeGroupe= Integer.parseInt(request.getParameter("codeGroupe"));
                    List<Groupe> groupes=new ArrayList<Groupe>() ;
                    groupes.add(groupeDAO.Recherche( codeGroupe, rannee , rperiode )); 
                    request.setAttribute("groups", groupes);		
        		}else{
        			 groups = groupeDAO.findAll();
        			for (Groupe gr:groups)
        			{
        				int i=gr.getCode();
        				gr=groupeDAO.Recherche( i, rannee , rperiode );
        			}
        			request.setAttribute("groups", groups);
        		}

		}else if (action.equals("Enregistrer")){
			 int codeMatier =Integer.parseInt(request.getParameter("matier"));
			Matiere matier  =new MatiereDAO_IMPL().findById(codeMatier);
			for(Note nt:  matier.getNotes() ) 
			{   if(request.getParameter("ex"+nt.getId())!=null){
				nt.setNoteexam(Float.parseFloat(0+request.getParameter("ex"+nt.getId())));
			    new NoteDAO_IMPL().edit(nt);
			    }
			    
			}
        request.setAttribute("groups", groupeDAO.findAll());	
		}
		request.setAttribute("sGroups", groupeDAO.findAll());
		request.getRequestDispatcher("/NoteCompostage.jsp").forward(request, response);		
	}

}
