package br.pangoni.flightme.interfaces.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pangoni.flightme.application.FlightMeFacade;
import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.flighttrip.FlightTrip;

@RestController
public class FlightMeController {

	private static final Logger logger = LoggerFactory.getLogger(FlightMeController.class);
	
	@Autowired
	private FlightMeFacade facace;
	
	@PostMapping(value="/account/sign")
	public Account signAccount( @RequestBody String email ){
		
		logger.debug(String.format("sign account [%s]", email));
		
		Account account = facace.signAccount(email);
		
		return account;
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
