package com.e2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e2.dao.BookShelfServiceDao;
import com.e2.domain.Book;
import com.e2.vo.BookVO;

@Service("bookShelfServiceImpl")
@Transactional
public class BookShelfServiceImpl implements BookShelfService {
	
	private BookShelfServiceDao dao;

	@Override
	public long insertBook(BookVO bookVO) {
		Book book = new Book();
		book.setAuthor(bookVO.getAuthor());
		book.setBookName(bookVO.getBookName());
		dao.persisten(book);
		return book.getBookId();
	}

	@Override
	public BookVO getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO getBookById(long bookId) {
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
}
