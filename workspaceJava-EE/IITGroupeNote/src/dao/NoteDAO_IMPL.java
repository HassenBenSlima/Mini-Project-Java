package dao;

import java.util.List;

import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import model.Note;

public class NoteDAO_IMPL {
	Session session = HibernateUtil.sessionFactory.openSession();

	public void add(Note not) {
		Session maSession = HibernateUtil.sessionFactory.openSession();
		maSession.beginTransaction();
		maSession.save(not);
		maSession.getTransaction().commit();
		maSession.close();

	}

	public Note edit(Note not) {
		session.beginTransaction();
		Note no = (Note) session.merge(not);
		session.getTransaction().commit();
		return no;
	}

	public void delete(int id) {
		session.beginTransaction();
		Note no = findById(id);
		session.delete(no);
		session.getTransaction().commit();

	}

	public List<Note> findAll() {
		return session.createQuery("select n from Note n").list();
	}

	public Note findById(int id) {
		return (Note) session.get(Note.class, id);
	}
}
