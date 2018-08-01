package br.pangoni.flightcalendar.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

import br.pangoni.flightcalendar.infrastructure.ContentProvider;
import br.pangoni.flightcalendar.infrastructure.QueryFlightsCommand;
import br.pangoni.flightcalendar.infrastructure.TripListBuilder;

@Component
public class TripQuery {

	@Autowired
	private ContentProvider provider;
	
    public List<Trip> execute(TripCriteria criteria) {
    	
    	QueryFlightsCommand command = new QueryFlightsCommand(this.provider);
    
    	command.setDepartureDate( criteria.getDepartureDate() );
    	command.setReturnDate( criteria.getReturnDate() );
    	command.setOriginCityIATACode( criteria.getOriginCode() );
    	command.setDestinyCityIATACode( criteria.getDestinyCode() );

    	return parse(command.execute());
     	
    }
    
    private List<Trip> parse(JsonNode json){
    	
    	TripListBuilder builder = new TripListBuilder();
    	
    	return builder.build(json);
    	
    }
}