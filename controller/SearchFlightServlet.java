package com.wipro.frs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.frs.dao.DaoDate;
import com.wipro.frs.dao.DaoFlight;
import com.wipro.frs.service.Processing;
import com.wipro.frs.bean.*;


/**
 * Servlet implementation class SearchFlightServlet
 */
@WebServlet("/SearchFlightServlet")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String date = request.getParameter("date");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int bookings = Integer.parseInt(request.getParameter("bookings"));
		HttpSession session=request.getSession();
		session.setAttribute("date",date);
		session.setAttribute("source",source);
		session.setAttribute("destination", destination);
		session.setAttribute("bookings", Integer.toString(bookings));
		Processing vc = new Processing();
		try {
			if(vc.checkDate(date))
			{
				System.out.println("accessed after checking date");
				//access the flight table according to the date id
				DaoDate dd = new DaoDate();
				DaoFlight df= new DaoFlight();
				String tableName= dd.returnDateId(date);
				FlightBean f= new FlightBean();
				f.setSource(source);
				f.setDestination(destination);
				System.out.println(tableName);
				ArrayList<FlightDetailBean> list=df.searchFlight(f, tableName,bookings);
				session.setAttribute("flightlist", list);
				session.setAttribute("referenceTable", tableName);
				response.sendRedirect("greeting.jsp");
				
				
			
				
		
			}
			else
			{
				System.out.println("accessed the 2nd branch");
				DaoDate dd= new DaoDate();
				DateBean  db = new DateBean();
				db.setDateId(dd.generateDateId(date));
				db.setDate(date); 
				String tableName=db.getDateId();
				dd.insertDate(db);
				DaoFlight df = new DaoFlight();
				df.createTable(tableName);
				FlightBean f= new FlightBean();
				f.setSource(source);
				f.setDestination(destination);	
				ArrayList list=df.searchFlight(f, tableName,bookings);
				session.setAttribute("flightlist", list);
				session.setAttribute("referenceTable", tableName);
				response.sendRedirect("greeting.jsp");
				
				
				
				
				
			}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
}
			
			

	

