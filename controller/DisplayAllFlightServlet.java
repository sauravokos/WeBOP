package com.wipro.frs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.frs.service.*;
import java.util.*;
import com.wipro.frs.bean.*;
/**
 * Servlet implementation class DisplayAllFlightServlet
 */
@WebServlet("/DisplayAllFlightServlet")
public class DisplayAllFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Processing p = new Processing();
		try 
		{
			ArrayList<FlightBean> flights = p.returnAllFlights();
			HttpSession  session = request.getSession();
			session.setAttribute("flights", flights);
			response.sendRedirect("");
		}
		catch (Exception e) 
		{
			
			System.out.println("mistake @ displayallflight servlet "+e);
		}
		
		
	}

}
