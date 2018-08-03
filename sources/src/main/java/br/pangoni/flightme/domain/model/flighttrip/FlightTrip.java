package br.pangoni.flightme.domain.model.flighttrip;

import java.io.Serializable;

public class FlightTrip implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 359564733781744326L;
	
	private FlightSegment departure;
	private FlightSegment returning;
	
	public FlightTrip(FlightSegment departure, FlightSegment returning) {
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