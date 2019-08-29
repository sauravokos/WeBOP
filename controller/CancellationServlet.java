package com.wipro.frs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.frs.dao.DaoDate;
import com.wipro.frs.service.*;

/**
 * Servlet implementation class CancellationServlet
 */
@WebServlet("/CancellationServlet")
public class CancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			HttpSession session=request.getSession();
			String date= session.getAttribute("date").toString().substring(0,11);
			int flightId= (int) session.getAttribute("flightId");
			int bookings = (int) session.getAttribute("bookings");
			int ticketId = (int) session.getAttribute("ticketId");
			System.out.println(flightId);
			System.out.println(date);
			Processing p = new Processing();
			if(p.cancelTicket(date, bookings, ticketId, flightId))
				System.out.println("cancellation successful");
			else
				response.sendRedirect("cancellation failed");
			
			response.sendRedirect("search.jsp");
			
		}
		catch (Exception e)
		{
			System.out.println("mistake @ cancellation servlet");
			System.out.println(e);
			
		}
		
	}

}
