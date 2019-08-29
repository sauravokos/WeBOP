package com.wipro.frs.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.frs.bean.DateBean;
import com.wipro.frs.dao.DaoDate;
import com.wipro.frs.dao.DaoFlight;
import com.wipro.frs.dao.DaoTicket;
import com.wipro.frs.service.Processing;
import com.wipro.frs.bean.*;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Welcome to booking terminal");
		HttpSession session = request.getSession();
		System.out.println("accessed bookingservlet");
		String email= session.getAttribute("email").toString();
		String date = session.getAttribute("date").toString(); 
		String source = session.getAttribute("source").toString();
		String destination = (String)session.getAttribute("destination");
		String passId= session.getAttribute("pass_id").toString();
		String bookings =session.getAttribute("bookings").toString();
		ArrayList<String> naam= (ArrayList<String>) session.getAttribute("naam");		
		String passengers="";
		for(String j: naam)
		{
			passengers+=request.getParameter(j)+", ";
		}
		String finalPassengerNames= passengers.substring(0, passengers.length()-2);
		System.out.println(passengers);
		System.out.println(date+"\t"+source+"\t"+bookings);
		String depTime =session.getAttribute("flightId").toString().split(" ")[1];
		int flightId= Integer.parseInt(session.getAttribute("flightId").toString().split(" ")[0]);
		String arrTime=session.getAttribute("flightId").toString().split(" ")[2];
		Processing vc = new Processing();
		try {
				System.out.println("accessed after checking date");
				String tableName= session.getAttribute("referenceTable").toString();
				FlightBean f= new FlightBean();
				f.setFlightId(flightId);
				DaoFlight df = new DaoFlight();
				int bookingInt=Integer.parseInt(bookings);
				if(df.updateTable(f, tableName, bookingInt)==1) 
				{
					if(vc.generateTicket(flightId, Integer.parseInt(passId), depTime,arrTime, date,finalPassengerNames,bookingInt,source,destination,email)==1)
						{
							DaoTicket dt= new DaoTicket();
							System.out.println("ticket success!");
							int ticketId= dt.returnLastTicketId();
							session.setAttribute("ticketId", ticketId);
							response.sendRedirect("ticketSuccess.jsp");
							
						}
				}
						
				
					
					
					
					
				else
					System.out.println(df.updateTable(f, tableName, bookingInt));
		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
