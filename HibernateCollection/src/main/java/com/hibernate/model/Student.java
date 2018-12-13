package com.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Student_Table1")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sid;
	@Column(name = "Student_Name")
	private String sname;
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@ElementCollection
	@JoinTable(name = "Student_Addresses1", joinColumns = @JoinColumn(name = "Student_Id"))
	@CollectionId(columns = { @Column(name="Address_Id") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

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

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

}
