package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

import model.Matiere;

public class MatiereDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Matiere mat) {
		Session maSession = HibernateUtil.sessionFactory.openSession();
		maSession.beginTransaction();
		maSession.save(mat);
		maSession.getTransaction().commit();
		maSession.close();

	}

	public Matiere edit(Matiere mat) {
		session.beginTransaction();
		Matiere ma = (Matiere) session.merge(mat);
		session.getTransaction().commit();
		return ma;
	}

	public void delete(int id) {
		session.beginTransaction();
		Matiere ens = findById(id);
		session.delete(ens);
		session.getTransaction().commit();

	}

	public List<Matiere> findAll() {
		return session.createQuery("select m from Matiere m").list();
	}

	public Matiere findById(int id) {
		return (Matiere) session.get(Matiere.class, id);
	}
}
