package com.e2.ws.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.e2.service.BookShelfService;
import com.e2.vo.BookVO;

@Service("restBookService")
@Path("/bookService")
public class RSBookService {
	@Autowired
	@Qualifier("bookShelfServiceImpl")
	private BookShelfService bookService;

	@POST
	@Path("getbook/{name}")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json",
			"application/x-www-form-urlencoded" })
	public Response getBucket(@PathParam("name") String name) {
		BookVO bookVO = null;
		try {
			bookVO = bookService.getBook(URLDecoder.decode(name, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); 
		}

		if (bookVO == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(bookVO).build();
		}
	}

	@POST
	@Path("addbook")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json",
			"application/x-www-form-urlencoded" })
	public Response addBook(@FormParam("name") String bookName,
			@FormParam("author") String author) {
		BookVO bookVO = new BookVO();
		bookVO.setBookName(bookName);
		bookVO.setAuthor(author);

		bookService.insertBook(bookVO);

		if (bookService.getBook(bookName) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(bookVO).build();
		}
	}
}
