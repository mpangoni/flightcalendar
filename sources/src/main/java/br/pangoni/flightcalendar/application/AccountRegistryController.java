package br.pangoni.flightcalendar.application;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pangoni.flightcalendar.domain.Account;

@RestController
@RequestMapping(value="/account")
public class AccountRegistryController {

	@PostMapping(value="/update")
	public boolean updateAccount(Account account){
		return false;
	}
	
	@PostMapping(value="/signin")
	public boolean singinAccount(String email){
		return false;
	}
}
