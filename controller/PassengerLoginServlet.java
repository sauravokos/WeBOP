package com.wipro.frs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wipro.frs.service.*;
/**
 * Servlet implementation class PassengerLoginServlet
 */
@WebServlet("/PassengerLoginServlet")
public class PassengerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session= request.getSession();
		String email_id = request.getParameter("email");
		String password = request.getParameter("password");
		String flightId= request.getParameter("flightId");
		session.setAttribute("flightId", flightId);
		System.out.println(flightId);
		Processing vc = new Processing();
		try {
				if(vc.validatePassenger(email_id, password))
				{
					int pass_id=vc.getPassengerId(email_id, password);
					if(pass_id!=0)
					{
						session.setAttribute("pass_id", pass_id );
						session.setAttribute("email", email_id);
						System.out.println("You have logged in");
						response.sendRedirect("PassengerDetails.jsp");
					}
					else
						System.out.println("error in comms");
				}
				else
				{
					System.out.println("Invalid email/password");
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error @ passenger login servlet");
			
		}
		
	}

}
