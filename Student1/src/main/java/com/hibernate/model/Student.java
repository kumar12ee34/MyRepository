package com.hibernate.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="student")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Student_Id")
	private int sid;
	@Column(name="Student_Name")
	private String sname;
	@Column(name="Student_Age")
	private int age;
	@Column(name="Student_Gender")
	private String gender;
	@Column(name="Student_DateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date DOB;
	@Column(name="Student_Image")
	@Lob
	private byte[] image;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",  column=@Column(name="Home_Street_Name")),
		@AttributeOverride(name="city",  column=@Column(name="Home_City_Name")),
		@AttributeOverride(name="state",  column=@Column(name="Home_State_Name")),
		@AttributeOverride(name="pincode",  column=@Column(name="Home_PinCode"))})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
