package br.pangoni.flightcalendar.domain;

import java.io.Serializable;

public class Trip implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 359564733781744326L;
	
	private FlightSegment departure;
	private FlightSegment returning;
	
	public Trip(FlightSegment departure, FlightSegment returning) {
		this.departure = departure;
		this.returning = returning; 
	}


	public FlightSegment getDeparture() {
		return departure;
	}

	public FlightSegment getReturning() {
		return returning;
	}
	
}