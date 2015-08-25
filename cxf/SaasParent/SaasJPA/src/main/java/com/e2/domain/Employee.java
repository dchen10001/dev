package com.e2.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.ALL;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="EMPLOYEE")

@NamedQueries({
    @NamedQuery(name = "getAllEmploy", query="SELECT e FROM Employee e JOIN FETCH e.phones")
}) 

public class Employee {
	public enum Gender {
		M, F;
	}
	
	@Id 
	@Column(name="EMPNUM")
	@SequenceGenerator(name="seqEmployeeId", sequenceName="SEQ_EMP_ID", allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqEmployeeId")	
	private long empNum;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE", nullable=false)
	private Date birthDate;
	
	@Column(name="FIRSTNAME", nullable = false, length = 40)
	private String firstName;
	
	@Column(name="LASTNAME", nullable = false, length = 40)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER", nullable = false)
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HIREDATE", nullable=false)
	private Date hireDate;
	

	@OneToMany(cascade={ MERGE, REMOVE, DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name="EmployeeId")
	private List<Phone> phones;
	
}
