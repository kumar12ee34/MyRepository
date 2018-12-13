package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sid;
	@Column(name = "Student_Name")
	private String sname;
	@ElementCollection
	@JoinTable(name="Student_Addresses", 
						joinColumns=@JoinColumn(name="Student_Id")
			)
	private Set<Address> listOfAddresses = new HashSet<Address>();
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

}
