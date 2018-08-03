package br.pangoni.flightme.domain.model.account;

import java.io.Serializable;

import br.pangoni.flightme.domain.model.Entity;
import br.pangoni.flightme.domain.model.shopcart.ShopCart;

public class Account extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5320245479803476671L;

	private String email;
	private boolean isNewAccount;
	
	private PersonalData personalData;
	private ShopCart shopCart;
	
	public Account(String email, boolean isNewAcount) {
		this.email = email;
		this.isNewAccount = isNewAcount;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public boolean isNewAccount(){
		return this.isNewAccount;
	}
	
	public PersonalData getPersonalData(){
		return this.personalData;
	}
	
	public void setPersonalData(PersonalData personalData){
		this.personalData = personalData;
	}
	
	public ShopCart getShopCart(){
		return this.shopCart;
	}
	
	public void setShopCart(ShopCart shopCart) {
		this.shopCart = shopCart;
	}
	
}
