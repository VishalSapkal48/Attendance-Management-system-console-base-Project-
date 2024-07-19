package com.org.techhub.model;

public class studentModule {
	 private int sid;
	 private String name;
	 private String email;
	 private String contact;
	 private String address;
	 private int courseid;
	 
	 public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getAddress() {
		 
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	private int rollNo;
	 
	public  studentModule()
	{
		
	}

//*******************************************************
	public studentModule( String name, String email,String contact,String address,int rollNo,int courseid)
	{
		this.sid=sid;
		this.name=name;
		this.email =email;
		this.contact=contact;
		this.rollNo=rollNo;
		this.address=address;
		this.courseid =courseid;
		
	}
	
//******************************************************************
	 
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "studentModule [sid=" + sid + ", name=" + name + ", email=" + email + ", contact=" + contact
				+ ", address=" + address + ", courseid=" + courseid + ", rollNo=" + rollNo + "]";
	}
	 
	 
	 
	
}
