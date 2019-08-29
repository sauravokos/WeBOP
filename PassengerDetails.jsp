<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wipro.frs.bean.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
 
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>WeBOP</title>
    <link rel="shortcut icon" type="image/png" href="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/favicon.png"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }
        #logo{
        	margin-left: 47%;
        	margin-top: 5px;
        }
        .w3-blue{
        background-color: #500f75 !important;	
        width : 86%;
        border-radius: 7px;
        }
        .w3-input
        {
        	width : 71% !important;
        }
        .w3-deep-purple
        {
        	background-color:#500f75 !important;
        }
        
        #navbar {
            overflow: hidden;
            background-color: #500f75;
        }
        #navbar a {
            float: right;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        #navbar a:hover {
            background-color: #8d5bab;
            color: white;
        }
        #navbar a.active {
            background-color: #4CAF50;
            color: white;
        }
        .content {
            padding: 16px;
        }
        .sticky {
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 10;
        }
        .sticky+.content {
            padding-top: 60px;
        }
        .nav {
            font-size: 20px;
        }
        .tab-pane {
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
            border-radius: 0px 0px 15px 15px;
            padding: 10px;
            background-color: #fff;
        }
        .nav-tabs {
            margin-bottom: 0;
            background-color: #6b1c99;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }
        
        
        .form-check-label {
            font-size: 15px;
        }
        .form-group {
            margin-bottom: 0px;
        }
        .space {
            height: 10px;
        }
        .nav-link {
            color: #fff;
        }
        .nav-link:hover {
            color: #d6d6d6;
        }
        .carousel {
            margin-top: 53px;
        }
        .pos {
            display: flex;
            position: absolute;
            margin-top: 6%;
            margin-bottom: 10%;
            width: 100%;
            top: 0;
        }
        .btn {
            background-color: #6b1c99;
        }
        #logintab {
            color: #333;
        }
        #signuptab {
            color: #333;
        }
        #logintab:hover {
            color: #50f;
        }
        #signuptab:hover {
            color: #50f;
        }
        #footer {
            position: relative;
            bottom: 0;
            margin-top: 40%;
            width: 100%;
            /* Set the fixed height of the footer here */
            height: 140px;
        }
        /* Custom footer CSS
-------------------------------------------------- */
        .container .ad {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }
        .container .ad .text-muted {
            margin: 20px 0;
        }
        .footertext {
            color: #000;
        }
        .footlinks {
            color: #777;
            text-decoration: none;
            font-size: 15px;
        }
        .footlinks:hover {
            color: #999;
            text-decoration: none;
        }
        .footheader {
            font-size: 22px;
            color: #666;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="landingPage.js"></script>
    
</head>

<body>
    <div id="header" class="header">
        <div id="navbar" class="sticky">
            <a data-toggle="modal" data-target="search.jsp">Home</a> <a href="javascript:void(0)">Contact</a>
            <a href="javascript:void(0)">FAQ's</a>
            <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/LOGO.png"
                height="40px" width="70px" id="logo">
        </div>
    </div>

	<div class="pos">
		<div class="container" id="passengerdetails">
		<form method="post" action="BookingServlet">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-9">
					<%
						ArrayList<String> naam= new ArrayList<String>();
						String number=session.getAttribute("bookings").toString();
						int num=Integer.parseInt(number);
						out.println("<h3 class=\"w3-blue\">&nbsp;&nbsp;Enter passenger details:  </h3>"+"<br>");
						for(int i=0;i<num;i++)
						{
							String j=Integer.toString(i);
							naam.add(j);
							out.println("<div class=\"w3-half\">");
							out.println("Name:");
							out.println("<input class=\"w3-input\" type='text' name='"+j+"'>");
							out.println("</div><div class=\"w3-half\">");
							out.println("Age:");
							out.println("<input class=\"w3-input\" type='text' name='age'>");
							out.println("</div><br>");
							
						}
						session.setAttribute("naam", naam);	
					
					%>
				</div>
				<div class="col-1"></div>
			</div>
			<br>
			<div class="row" style="text-align:right;">
				<div class="col-4"></div>
				<div class="col-2" style="margin-left:3%;">
						<input class="w3-btn w3-round-large w3-deep-purple" type="submit" value="proceed">
				</div>
				<div class="col-6"></div>
			</div>
			<br>
		
		</form>
		</div>
	</div>
	
    <!-- Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <ul class="nav nav-tabs" style="background-color:#fff">
                        <li class="nav-item"><a class="nav-link active" id="logintab" data-toggle="tab"
                                href="#login">Login</a></li>
                        <li class="nav-item"><a class="nav-link" id="signuptab" data-toggle="tab"
                                href="#signup">Signup</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane container active" id="login">
                            <form name="loginForm" method="post" action="PassengerLoginServlet">
                                <input type="email" class="form-control mb-4 mt-4" id="email-login"
                                    placeholder="Email ID" name="email">
                                <input type="password" class="form-control mb-4" id="pwd-login" name="password" placeholder="Password">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </form>
                        </div>
                        <div class="tab-pane container" id="signup">
                            <form name="signupForm" onsubmit="return passwordValidation()" action="https://webhook.site/28b93ccd-1936-4c4e-a5c1-3a86d2519268" method="POST">
                                <div class="form-row">
                                    <div class="col">
                                        <input type="text" class="form-control mb-4 mt-4" id="firstName" name="firstName"
                                            placeholder="First Name">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control mb-4 mt-4" id="lastName" name="lastName"
                                            placeholder="Last Name">
                                    </div>
                                </div>
                                <input type="email" class="form-control mb-4" id="email-signup" placeholder="Email ID" name="email">
                                <input type="text" maxlength=10 class="form-control mb-4" id="phone"
                                    placeholder="Phone Number" name="phone">
                                <input type="password" class="form-control mb-4" id="pwd-signup1" name="pwd1"
                                    placeholder="Enter Password">
                                <input type="password" class="form-control mb-4" id="pwd-signup2" name="pwd2"
                                    placeholder="Confirm Password">
                                <button type="submit" class="btn btn-primary">Signup</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="footer">
        <br>
        <div class="container ad">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-2">
                    <center>
                        <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/icon1.png"
                            style="height:40px; width:40px;">
                        <br>
                        <p class="footertext">1000+<br>Daily Flights</p>
                    </center>
                </div>
                <div class="col-2">
                    <center>
                        <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/icon2.png"
                            style="height:40px; width:40px;">
                        <br>
                        <p class="footertext">50+<br>Domestic Destinations</p>
                    </center>
                </div>
                <div class="col-2">
                    <center>
                        <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/icon3.png"
                            style="height:40px; width:40px;">
                        <br>
                        <p class="footertext">25<br>International Destinations</p>
                    </center>
                </div>
                <div class="col-2">
                    <center>
                        <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/icon4.png"
                            style="height:40px; width:40px;">
                        <br>
                        <p class="footertext">300+<br>Million Happy Customers</p>
                    </center>
                </div>
                <div class="col-2">
                    <center>
                        <img src="https://cdn4.iconfinder.com/data/icons/airport-red/512/start_take_off_flight_fly_launch_departure_takeoff-512.png"
                            style="height:40px; width:40px;">
                        <br>
                        <p class="footertext">250<br>Fleet Tall</p>
                    </center>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </div>
    <!-- FOOTER -->
    <hr>
    <footer class="page footer" style="text-align:left; margin-left:150px; margin-right:70px; margin-top:80px;">
        <table border="0" width="100%">
            <tr>
                <th class="footheader"> Get to Know Us </th>
                <th class="footheader"> Quick Links </th>
                <th class="footheader"> Social </th>
            </tr>
            <tr>
                <td> <a href="#" class="footlinks">About Us</a> </td>
                <td> <a href="#" class="footlinks">Contact Us</a> </td>
                <td> <a href="#"><img
                            src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/facebook.png"
                            height="35px" width="35px"></a> </td>
            </tr>
            <tr>
                <td> <a href="#" class="footlinks">Destinations</a> </td>
                <td> <a href="#" class="footlinks">Feedback</a> </td>
                <td> <a href="#"><img
                            src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/instagram.png"
                            height="35px" width="35px"></a> </td>
            </tr>
            <tr>
                <td> <a href="#" class="footlinks">Careers</a> </td>
                <td> <a href="#" class="footlinks">Advertise With Us</a> </td>
                <td> <a href="#"><img
                            src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/twitter.png"
                            height="35px" width="35px"></a> </td>
            </tr>
            <tr>
                <td> <a href="#" class="footlinks">Our Awards</a> </td>
                <td> <a href="#" class="footlinks">Terms And Conditions</a> </td>
                <th class="footheader"> Download</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td> <a href="#"><img
                            src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/icons/playstore.png"
                            height="90px" width="150px"></a> </td>
            </tr>
        </table>
        <hr>
        <p style="font-size:12px; color: #333;">&copy; Copyright 2019 WeBOP. All rights reserved.</p>
    </footer>
    
    
    
</body>

</html>
