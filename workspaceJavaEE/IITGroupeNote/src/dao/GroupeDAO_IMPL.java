package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Enseignant;
import model.Groupe;
import model.Groupeenseignant;;

public class GroupeDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Groupe grp) {
		
		session.beginTransaction();
	    session.save(grp);
		session.getTransaction().commit();
		session.close();

	}

	public Groupe edit(Groupe gr) {
		session.beginTransaction();
		Groupe grp = (Groupe) session.merge(gr);
		session.getTransaction().commit();
		return grp;
	}

	public void delete(int id) {
		session.beginTransaction();
		Groupe grp = findById(id);
		session.delete(grp);
		session.getTransaction().commit();

	}

	public List<Groupe> findAll() {
		return session.createQuery("select g from  Groupe g").list();
	}

	public Groupe findById(int id) {
		return (Groupe) session.get(Groupe.class, id);
	}
	public Groupe Recherche(int id,String annee ,String periode ) {

		session.beginTransaction();
		Groupe groupe = findById(id);
		String SQL_QUERY = "select n from  Groupeenseignant n where n.groupe.code = :id and n.annee LIKE :annee and n.semestre LIKE :periode";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("id", id);
		query.setParameter("annee", "%"+ annee +"%");
		query.setParameter("periode", "%"+periode+"%");	
		List list = query.list();
        groupe.setGroupeenseignants(list);	
	
		//session.close();
		return  groupe;
	}
}
