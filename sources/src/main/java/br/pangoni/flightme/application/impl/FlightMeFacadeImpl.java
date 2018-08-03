package br.pangoni.flightme.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pangoni.flightme.application.AccountSignService;
import br.pangoni.flightme.application.FlightMeFacade;
import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.account.AccountRepository;

@Service
public class FlightMeFacadeImpl implements FlightMeFacade {

	@Autowired
	private AccountSignService accountSignService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account signAccount(String email) {
		return this.accountSignService.signAccount(email);
	}

	@Override
	public void updatePersonalData(Account account) {
		this.accountRepository.saveAccount(account);
	}

}
