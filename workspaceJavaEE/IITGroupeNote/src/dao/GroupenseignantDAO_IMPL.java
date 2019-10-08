package dao;

import java.util.List;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Groupeenseignant;
import model.Niveau;

public class GroupenseignantDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Groupeenseignant gens) {
		Session maSession = HibernateUtil.sessionFactory.openSession();
		maSession.beginTransaction();
		maSession.save(gens);
		maSession.getTransaction().commit();
		maSession.close();

	}

	public Groupeenseignant edit(Groupeenseignant gens) {
		session.beginTransaction();
		Groupeenseignant gen = (Groupeenseignant) session.merge(gens);
		session.getTransaction().commit();
		return gen;
	}

	public void delete(int id) {
		session.beginTransaction();
		Groupeenseignant gens = findById(id);
		session.delete(gens);
		session.getTransaction().commit();

	}

	public Groupeenseignant  findById(int id) {
		return (Groupeenseignant) session.get(Groupeenseignant.class, id);
	}

	public List<Groupeenseignant> findAll() {
		return session.createQuery("select n from  Groupeenseignant n").list();
	}

	
}
