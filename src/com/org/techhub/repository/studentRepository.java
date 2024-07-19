package com.org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import com.org.techhub.DbConfigr.dbConfigrs;
import com.org.techhub.model.studentModule;

public class studentRepository extends dbConfigrs {
	List<studentModule> list = new ArrayList<studentModule>();
	studentModule smodel = new studentModule();

//***********************************************************************************

	public boolean isAddStudent(studentModule smodel) {
		try {
			//System.out.println(smodel);
			
			stmt = con.prepareStatement("insert into student values('0',?,?,?,?,?,?)");
			stmt.setString(1, smodel.getName());
			stmt.setString(2, smodel.getEmail());
			stmt.setString(3, smodel.getContact());
			stmt.setString(4, smodel.getAddress());
			stmt.setInt(5, smodel.getRollNo());
			stmt.setInt(6, smodel.getCourseid());
			// System.out.println(smodel.getAddress());
			int value = stmt.executeUpdate();
			if (value > 0) {
				// System.out.println("student successfully addd.....");
				return true;
			} else {
				// System.out.println("some problem for student add.....");
				return false;
			}

		} catch (Exception ex) {
			System.out.println("student add "+ex);
			return false;

		}

	}

//**************************************************************************

	public List<studentModule> getAllStudent() {
		try {
			stmt = con.prepareStatement("select *from student");
//		    re =stmt.executeQuery();
			re = stmt.executeQuery();
			while (re.next()) {
				smodel = new studentModule();
				smodel.setSid(re.getInt(1));
				smodel.setName(re.getString(2));
				smodel.setEmail(re.getString(3));
				smodel.setContact(re.getString(4));
				smodel.setAddress(re.getString(5));
				smodel.setRollNo(re.getInt(6));

				list.add(smodel);

//		    	while(re.next())
//			    {
//			    	System.out.println(re.getInt(1) +"\t"+ re.getString(2) +"\t"+ re.getString(3) +"\t"+re.getString(4)+"\t"+ re.getString(5)+"\t"+re.getInt(6));
//			    }

//		        re.getInt(1);
//		       re.getString(2);
//		       re.getString(3);
//		       re.getString(4);
//		        re.getString(5);
//		        re.getInt(6);
				// list.add(re.getString("name"));

			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
		return null;
	}

//************************************************************************************************************

	public boolean isDeleteStudent(int RollNo) {
		try {
			// stmt = con.prepareStatement("delete from student where rollno=?");
			// re=stmt.executeQuery();
			int value = stmt.executeUpdate("delete from student where rollno=" + RollNo);
			if (value > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("delete " + ex);
			
			return false;
		}
		// return false;
	}

//*****************************************************************************************	   

	public boolean isModefiy(String name1,String email1,String contact1,String address1,int RollNo) {
		try {
			// stmt.executeUpdate("update first set name=? city=? where id=\"+id1");
			stmt = con.prepareStatement(
					"update  student set student_name=?, email=?, contcat=?, address=? where  rollno=?");
			stmt.setString(1,name1);
			stmt.setString(2, email1);
			stmt.setString(3, contact1);
			stmt.setString(4, address1);
			stmt.setInt(5, RollNo);
			
			// stmt.setInt(5, smodel.getRollNo());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("modefiy" + ex);
		}

		return false;
	}

	// ************************************************************************************

}
