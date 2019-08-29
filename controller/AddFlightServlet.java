package com.wipro.frs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wipro.frs.service.*;
/**
 * Servlet implementation class AddFlightServlet
 */
@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		int flightId= Integer.parseInt(request.getParameter("flightId"));
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
//		float duration = Float.parseFloat(request.getParameter("duration"));
//		int totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
//		float distance = Float.parseFloat(request.getParameter("distance"));
//		String arrTime = request.getParameter("arrTime");
//		String depTime = request.getParameter("depTime");
		// int price = Integer.parseInt(request.getParameter("price"));
		AdminControls ac = new AdminControls();
		ac.dropTable();
		
		try {
			
			if(ac.addFlight(flightId,source, destination, duration, totalSeats, distance, arrTime, depTime, price))
				response.sendRedirect("FlightAddSuccess.jsp");
			else
				response.sendRedirect("FlightAddFailure.jsp");
		}
		catch (Exception e)
		{
			System.out.println("mistake at addFlightServlet");
			System.out.println(e);
		}
		
	}

}
