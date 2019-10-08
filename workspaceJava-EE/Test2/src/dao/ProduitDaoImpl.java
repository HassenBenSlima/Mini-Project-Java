package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	Session session = HibernateUtil.sessionFactory.openSession();

	@SuppressWarnings("unchecked")
	public List<Produit> findAll() {
		return session.createQuery("select o from Produit o").list();
	}

	@Override
	public Produit save(Produit p) {
		Session masession = HibernateUtil.sessionFactory.openSession();
		masession.beginTransaction();
		masession.save(p);
		masession.getTransaction().commit();
		masession.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsParMC(String mc) {
		session.beginTransaction();
		Query req = session.createQuery("select e from Produit e where e.designation like :x");
		req.setParameter("x", "%" + mc + "%");
		List<Produit> etud = req.list();
		session.getTransaction().commit();
		return etud;
	}

	@Override
	public Produit update(Produit p) {
		session.beginTransaction();
		Produit etud = (Produit) session.merge(p);
		session.getTransaction().commit();
		return etud;

	}

	@Override
	public Produit findById(Long id) {
		return (Produit) session.get(Produit.class, id);
	}

	@Override
	public void deleteProduit(Long id) {
		session.beginTransaction();
		Produit etud = findById(id);
		session.delete(etud);
		session.getTransaction().commit();
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
