package com.wipro.frs.bean;

public class TicketBean 
{
	int ticketId;
	int flightId;
	String flightDepTime;
	String status;
	String source;
	String destination;
	String emailId;
	String flightArrTime;
	int phoneNumber;
	String ticketDate;
	int passId;
	String passNames;
	int totalPrice;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFlightArrTime() {
		return flightArrTime;
	}
	public void setFlightArrTime(String flightArrTime) {
		this.flightArrTime = flightArrTime;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightDepTime() {
		return flightDepTime;
	}
	public void setFlightDepTime(String flightDepTime) {
		this.flightDepTime = flightDepTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}
	public String getPassNames() {
		return passNames;
	}
	public void setPassNames(String passNames) {
		this.passNames = passNames;
	}
	

}
