package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", length=11, nullable=false, unique=true)

	private Integer personId;

	@Column(name = "name", length=20, nullable=true)

	private String personName;

	@Column(name = "fatherName", length=20, nullable=true)

	private String fatherName;

	@Column(name = "organization", length=20, nullable=true)

	private String organization;

	@Column(name = "mobile", length=20, nullable=true)

	private String mobile;

	public Person(Integer personId, String personName, String fatherName,String organization, String mobile) {

	   this.personId = personId;
	   this.personName = personName;
	   this.fatherName = fatherName;
	   this.organization = organization;
	   this.mobile = mobile;
	}
	public Integer getpersonId() {
	        return personId;
	}
	public void setpersonId(Integer personId) {
		this.personId = personId;
	}
	public String getpersonName() {
	    return personName;
	}
	public void setpersonName(String personName) {
	    this.personName = personName;
	}
	public String getfatherName() {
	    return fatherName;
	}
	public void setfatherName(String fatherName) {
	    this.fatherName = fatherName;
	}
	public String getorganization() {
	    return organization;
	}
	public void setorganization(String organization) {
	    this.organization = organization;
	}
	public String getmobile() {
	    return mobile;
	}
	public void setmobile(String mobile) {
	    this.mobile = mobile;
	}
	@Override
	public String toString() {
	     return "Person_Id: " + this.personId + ", Name: " + this.personName + ", Organization: " + this.organization + ", Mobile: " + this.mobile  ;
	}
}

