package br.pangoni.flightme.domain.model.shopcart;

import java.io.Serializable;
import java.util.Set;

import br.pangoni.flightme.domain.model.Entity;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;

public class ShopCart extends Entity implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7419361121566450971L;
	
	private long accountId;
	private Set<FlightTrip> selections;

	
	public long getAccountId(){
		return this.accountId;
	}
	
	public void setAccountId(long id){
		this.accountId = id;
	}
	
	public void addFlightTrip(FlightTrip flightTrip){
		this.selections.add(flightTrip);
	}
	
}