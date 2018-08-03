package br.pangoni.flightme.domain.model.flighttrip;

import java.io.Serializable;

public class TripCriteria implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1003054285236294222L;
	
	
	private String departureDate;
    private String returnDate;
    private String originCode;
    private String destinyCode;

    public TripCriteria(){
    }
    
    public TripCriteria(String departureDate, String originCode, 
    		String returnDate, String destinyCode){
    	
    	this.departureDate = departureDate;
    	this.originCode = originCode;
    	this.returnDate = returnDate;
    	this.destinyCode = destinyCode;
    	
    }
    
    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String value) {
        this.departureDate = value;        
    }

    public String getReturnDate() {
       return this.returnDate;
    }

    public void setReturnDate(String value) {
        this.returnDate = value;        
    }

    public String getOriginCode() {
        return this.originCode;
    }

    public void setOriginCode(String value) {
        this.originCode = value;
    }

    public String getDestinyCode() {
        return this.destinyCode;
    }

    public void setDestinyCode(String value) {
        this.destinyCode = value;
    }

}