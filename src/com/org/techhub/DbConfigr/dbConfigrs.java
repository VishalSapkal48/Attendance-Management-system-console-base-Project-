package com.org.techhub.DbConfigr;
import java.sql.*;
public class dbConfigrs {
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet re;
	  public dbConfigrs()
      { 
    	  try
    	  {
    		  Class.forName("com.mysql.cj.jdbc.Driver");
    		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
    	  }
    	  catch(Exception ex)
    	  {
    		  System.out.println("error is DbConfigr" +ex);
    	  } 
      }
}
