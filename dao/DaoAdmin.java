package com.wipro.frs.dao;
import com.wipro.frs.util.*;
import com.wipro.frs.bean.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoAdmin 
{
	public boolean isAdmin(AdminBean a) throws Exception
	{
		Connection conn= new DBUtil().connectDatabase();
		String sql="select * from admin where admin_id=?";
		PreparedStatement pstmnt= conn.prepareStatement(sql);
		pstmnt.setString(1, a.getName());
		ResultSet rs= pstmnt.executeQuery();
		while(rs.next())
		{
			if(rs.getString(2).equals(a.getName()) && rs.getString(2).equals(a.getPassword()))
			{
				return true;
			}
		}
		return false;
		
		
	}
	public int dropTable() throws Exception
	{
		DaoFlight df= new DaoFlight();
		return df.dropTable();
	}
	
}
