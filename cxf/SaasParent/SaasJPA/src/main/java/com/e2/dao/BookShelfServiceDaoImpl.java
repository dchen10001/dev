package com.e2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.e2.domain.Book;

@Repository("bookShelfServiceDaoImpl")
public class BookShelfServiceDaoImpl implements BookShelfServiceDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public long persisten(Book book) {
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
}
