package com.e2.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.e2.dao.BookShelfServiceDao;
import com.e2.domain.Book;

@Repository("bookShelfServiceDaoImpl")	
public class BookShelfServiceDaoHibernateImpl implements BookShelfServiceDao {
	@Resource(name="sessionFactory") 
	private SessionFactory sessionFactory;
	boolean jta = true;
	
	public boolean isJta() {
		return jta;
	}

	public void setJta(boolean jta) {
		this.jta = jta;
	}
	
    protected Session getSession() {
    	if(this.isJta()) {
    		return sessionFactory.getCurrentSession();
    	} else {
    		return sessionFactory.openSession();
    	}
    }
    
	@Override
	public long persisten(Book book) {
		Session session = getSession();
		session.persist(book);
		session.flush();
		return book.getBookId();
	}

	@Override
	public Book getBookByTitle(String title) {
		Session session = getSession();
		Query q = session.createQuery("SELECT b FROM Book b WHERE b.bookName = :bookName");
		q.setParameter("bookName", title);
		return (Book)q.uniqueResult();
	}

	@Override
	public Book getBookById(long bookId) {
		return (Book)getSession().get(Book.class, bookId); 
	}

	@Override
	public void removeBookById(long bookId) {
    	Session em = getSession();
    	Book t = (Book)em.load(Book.class, bookId);
    	if(t != null) {
    		em.delete(t);
    	}
	}

	@Override
	public List<Long> getBookIds() {
		Session session = getSession();
		Query q = session.createQuery("SELECT b.bookId FROM Book b");
		return (List<Long>)q.list();
	}

}
