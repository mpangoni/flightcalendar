package br.pangoni.flightme.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pangoni.flightme.application.AccountSignService;
import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.account.AccountRepository;
import br.pangoni.flightme.domain.model.account.PersonalData;
import br.pangoni.flightme.domain.model.shopcart.ShopCart;
import br.pangoni.flightme.domain.model.shopcart.ShopCartRepository;

@Service
public class AccountSignServiceImpl implements AccountSignService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ShopCartRepository shopCartRepository;
	
	@Override
	public Account signAccount(String email) {
		
		if(this.accountRepository.isNewAccount(email)) {

			Account account = new Account(email, true);
			
			account.setPersonalData(new PersonalData());
			account.setShopCart(new ShopCart());
			
			this.accountRepository.saveAccount(account);
		
			return account;
			
		}else{
			
			Account account = this.accountRepository.loadAccount(email);
			ShopCart shopCart = this.shopCartRepository.loadShopCart(email);
			
			account.setShopCart(shopCart);
			
			return account;
		}
	}
}
