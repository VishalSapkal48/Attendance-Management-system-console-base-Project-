package com.org.techhub.control;

import java.security.Provider.Service;
import java.util.*;
import com.org.techhub.DbConfigr.dbConfigrs;
import com.org.techhub.model.UserpasswordModel;
import com.org.techhub.model.attendanceModule;
import com.org.techhub.model.courseModule;
import com.org.techhub.model.studentModule;
import com.org.techhub.repository.addUsernamePassword;
import com.org.techhub.services.attendenceServices;
import com.org.techhub.services.courseServices;
import com.org.techhub.services.studentServies;
import com.org.techhub.services.userNamePassWordServices;

public class main {

	public static void main(String x[]) {
		dbConfigrs db = new dbConfigrs();
		ArrayList List = new ArrayList();
		addUsernamePassword userpass = new addUsernamePassword();
		userNamePassWordServices userpassSe = new userNamePassWordServices();
		studentServies Servics = new studentServies();
		courseServices cService = new courseServices();
		attendenceServices attService = new attendenceServices();

		// courseAndStudentJoinServices csServices = new courseAndStudentJoinServices();
//******************************************************************************

		Scanner sc = new Scanner(System.in);
		System.out.println("you want to create the new account (Enter the yes /no)");
		String check = sc.nextLine();
		if ("yes".equals(check)) {
			System.out.println("Add the user name and password");
			String userName = sc.nextLine();
			String passWord = sc.nextLine();
			UserpasswordModel usee = new UserpasswordModel(userName, passWord);
			boolean b = userpassSe.isAdduser(usee);

		}
		int choice;
		System.out.println("Enter the User Name");
		String userName = sc.nextLine();
		System.out.println("Enter the PassWord");
		String passWord = sc.nextLine();
		boolean b = userpassSe.isAddUserPassWordServices(userName, passWord);
		if (b) {
			System.out.println("Login SuccessFully...");

//***********************************************************************************************			
			do {

				System.out.println(" case 1 : Student Operations...");
				System.out.println(" case 2 : Course Opreations...");
				System.out.println(" case 3 : Add Student Attendances");
				System.out.println(" case 4 : search student attendence course id  wise");
                System.out.println(" case 5 : show the student details  name wise ");
                System.out.println(" case 6 : check course wise student presenty");
				int a = sc.nextInt();
				switch (a) {
				case 1:
					System.out.println("=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=");

					System.out.println("case 1  Add New Student  :");
					System.out.println("case 2  View Student :");
					System.out.println("case 3  Delete :");
					System.out.println("case 4  Update Student :");

					System.out.println("=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
					System.out.println("Enter your choices");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						sc.nextLine();
						System.out.println("Enter the full name of student");
						String name = sc.nextLine();
						System.out.println("Enter the  student email");
						String email = sc.nextLine();
						System.out.println("Enter the student contact no ");
						String contact = sc.nextLine();
						System.out.println("Enter the address");
						String address = sc.nextLine();
						System.out.println("Enter the RollNo ");
						int rollno = sc.nextInt();
                         System.out.println("Enter the Course id");
                         int courseid =sc.nextInt();
                         
						studentModule smodel = new studentModule(name, email, contact, address, rollno,courseid);
						b = Servics.isAddStudent(smodel);
						if (b) {
							System.out.println("student added ");
						} else {
							System.out.println("student not addes..");
						}

						break;

//------------------------------------------------------------------------------------------

					case 2:
						List<studentModule> list = Servics.getAllStudent();
						System.out.println("Student id  \t Student Name \t Student Email \t Stduent contact \t Student Roll_no");
						for (studentModule m : list) {
							
							System.out.println("\t"+m.getSid() + "\t" + m.getName() + "\t\t" + m.getEmail() + "\t\t"
									+ m.getContact() +  "\t" + m.getRollNo());
						}
						break;

//---------------------------------------------------------------------------------------------					
					case 3:
						System.out.println(" Enter the Roll No Which is delete ");
						int RollNo = sc.nextInt();
						b = Servics.isDeleteStudent(RollNo);
						if (b) {
							System.out.println("delete student");
						} else {
							System.out.println("not delete student");
						}

						break;

//-------------------------------------------------------------------------------------------

					case 4:
						sc.nextLine();
						System.out.println(" Update the full name of student");
						String name1 = sc.nextLine();
						System.out.println("Update  student email");
						String email1 = sc.nextLine();
						System.out.println("Update the student contact no ");
						String contact1 = sc.nextLine();
						System.out.println("Update the address");
						String address1 = sc.nextLine();
						System.out.println("Enter the RollNo which is modefiy");
						int rollNo = sc.nextInt();
						// studentModule smodel1 = new
						// studentModule(name1,email1,contact1,address1,rollNo);
						b = Servics.isModefiy(name1, email1, contact1, address1, rollNo);
						if (b) {
							System.out.println("student data modify..");
						} else {
							System.out.println("student data not modify..");
						}
						break;

//------------------------------------------------------------------------------------------
					default:
						System.out.println("invalid choices......");
						break;
//--------------------------------------------------------------------------------------
					
				}
					break;

				// ***********************************************************************************
				// case 2 course
				// ***************************************************************************************
				case 2: {
					System.out.println("=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=**=*=*=");
					System.out.println("case 1 Add Course...");
					System.out.println("case 2 Fatch All Course....");
					System.out.println("case 3 Delete Course ");
					System.out.println("=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=");
					a = sc.nextInt();
					System.out.println("Enter your choice");
					switch (a) {
					case 1:
						sc.nextLine();
						System.out.println("Enter the Course Name");
						String courseName = sc.nextLine();
						System.out.println("Enter the Duraction of course");
						String duraction = sc.nextLine();
						courseModule cmodule = new courseModule(courseName, duraction);
						b = cService.isAddCourse(cmodule);
						if (b) {
							System.out.println("course added ");
						} else {
							System.out.println("not add course  ");
						}
						break;

//---------------------------------------------------------------------------------------------            	      
					case 2:
						java.util.List<courseModule> list = cService.getAllCourse();
						System.out.println("Course ID \t Course Name \t Duration");
						for (courseModule s : list) {
							System.out.println("\t"+s.getCourseId() + "\t   " + s.getCourseName() + "\t\t  " + s.getDuraction());
						}
						break;
//---------------------------------------------------------------------------------------------
					case 3:
						System.out.println("enter the id which delete ");
						int id = sc.nextInt();
						b = cService.isdeleteCourse(id);
						if (b) {
							System.out.println("course delete ....");
						} else {
							System.out.println("course not delete...");
						}

						break;
//---------------------------------------------------------------------------------------------	 
					}
				}
					break;

				// -------------------------------------------------------------------------------------

				// *******************************************************************
				case 3:
					
			      System.out.println("case 1 : Added the Student Attendance");
			   	  System.out.println("case 2 : fatch Attendances... ");
			   	  System.out.println("Enter Your Choices..");
				  int Ch=sc.nextInt();
					
					switch(Ch)
					
					{
					case 1 :
						sc.nextLine();
						List<studentModule> list = Servics.getAllStudent();
						attendanceModule amodel = new attendanceModule();
						int status;
						for (studentModule m : list) {
							System.out.println(m.getSid() + "\t" + m.getName() + "\t" + m.getEmail() + "\t" + m.getContact()
									+ "\t" + m.getContact() + "\t" + m.getRollNo());
							System.out.println("Enter the Attendance id");
							int aid = sc.nextInt();
							System.out.println("Enter the Student id");
							int sid = sc.nextInt();
							System.out.println("Enter the date ");
							String dates = sc.next();
							System.out.println("Enter the Stutas Present =1 Or Absent=0 insert");
							int stutas = sc.nextInt();
							attendanceModule attModule = new attendanceModule(aid, sid, dates, stutas);
							b = attService.isaddattendance(attModule);
							if (b) 
							{
								System.out.println("data added ..");
							} else 
							{
								
								System.out.println("not added...");
						    } 
						}
						 break;
//--------------------------------------------------------------------------------------'
					case 2 :
							System.out.println("Attendance id \t Stduent id \t Dates \t\t status");
 						   List<attendanceModule> List1 = attService.isDisplay();		
 						   for(attendanceModule am: List1)
 						   {
 							   System.out.println("\t"+am.getAid()+"\t\t"+am.getStudentid()+"\t"+am.getDates()+"\t"+am.getStatus());
 						   }
						  
 						   break;
					}
 					break;
 				
 //------------------------------------------------------------------------------------------
			
					case 4 :
				//
						System.out.println("courseId \t Course name");
						java.util.List<courseModule> list11 = cService.getAllCourse();
						for (courseModule s : list11) {
							System.out.println("   "+s.getCourseId() + "\t\t   " + s.getCourseName() );
						}
						System.out.println("Select Course Id");
						int couid =sc.nextInt();
						  ArrayList al = new ArrayList();
						  
						b = attService.getAttendanceBycourse(couid);
//					     for(int i=0;i<al.size();i++)
//					     {
//					    	  Object ob=al.get(i);
//					    	 System.out.println(ob);
//					    	 
//					     }
						
					  break;
		   			  
//-----------------------------------------------------------------------------------

					case 5 :
						
						sc.nextLine();
      					 System.out.println("Enter the student name");
						 String studentname =sc.nextLine();
						 b =attService.showStudentattendance(studentname);
						break;
					  
//--------------------------------------------------
					case 6 :
						  
						  System.out.println("Enter the course id");
						  int cid=sc.nextInt();
						  sc.nextLine();
						  System.out.println("Enter the Student name");
						  String name=sc.nextLine();
						  attService.showDatePresent(cid, name);						  
						  break;
						
					  
 						   
 						   default :
 							   System.out.println("Invalid Choices");
 							   break;
				   
 //------------------------------------------------------------------						  
 						   
				}break;
					
			
				
					
					
				
				// ========================================================================================

				

			} while (true);
		
		}

		else {
			System.out.println("user name and password not match");
		}
	
	}

}
