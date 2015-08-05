package com.e2.dao;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.e2.domain.Book;

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/app-test-context.xml"})
@Transactional

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookShelfServiceDaoTest {
	
	@Resource
	BookShelfServiceDao bookShelfServiceDao;
	
	@Test
	public void addBook() {
		Book book = new Book();
		book.setAuthor("Issac Asimov"); 
		book.setBookName("Foundation and Earth"); 
		long result = bookShelfServiceDao.persisten(book); 

		book = new Book(); 
		book.setAuthor("Issac Asimov"); 
		book.setBookName("Foundation and Empire"); 
		result = bookShelfServiceDao.persisten(book); 


		book = new Book(); 
		book.setAuthor("Arthur C Clarke"); 
		book.setBookName("Rama Revealed"); 
		result = bookShelfServiceDao.persisten(book); 
		
	}	
}
