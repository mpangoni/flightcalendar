package br.pangoni.flightme.domain.model.flighttrip;

import java.io.Serializable;

public class FlightSegment implements Serializable{

	private String companyName;
	
	private String departureDateTime;
	private String departureAirPort;
	
	private String arrivalDateTime;
	private String arrivalAirPort;
	
	private int delayTime;
	private int stops;

	public FlightSegment() {
		
	}

	public FlightSegment(String companyName, 
			String departureDateTime, String departureAirPort,
			String arrivalDateTime, String arrivalAirPort,
			int delayTime, int stops){
		
		this.companyName = companyName;
		
		this.departureDateTime = departureDateTime;
		this.departureAirPort = departureAirPort;
		
		this.arrivalDateTime = arrivalAirPort;
		this.arrivalAirPort = arrivalAirPort;
		
		this.delayTime = delayTime;
		this.stops = stops;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getDepartureAirPort() {
		return departureAirPort;
	}

	public void setDepartureAirPort(String departureAirPort) {
		this.departureAirPort = departureAirPort;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getArrivalAirPort() {
		return arrivalAirPort;
	}

	public void setArrivalAirPort(String arrivalAirPort) {
		this.arrivalAirPort = arrivalAirPort;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDealayTime(int delayTime) {
		this.delayTime = delayTime;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

}
