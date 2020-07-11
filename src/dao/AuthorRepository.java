package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import domain.Author;





public class AuthorRepository {
	public List<Author> getAuthors() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Author").list();
		}
	}

	public boolean add(Author obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}

	/* GET in EDIT - HIBERNATE */
	public Object getAuthor(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();

		return session.find(Author.class, id);
	}

	public boolean edit(Author obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}

	public boolean delete(int id) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.delete(new Author(id, null));
			tran.commit();
			return true;
		} catch (Exception ex) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}
	

	public List<Author> search(String q){
		try(Session session = HibernateUtil.getSessionfactory().openSession()){
		final Query query = session.createQuery("From Author WHERE AuthorName LIKE :q");
		query.setParameter("q", '%' + q + '%');
		return query.list();
		}
		}

}
