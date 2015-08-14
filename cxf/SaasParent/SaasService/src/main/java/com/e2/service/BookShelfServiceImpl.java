package com.e2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e2.dao.BookShelfServiceDao;
import com.e2.domain.Book;

@Service("bookShelfServiceImpl")
@Transactional
public class BookShelfServiceImpl implements BookShelfService {
	
	@Resource
	private BookShelfServiceDao dao;

	@Override
	public long insertBook(Book book) {
		dao.persisten(book);
		return book.getBookId();
	}

	@Override
	public Book getBookByTitle(String title) {
		Book book = dao.getBookByTitle(title);
		return book;
	}

	@Override
	public Book getBookById(long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(long bookId, String auther, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook(long bookId) {
		// TODO Auto-generated method stub	
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return dao.getBooks();
	}
}
