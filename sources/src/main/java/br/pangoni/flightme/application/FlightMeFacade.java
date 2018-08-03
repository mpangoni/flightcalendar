package br.pangoni.flightme.application;

import java.util.List;

import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;
import br.pangoni.flightme.domain.model.flighttrip.TripCriteria;

public interface FlightMeFacade {

	public Account signAccount(String email);
	
	public void updatePersonalData(Account account);
	
}
