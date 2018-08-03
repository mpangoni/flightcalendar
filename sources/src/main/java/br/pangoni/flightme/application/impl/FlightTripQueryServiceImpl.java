package br.pangoni.flightme.application.impl;

import java.util.List;

import br.pangoni.flightme.application.FlightTripQueryService;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;
import br.pangoni.flightme.domain.model.flighttrip.TripCriteria;
import br.pangoni.flightme.domain.model.shopcart.ShopCart;
import br.pangoni.flightme.domain.model.shopcart.ShopCartRepository;

public class FlightTripQueryServiceImpl implements FlightTripQueryService{

	private ShopCartRepository shopCartRepository;
	
	@Override
	public List<FlightTrip> queryFlightTrips(TripCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectFlightTrip(ShopCart shopCart, FlightTrip flightTrip) {
		// TODO Auto-generated method stub
		
	}

}
