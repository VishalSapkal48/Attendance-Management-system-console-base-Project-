package com.org.techhub.services;

import java.util.List;

import com.org.techhub.model.courseModule;
import com.org.techhub.repository.courseRepository;


public class courseServices {
	courseRepository cRep = new courseRepository( );
	public boolean isAddCourse(courseModule cmodule)
	{
		return cRep.isAddCourse(cmodule);
	}
//-------------------------------------------------------------------------------	
	
 public List<courseModule> getAllCourse()
 {
	 return cRep.getAllCourse();
 }
 
 //------------------------------------------------------------
 
 public boolean isdeleteCourse(int id)
 {
	return  cRep.isdeleteCourse(id);
 }
 
}
