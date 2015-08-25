package com.e2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="PHONE")

@NamedQueries({
    @NamedQuery(name = "getPhoneByName", query="SELECT p FROM Phone p WHERE p.employee.lastName like :lastName")
}) 
public class Phone {
	@Id 
	@Column(name="ID")
	@SequenceGenerator(name="seqPhoneId", sequenceName="SEQ_PHONE_ID", allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqPhoneId")
	private long id;
	
	@Column(name="PHONENUM", nullable = false, length = 40)
	private String phone;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="EmployeeId", nullable=false, insertable=true, updatable=false)	
	private Employee employee;
}
