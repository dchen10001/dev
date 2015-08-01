package com.e2.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.e2.vo.BookVO;

@Service("bookShelfServiceImpl")
public class BookShelfServiceImpl implements BookShelfService {
	private Set<BookVO> dbStore = new HashSet<BookVO>();
	
	@Override
	public long insertBook(BookVO bookVO) {
		long bookId = System.currentTimeMillis();
		bookVO.setBookId(bookId);
		synchronized (dbStore) {
			dbStore.add(bookVO);
		}
		return bookId;
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
