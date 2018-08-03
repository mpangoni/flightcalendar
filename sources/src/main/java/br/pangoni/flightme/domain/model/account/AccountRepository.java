package br.pangoni.flightme.domain.model.account;

public interface AccountRepository {

	public boolean isNewAccount(String email);
	
	public Account loadAccount(String email);
	
	public void saveAccount(Account account);
}
