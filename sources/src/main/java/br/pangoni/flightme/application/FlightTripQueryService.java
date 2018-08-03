package br.pangoni.flightme.application;

import java.util.List;

import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;
import br.pangoni.flightme.domain.model.flighttrip.TripCriteria;
import br.pangoni.flightme.domain.model.shopcart.ShopCart;

public interface FlightTripQueryService {

	public List<FlightTrip> queryFlightTrips(TripCriteria criteria);
	
	public void selectFlightTrip(ShopCart cart, FlightTrip flightTrip);

}
