package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Etudiant;

public class EtudiantDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Etudiant e) {
		Session masession = HibernateUtil.sessionFactory.openSession();
		masession.beginTransaction();
		masession.save(e);
		masession.getTransaction().commit();
		masession.close();

	}

	public Etudiant edit(Etudiant e) {
		session.beginTransaction();
		Etudiant etud = (Etudiant) session.merge(e);
		session.getTransaction().commit();
		return etud;
	}

	public void delete(int id) {
		session.beginTransaction();
		Etudiant etud = findById(id);
		session.delete(etud);
		session.getTransaction().commit();
	}

	public List<Etudiant> findAll() {
		return session.createQuery("select o from Etudiant o").list();
	}

	public Etudiant findById(int id) {
		return (Etudiant) session.get(Etudiant.class, id);
	}

	public List<Etudiant> getEtudiantsParMc(String mc) {
		session.beginTransaction();
		Query req = session.createQuery("select e from Etudiant where e.nom like :x");
		req.setParameter("x", "%" + mc + "%");
		List<Etudiant> etud = req.list();
		session.getTransaction().commit();
		return etud;
	}

	public Etudiant checkLogin(String userName, String userPassword) {

		
		session.beginTransaction();
		String SQL_QUERY = " from Etudiant as o where o.cin=? and o.motpasse=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return (Etudiant) list.get(0);
		}

		session.close();
		return null;
	}

}
