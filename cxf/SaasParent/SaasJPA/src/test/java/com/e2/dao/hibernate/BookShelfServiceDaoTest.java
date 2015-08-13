package com.e2.dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.e2.dao.BookShelfServiceDao;
import com.e2.dao.BookTestData;
import com.e2.domain.Book;

@TransactionConfiguration(defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/hibernate/app-test-context.xml"})
@Transactional

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookShelfServiceDaoTest {
	
	@Resource
	BookShelfServiceDao bookShelfServiceDao;
	
	@Test
	@Transactional
	public void addBook() {
		Book[] books = BookTestData.getBooks();
		
		Set<Long> pks = new HashSet<Long>();
		for(Book book : books) {
			long pk = bookShelfServiceDao.persisten(book); 
			pks.add(pk);
		}
		
		for(Long pk : pks) {
			Book book = bookShelfServiceDao.getBookById(pk);
			Assert.notNull(book);
		}
	}	
	
	@Test
	public void getBookAndUpdate() {
		for(String title : BookTestData.titiles) {
			Book book = bookShelfServiceDao.getBookByTitle(title);
			book.setAuthor(book.getAuthor() + "-changed");
			Assert.notNull(book);
		}
	}
	
	@Test
	public void getBookIds() {
		 List<Long> bookIds = bookShelfServiceDao.getBookIds();
		 Assert.notNull(bookIds);
	}
		
	@Test
	public void removeBook() {
		List<Long> pks = bookShelfServiceDao.getBookIds();
		for(Long pk : pks) {
			bookShelfServiceDao.removeBookById(pk);
		}
	}
}
