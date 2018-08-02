package br.pangoni.flightcalendar.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pangoni.flightcalendar.domain.Trip;
import br.pangoni.flightcalendar.domain.TripCriteria;
import br.pangoni.flightcalendar.domain.TripQuery;


@RestController
@RequestMapping(value="/trips")
public class SearchTripController {

	@Autowired
	private TripQuery query;
	
    @GetMapping(value="/search")
    public List<Trip> queryTrips(TripCriteria criteria) {
    	
    	criteria = new TripCriteria("2018-08-15", "GRU", "2018-08-20", "LAX");
    	
        return this.query.execute(criteria);
    }

    @PostMapping(value="/select")
    public void selectTrip(String id) {

    }
}