package com.org.techhub.repository; 

import java.util.ArrayList;
import java.util.List;

import com.org.techhub.DbConfigr.dbConfigrs;
import com.org.techhub.model.courseModule;
import com.org.techhub.model.studentModule;

public class courseRepository extends dbConfigrs {
	List<courseModule>List =  new ArrayList(); 
	courseModule cmodule = new courseModule();
	public boolean isAddCourse(courseModule cmodule)
	{
		try
		{
			 stmt =con.prepareStatement("insert into course values('0',?,?)");
			// System.out.println(cmodule.getCourseName());
			 stmt.setString(1,cmodule.getCourseName());
			 stmt.setString(2, cmodule.getDuraction());
			 int value =stmt.executeUpdate();
			   if(value>0)
			   {
				   return true;
			   }
			   else
			   {
				   return false;
			   } 
		}
		catch(Exception ex)
		{
			System.out.println("course not add"+ex);
		}
		return false;
	}
//********************************************************************************************************	
    
	public List<courseModule> getAllCourse()
	{
		try
		{
	  stmt=con.prepareStatement("select *from course");
	  re = stmt.executeQuery();
		while (re.next()) {
			cmodule = new courseModule();
			 cmodule.setCourseId(re.getInt(1));
			  cmodule.setCourseName(re.getString(2));
			  cmodule.setDuraction(re.getString(3));
			  List.add(cmodule);
			  
		}
		return List.size()>0?List:null;
		}
		catch(Exception ex)
		{
			System.out.println("views all course" +ex);
		}
		return List;
	
	}

//*********************************************************************************	
	  
	public boolean isdeleteCourse(int id)
	{
		try
		{
			stmt=con.prepareStatement("delete from course where teacher_courseId=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();	
			if(value>0)
			{
				return true;
				
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("idelete course" +ex);
		}
		return false;
		
	}
	
	
}
