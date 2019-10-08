package dao;

import java.util.List;

import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Groupe;
import model.Matiere;
import model.Niveau;

public class NiveauDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Niveau niv) {
		Session maSession = HibernateUtil.sessionFactory.openSession();
		maSession.beginTransaction();
		maSession.save(niv);
		maSession.getTransaction().commit();
		maSession.close();

	}

	public Niveau edit(Niveau niv) {
		session.beginTransaction();
		Niveau ni = (Niveau) session.merge(niv);
		session.getTransaction().commit();
		return ni;
	}

	public void delete(int id) {
		session.beginTransaction();
		Niveau niv = findById(id);
		session.delete(niv);
		session.getTransaction().commit();

	}

	public Niveau findById(int id) {
		return (Niveau) session.get(Niveau.class, id);
	}

	public List<Niveau> findAll() {
		return session.createQuery("select n from  Niveau n").list();
	}
}
