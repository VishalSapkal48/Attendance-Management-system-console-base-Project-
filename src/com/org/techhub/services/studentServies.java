package com.org.techhub.services;

import java.util.List;

import com.org.techhub.model.studentModule;
import com.org.techhub.repository.studentRepository;

public class studentServies {
	 studentRepository sRep = new studentRepository();
	 
	 public boolean isAddStudent(studentModule smodel)
	 {
		 return sRep.isAddStudent(smodel);
	 }
//************************************************************
	
	 
	 
	 public List<studentModule> getAllStudent()
	    {
	    	return sRep.getAllStudent();
	    	
	    }
	
	
//******************************************************************************
	 
	 public boolean isDeleteStudent(int RollNo)
	 {
		   return sRep.isDeleteStudent(RollNo);
	 }
	 
//**************************************************************
	 public boolean isModefiy(String name, String email,String contact,String address,int rollNo)
	 {
		 return sRep.isModefiy(name,email,contact,address,rollNo);
	 }
	 
	 
}
