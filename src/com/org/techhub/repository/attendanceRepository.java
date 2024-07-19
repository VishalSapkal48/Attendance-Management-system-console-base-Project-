package com.org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import com.org.techhub.DbConfigr.dbConfigrs;
import com.org.techhub.model.attendanceModule;
import com.org.techhub.model.courseModule;
import com.org.techhub.model.studentModule;

public class attendanceRepository extends dbConfigrs {
	attendanceModule amodel = new attendanceModule();
	studentModule sm = new studentModule();
	courseModule cm = new courseModule();
	List<attendanceModule> list = new ArrayList<attendanceModule>();
	ArrayList al = new ArrayList();

	public boolean getAttendence(attendanceModule amodel) {
		try {
			// System.out.println("data:" + amodel);
			stmt = con.prepareStatement("insert into attendance values(?,?,?,?)");
			stmt.setInt(1, amodel.getAid());
			stmt.setInt(2, amodel.getStudentid());
			stmt.setString(3, amodel.getDates());
			stmt.setInt(4, amodel.getStatus());

			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;

			}
			return false;

		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
		return false;
	}
	// *******************************************************************************

	public List<attendanceModule> isdisplay() {
		try {
			stmt = con.prepareStatement("select *from attendance");
			re = stmt.executeQuery();
			while (re.next()) {
				amodel = new attendanceModule();
				amodel.setAid(re.getInt(1));
				amodel.setStudentid(re.getInt(2));
				amodel.setDates(re.getString(3));
				amodel.setStatus(re.getInt(4));
				list.add(amodel);

			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("fatch data " + ex);
		}
		return list;

	}
//------------------------------------------------------

	public boolean getAttendanceBycourse(int cid) {
		try {
			stmt = con.prepareStatement(
					"select att.aid,att.stuid,s.student_name,c.courseName, att.dates,att.stutas from attendance att inner join student s on att.stuid =s.sid inner join course c on c.courseid =s.courseid where s.courseid="
							+ cid);
			re = stmt.executeQuery();
			//System.out.println("query run");
		
			while (re.next()) {
				// aid | stuid | student_name | courseName | dates | stutas
				System.out.println(re.getInt("aid") + "|" + re.getInt("stuid") + "|" + re.getString("student_name") +"|" +re.getString("courseName")
						+ "|" + re.getString("dates") + "|" + re.getInt("stutas"));
				// amodel.setAid(re.getInt(1));
//		    	  amodel.setStudentid(re.getInt(2));
//		    	  sm.setName(re.getString(3));
//		    	  cm.setCourseName(re.getString(4));
//		    	  amodel.setDates(re.getString(5));
//		    	  amodel.setStatus(re.getInt(6));
//		    	   al.add(amodel);
//		    	   al.add(sm);
//                   al.add(cm);
//		  
			}

		} catch (Exception ex) {
			System.out.println("Exception c" + ex);
		}

		return false;

	}
	
//----------------------------------------------------------------------------------
	
	
	
	 public boolean showStudentattendance(String name)
	 {
		 try
		 {
			 stmt =con.prepareStatement(" select s.student_name,c.courseName, att.dates,att.stutas from attendance att inner join student s on att.stuid =s.sid inner join course c on c.courseid =s.courseid where s.student_name =?");
		   stmt.setString(1, name);
			 re =stmt.executeQuery();
				System.out.println("  Student Name \t Course Name\t Date \t Status ");
		    while(re.next())
		    {
		    	System.out.println(  "    "+re.getString("student_name") +"\t   " +re.getString("courseName")
				+ "\t     " + re.getString("dates") + "\t" + re.getInt("stutas"));
	
		    }
		 
		 }
		 catch(Exception ex)
		 {
			 System.out.println("show "+ex);
		 }
		return false;
	 }
	
//*****************************************************************************************
	 
	 public boolean showDatePresent(int cid,String sname)
	 {
		 try
		 {
			 stmt =con.prepareStatement(" select count(att.stutas),s.student_name,c.courseName from attendance att inner join student s on att.stuid =s.sid inner join course c on c.courseid =s.courseid where s.courseid=? and s.student_name=? group by s.student_name;");
		      stmt.setInt(1, cid);
		      stmt.setString(2, sname);
		      re=stmt.executeQuery();
		      System.out.println("total Days present \t Student name \t Course Name");
		      while(re.next())
		      {
		    	  System.out.println("\t"+re.getInt(1) +"\t\t  "+ re.getString("student_name")+"\t\t"+ re.getString("courseName"));
		      }
		 }
		 
		 catch(Exception ex)
		 {
			 System.out.println("error"+ex);
		 }
		return false;
	 }

}