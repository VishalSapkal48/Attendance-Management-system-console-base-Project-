package com.org.techhub.services;

import com.org.techhub.model.UserpasswordModel;
import com.org.techhub.repository.addUsernamePassword;


//************************************************************************************
public class userNamePassWordServices {
	
	addUsernamePassword up = new addUsernamePassword();
	 
	public boolean isAdduser(UserpasswordModel usee)
	{
		return up.isAddUserNmaePassword(usee)?true:false;
		
	}
//************************************************************************	
    public  boolean  isAddUserPassWordServices( String userName, String PassWord)
   {
    	return up.isAddUserNmaePassword1(userName, PassWord)?true:false;
    	
	   
   }
	
}
