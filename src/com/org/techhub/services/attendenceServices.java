package com.org.techhub.services;

import java.util.List;

import com.org.techhub.model.attendanceModule;
import com.org.techhub.repository.attendanceRepository;

public class attendenceServices {
	
	attendanceRepository aRepo =new attendanceRepository();
	
	public boolean isaddattendance(attendanceModule atmodel)
	
	{
		 return aRepo.getAttendence(atmodel);
	}
	
	//=================================================
	public List<attendanceModule> isDisplay()
	{
		return aRepo.isdisplay();
		
	}
	
//-----------------------------------------------------
	
	public boolean getAttendanceBycourse(int cid)
	{
		return aRepo.getAttendanceBycourse(cid) ;
		
		
	}
	
	public boolean showStudentattendance(String name)
	{
		return aRepo.showStudentattendance(name);
	}
	
//----------------------------------------------------------
	public boolean showDatePresent(int cid ,String sname)
	{
		return aRepo.showDatePresent(cid, sname);
	}
}
