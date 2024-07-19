package com.org.techhub.repository;

import java.sql.ResultSetMetaData;
import com.org.techhub.DbConfigr.dbConfigrs;
import com.org.techhub.model.UserpasswordModel;

public class addUsernamePassword extends dbConfigrs {
	public boolean isAddUserNmaePassword(UserpasswordModel usee) {
		try {
			stmt = con.prepareStatement("insert into userNamePassword values(?,?) ");
			stmt.setString(1, usee.getUserName());
			stmt.setString(2, usee.getPassWord());
			int value = stmt.executeUpdate();
			if (value > 0) {
				System.out.println("userName and password successfully added");
			} else {
				System.out.println("some error to add userNmae and Password");
			}
		} catch (Exception ex) {
			System.out.println("error for userId and password");
		}
		return false;
	}

//*****************************************************************************
	
	
	public boolean isAddUserNmaePassword1(String userName,String PassWord)
	{
		try
		{
			stmt=con.prepareStatement("select *from userNamePassword where user_name=? and pasword=?");
            stmt.setString(1, userName);	
            stmt.setString(2, PassWord);
            re=stmt.executeQuery();
            if(re.next())
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
			System.out.println("not login "+ex);
		}
		return false;
	}
}
	