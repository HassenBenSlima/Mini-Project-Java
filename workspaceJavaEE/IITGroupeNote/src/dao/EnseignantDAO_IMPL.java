package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Enseignant;
import model.Etudiant;

public class EnseignantDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Enseignant ens) {
		Session maSession = HibernateUtil.sessionFactory.openSession();
		maSession.beginTransaction();
		maSession.save(ens);
		maSession.getTransaction().commit();
		maSession.close();

	}

	public Enseignant edit(Enseignant ens) {
		session.beginTransaction();
		Enseignant en = (Enseignant) session.merge(ens);
		session.getTransaction().commit();
		return en;
	}

	public void delete(int id) {
		session.beginTransaction();
		Enseignant ens = findById(id);
		session.delete(ens);
	}

	public Enseignant findById(int id) {
		return (Enseignant) session.get(Enseignant.class, id);
	}

	public List<Enseignant> getEtudiantsParMc(String mc) {
		session.beginTransaction();
		Query req = session.createQuery("select e from Enseignant where e.nom like :x");
		req.setParameter("x", "%" + mc + "%");
		List<Enseignant> ens = req.list();
		session.getTransaction().commit();
		return ens;
	}
	public List<Enseignant> findAll() {
		return session.createQuery("select o from Enseignant o").list();
	}
	public Enseignant checkLogin(String userName, String userPassword) {
		session.beginTransaction();
		boolean userFound = false;
		String SQL_QUERY = " from Enseignant as o where o.cin=? and o.motpasse=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			return (Enseignant) list.get(0);
		}

		session.close();
		return null;
	}
}
