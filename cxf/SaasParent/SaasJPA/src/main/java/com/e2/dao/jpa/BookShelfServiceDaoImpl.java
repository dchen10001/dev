package com.e2.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.e2.dao.BookShelfServiceDao;
import com.e2.domain.Book;
import com.e2.domain.Employee;

@Repository("bookShelfServiceDaoImpl")
public class BookShelfServiceDaoImpl implements BookShelfServiceDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public long persisten(Book book) {
		try {
		TypedQuery<Employee> query = entityManager.createNamedQuery("getAllEmploy", Employee.class);
		List<Employee> ls = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		entityManager.persist(book);
		entityManager.flush();
		return book.getBookId();
	}

	@Override
	public Book getBookByTitle(String title) {
    	TypedQuery<Book> q = entityManager.createQuery("SELECT b FROM Book b WHERE b.bookName = :bookName", Book.class);
    	q.setParameter("bookName", title);
    	Book result = q.getSingleResult();
    	return result;
	}

	@Override
	public Book getBookById(long bookId) {
		return entityManager.find(Book.class, bookId);
	}

	@Override
	public void removeBookById(long bookId) {
		Book book = entityManager.getReference(Book.class, bookId);
		entityManager.remove(book);
		entityManager.flush();
	}

	@Override
	public List<Long> getBookIds() {
    	Query q = entityManager.createQuery("SELECT b.bookId FROM Book b");
    	List<Long> result = (List<Long>)q.getResultList();
    	return result;
	}

	@Override
	public List<Book> getBooks() {
    	TypedQuery<Book> q = entityManager.createQuery("SELECT b FROM Book b", Book.class);
    	List<Book> result = q.getResultList();
    	return result;
	}
}
