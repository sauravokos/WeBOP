package com.wipro.frs.dao;
import com.wipro.frs.util.*;
import com.wipro.frs.bean.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class DaoDate 
{
	public int insertDate(DateBean d) throws Exception
	{
		try
		{
			DBUtil db= new DBUtil();
			Connection conn= db.connectDatabase();
			String sql="insert into date_info values(to_date(?,'yyyy/mm/dd'),?)";
			PreparedStatement psmnt= conn.prepareStatement(sql);
			psmnt.setString(1, d.getDate());
			psmnt.setString(2, d.getDateId());
			return psmnt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
	
	public String generateDateId(String date)
	{
		String dateId="";
		String [] dateArray= date.split("-");
		System.out.println(dateArray.length);
		switch(dateArray[1])
		{
			case "01":
				dateId+="jan";
				break;
			case "02":
				dateId+="feb";
				break;
			case "03":
				dateId+="mar";
				break;
			case "04":
				dateId+="apr";
				break;
			case "05":
				dateId+="may";
				break;
			case "06":
				dateId+="jun";
				break;
			case "07":
				dateId+="jul";
				break;
			case "08":
				dateId+="aug";
				break;
			case "09":
				dateId+="sep";
				break;
			case "10":
				dateId+="oct";
				break;
			case "11":
				dateId+="nov";
				break;
			case "12":
				dateId+="dec";
				break;
			default:
				dateId+="";
				break;
		}
			dateId+=dateArray[2]+dateArray[0].substring(2);
			return dateId;
			
			
				
	}
	

	public boolean isDate(DateBean db)
	{
		try {
			Connection conn= new DBUtil().connectDatabase();
			String sql= "select * from date_info where new=to_date(?,'yyyy/mm/dd')";
			PreparedStatement ptsmnt= conn.prepareStatement(sql);
			ptsmnt.setString(1, db.getDate());
			ResultSet rs= ptsmnt.executeQuery();
			if(rs.next())
			{
				return true;
				
			}
			else
				return false;
			
			
		}
	
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
		
	}
	
	public String returnDateId(String date) throws Exception
	{
		try
		{
			DBUtil db= new DBUtil();
			String tableName="";
			Connection conn = db.connectDatabase();
			String sql="select * from date_info where new=to_date(?,'yyyy/mm/dd')";
			PreparedStatement psmnt = conn.prepareStatement(sql);
			psmnt.setString(1, date);
			ResultSet rs = psmnt.executeQuery();
			while(rs.next())
			{
				tableName+=rs.getString(2);
			}
			return tableName;
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}		
		public ArrayList<String> returnAllDateId() throws Exception
		{
			
			try
			{
				ArrayList<String> dateId = new ArrayList<String>();
				DBUtil db= new DBUtil();
				Connection conn = db.connectDatabase();
				String sql= "select date_id from date_info";
				PreparedStatement ptsmnt = conn.prepareStatement(sql);
				ResultSet rs = ptsmnt.executeQuery();
				while(rs.next())
				{
					dateId.add(rs.getString(1));
				}
				return dateId;
				
				
			}
			catch (Exception e)
			{
				System.out.println("mistake @ returnAllDateId @ daodate");
				System.out.println(e);
				return null;
			}
			
		}
	
	
}
