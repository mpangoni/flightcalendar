package br.pangoni.flightme.infrastructure.content;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.pangoni.flightme.domain.model.flighttrip.FlightSegment;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;

public class TripListBuilder {

	public List<FlightTrip> build(JsonNode json) {
		
		List<FlightTrip> result = new ArrayList<FlightTrip>();
		
		List<JsonNode> airItineraries = json.findValues("AirItinerary");
		
		for(JsonNode node: airItineraries){
			result.add( buildTrip(node) );	
		}
		
		return result;
	}
	
	private FlightTrip buildTrip(JsonNode json) {
				
		FlightSegment departure = null;
		FlightSegment returning = null;

		List<JsonNode> segments = json.findValues("FlightSegment");
		
		for(JsonNode node: segments){
			

			if(departure == null) {
				departure = buildFlightSegment(node);
			}else {
				returning = buildFlightSegment(node);
			}			

		}

		return new FlightTrip(departure, returning);
	}
	
	private FlightSegment buildFlightSegment(JsonNode json) {
	
		FlightSegment segment = new FlightSegment();

		int stops = 0;
				
		for(JsonNode node: json){

			String company = node.path("OperatingAirline").path("CompanyShortName").asText();
	
			if(company == null || company.isEmpty()) {
				company = node.path("OperatingAirline").path("Code").asText();
			}
			
			segment.setCompanyName(company);
				
			if(segment.getDepartureAirPort() == null) {
				
				String airport = node.path("DepartureAirport").path("LocationCode").asText();
				String dateTime = node.path("DepartureDateTime").asText();			
				
				segment.setDepartureAirPort(airport);
				segment.setDepartureDateTime(dateTime);
				
				airport = node.path("ArrivalAirport").path("LocationCode").asText();
				dateTime = node.path("ArrivalDateTime").asText();
				
				segment.setArrivalAirPort(airport);
				segment.setArrivalDateTime(dateTime);
				
			}else {
				
				String airport = node.path("ArrivalAirport").path("LocationCode").asText();
				String dateTime = node.path("ArrivalDateTime").asText();
				
				segment.setArrivalAirPort(airport);
				segment.setArrivalDateTime(dateTime);
				
				segment.setStops(++stops);				
			}
		}
		
		return segment;
	}
}
