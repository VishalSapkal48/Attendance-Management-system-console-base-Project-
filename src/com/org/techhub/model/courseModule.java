package com.org.techhub.model;

public class courseModule {
   private int courseId;
   private String duraction;
	public String getDuraction() {
	return duraction;
}

public void setDuraction(String duraction) {
	this.duraction = duraction;
}

	public int getCourseId() {
	return courseId;
	
}

public void setCourseId(int courseId) {
	this.courseId = courseId;
}

	private String courseName;

	  
	public courseModule()
	{}
//---------------------------------------------------------------------	
	public courseModule(String courseName,String duraction)
	{
		this.courseName=courseName;
		this.courseId =courseId;
		this.duraction=duraction;
	}
	
	
	//*************************************************
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
