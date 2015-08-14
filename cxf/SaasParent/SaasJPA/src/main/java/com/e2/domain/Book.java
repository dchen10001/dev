package com.e2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name="BOOK")

public class Book implements Serializable {
	
	@Id 
	@Column(name="BOOK_ID")
	@SequenceGenerator(name="seqBookId", sequenceName="SEQ_BOOK_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqBookId")	
	private long bookId; 

	@Column(name="TITLE", nullable = false, length = 80)
	private String bookName; 
	
	@Column(name="AUTHOR", nullable = false, length = 80)
	private String author; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false, insertable = false, nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;
	
    @Version
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = false, nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedDate;
    
    public Book() {
    	
    }

	public Book(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getBookId() {
		return bookId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}
}
