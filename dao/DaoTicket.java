package com.wipro.frs.dao;
import com.wipro.frs.util.*;
import com.wipro.frs.bean.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class DaoTicket 
{
	public int insertTicketDetails(TicketBean t) throws Exception
	{
		try 
		{
			System.out.println("accessed insert");
			Connection conn= new DBUtil().connectDatabase();
			String sql= "insert into ticket_info values(seq_ticket.nextval,?,?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,?,?)";
			PreparedStatement pstmnt= conn.prepareStatement(sql);
			pstmnt.setInt(1, t.getFlightId());
			pstmnt.setString(2,t.getStatus());
			pstmnt.setInt(3,t.getPassId());
			pstmnt.setString(4, t.getPassNames());
			pstmnt.setString(5, t.getTicketDate());
			pstmnt.setString(6,t.getFlightDepTime());
			pstmnt.setString(7,t.getSource());
			pstmnt.setString(8, t.getDestination());
			pstmnt.setString(9, t.getFlightArrTime());
			pstmnt.setInt(10, t.getTotalPrice());
			pstmnt.setInt(11, t.getPhoneNumber());
			pstmnt.setString(12, t.getEmailId());
			int execute=pstmnt.executeUpdate();
			return execute;
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			return 0;
		}
		
	}
	
	public int returnLastTicketId() throws Exception
	{
		try
		{
			System.out.println("accessed returnLastId");
			int lastId=0;
			int temp=0;
			Connection conn= new DBUtil().connectDatabase();
			String sql="select * from ticket_info order by ticket_id desc";
			PreparedStatement ptsmnt= conn.prepareStatement(sql);
			ResultSet rs= ptsmnt.executeQuery();
			while(rs.next())
			{
				temp=rs.getInt(1);
				lastId=temp;
				break;
				
			}
	
			return lastId;
		}
		catch(Exception e)
		{
			System.out.println("mistake @ lastId func");
			return 0;
		}
	
	}
	public TicketBean returnTicketDetail(int ticketId) throws Exception
	{
		try 
		{	
			Connection conn= new DBUtil().connectDatabase();
			TicketBean tb = new TicketBean();
			String sql="select * from ticket_info where ticket_id=?";
			PreparedStatement ptsmnt= conn.prepareStatement(sql);
			ptsmnt.setInt(1, ticketId);
			ResultSet rs = ptsmnt.executeQuery();
			if(rs.next())
			{
				tb.setTicketId(rs.getInt(1));
				tb.setFlightId(rs.getInt(2));
				tb.setStatus(rs.getString(3));
				tb.setPassNames(rs.getString(5));
				tb.setTicketDate(rs.getString(6));
				tb.setFlightDepTime(rs.getString(7));
				tb.setSource(rs.getString(8));
				tb.setDestination(rs.getString(9));
				tb.setFlightArrTime(rs.getString(10));
				tb.setTotalPrice(rs.getInt(11));
				tb.setPhoneNumber(rs.getInt(12));
				tb.setEmailId(rs.getString(13));
				return tb;
			}
			else
			{
				System.out.println("entered else");
				return null;
			}
				
			
		}
		catch (Exception e)
		{
			System.out.println("mistake @ returnTicketDetail");
			return null;
		}
	}
	
	public int changeTicketStatus(TicketBean t) throws Exception
	{
		try {
			Connection conn= new DBUtil().connectDatabase();
			String sql = "update ticket_info set status=? where ticket_id=?";
			PreparedStatement ptsmnt = conn.prepareStatement(sql);
			ptsmnt.setString(1, t.getStatus());
			ptsmnt.setInt(2, t.getTicketId());
			return ptsmnt.executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println("mistake @ changeTicketStatus");
			return 0;
		}
		
		
		
	}
	
}
