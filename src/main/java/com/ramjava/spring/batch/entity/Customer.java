package com.ramjava.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_INFO")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private int id;
	@Id
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Id
	@Column(name = "LAST_NAME")
	private String lastName;
	@Id
	@Column(name = "EMAIL")
	private String email;
	@Id
	@Column(name = "GENDER")
	private String gender;
	@Id
	@Column(name = "CONTACT")
	private String contactNo;
	@Id
	@Column(name = "COUNTRY")
	private String country;
	@Id
	@Column(name = "DOB")
	private String dob;
}
