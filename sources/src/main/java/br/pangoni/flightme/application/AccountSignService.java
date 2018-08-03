package br.pangoni.flightme.application;

import br.pangoni.flightme.domain.model.account.Account;

public interface AccountSignService {

	public Account signAccount(String email);
		
}
