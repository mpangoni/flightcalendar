package br.pangoni.flightme.interfaces.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pangoni.flightme.application.FlightMeFacade;
import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;

@RestController
public class FlightMeController {

	@Autowired
	private FlightMeFacade facace;
	
	@PostMapping(value="/account/sign")
	public Account signAccount(String email){
		return facace.signAccount(email);
	}

	@PostMapping(value="/account/update")
	public void updateAccount(Account account){
		this.facace.updatePersonalData(account);
	}

	
	@PostMapping(value="/trips/query")
	public List<FlightTrip> queryTrips(){
		return null;
	}

	@PostMapping(value="/trips/select")
	public void selectTrip(){

	}

	@PostMapping(value="/shopcart/show")
	public void showShopCartOptions(){

	}

	@PostMapping(value="/shopcart/remove")
	public void removeShopCartOption(){

	}

}
