package com.wipro.frs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil 
{
	static{
	    try {
	        Class.forName ("oracle.jdbc.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	public Connection connectDatabase() throws Exception
	{
		try
		{
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@10.209.61.132:1521:orcl", "scott", "tiger");
		return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;	
		}
	}
}
