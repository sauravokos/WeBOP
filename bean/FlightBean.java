package com.wipro.frs.bean;

public class FlightBean 
{
	int flightId;
	String source;
	String destination;
	float duration;
	int totalSeats;
	float distance;
	String depTime;
	String arrTime;
	int price;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
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
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
