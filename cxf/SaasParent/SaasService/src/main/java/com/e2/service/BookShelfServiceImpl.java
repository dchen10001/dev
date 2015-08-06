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
	public BookVO getBook(String title) {
		synchronized (dbStore) {
			for(BookVO bookVO : dbStore) {
				if(bookVO.getBookName().equalsIgnoreCase(title)) {
					return bookVO;
				}
			}
		}
		return null;
	}

}
