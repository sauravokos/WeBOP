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
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
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
        /* For sidenav */
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 10;
            top: 0;
            left: 0;
            background-color: #6b1c99;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }
        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #fff;
            display: block;
            transition: 0.3s;
        }
        .sidenav a:hover {
            color: #f1f1f1;
        }
        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
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
            margin-top: 15%;
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
<form name="loginForm" method="post" action="PassengerLoginServlet">
    <div id="header" class="header">
        <div id="navbar" class="sticky">
            <a data-toggle="modal" data-target="#loginModal">Login</a> <a href="javascript:void(0)">Contact</a>
            <a href="javascript:void(0)">FAQ's</a>
            <span style="font-size: 30px; cursor: pointer; color: #fff;" onclick="openNav()">&#9992;</span>
            <img src="https://raw.githubusercontent.com/thehalfwedbride/Flight-WeBOP/master/PicsArt_08-18-10.22.33.png"
                height="40px" width="40px">
        </div>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="#" data-toggle="modal" data-target="#loginModal">Login</a>
        </div>
    </div>
	<div class="pos">
		<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<%
					ArrayList <FlightDetailBean> flightList= (ArrayList<FlightDetailBean>)session.getAttribute("flightlist");
					if(flightList.size()==0){
						out.println("<h4>Sorry...No flights available!</h4>");
					}
					else{
						out.println("<h3 class=\"mb-0\">Flight Details<h3><br>");
						for(FlightDetailBean fdb : flightList)
						{	
							out.println("<div class=\"row\">");
							out.println("<div class=\"col-1\" style=\"padding-right:0; float:right;\">");
							out.println("<input type='radio' style=\"vertical-align:middle;\" name=\"flightId\" value=\""+Integer.toString(fdb.getFlightId())+" "+fdb.getDepTime()+" "+fdb.getArrTime()+"\">");
							out.println("</div>");
							out.println("<div class=\"col-11\" style=\"padding-left:2px;\">" );
							out.println("<h5 class=\"radio-inline mb-0\" style=\"float:left;\">"+fdb.getFlightId()+"&nbsp&nbsp;"+fdb.getSource()+"&nbsp&nbsp;"+fdb.getDestination()+"&nbsp&nbsp;"+fdb.getPrice()+"&nbsp&nbsp;"+fdb.getDepTime()+"&nbsp&nbsp;"+fdb.getArrTime()+"</h5>");
							out.println("</div>");
							out.println("<br>");
							out.println("</div>");
						}
					}
					
					%>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="button" class="btn btn-primary" value="Continue Booking" data-toggle="modal" data-target="#loginModal">
				</div>
				<div class="col-4"></div>
			</div>
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
                            
                                <input type="email" class="form-control mb-4 mt-4" id="email-login"
                                    placeholder="Email ID" name="email">
                                <input type="password" class="form-control mb-4" id="pwd-login" name="password" placeholder="Password">
                                <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="tab-pane container" id="signup">
                            <form name="signupForm" method="post" action="RegistrationServletController">
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
                                <input type="password" class="form-control mb-4" id="pwd-signup1" name="password"
                                    placeholder="Enter Password">
                                <button type="submit" class="btn btn-primary">Signup</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
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