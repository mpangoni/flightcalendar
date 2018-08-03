package br.pangoni.flightme.domain.model.flighttrip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

import br.pangoni.flightme.infrastructure.content.ContentProvider;
import br.pangoni.flightme.infrastructure.content.QueryFlightsCommand;
import br.pangoni.flightme.infrastructure.content.TripListBuilder;

@Component
public class TripQueryService {

	@Autowired
	private ContentProvider provider;
	
    public List<FlightTrip> execute(TripCriteria criteria) {
    	
    	QueryFlightsCommand command = new QueryFlightsCommand(this.provider);
    
    	command.setDepartureDate( criteria.getDepartureDate() );
    	command.setReturnDate( criteria.getReturnDate() );
    	command.setOriginCityIATACode( criteria.getOriginCode() );
    	command.setDestinyCityIATACode( criteria.getDestinyCode() );

    	return parse(command.execute());
     	
    }
    
    private List<FlightTrip> parse(JsonNode json){
    	
    	TripListBuilder builder = new TripListBuilder();
    	
    	return builder.build(json);
    	
    }
}