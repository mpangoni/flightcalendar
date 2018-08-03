package br.pangoni.flightme.domain.model.account;

import java.io.Serializable;

public class PersonalData implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	
	private String firstAddress;
	private String secondAddress;
	private String city;
	private String state;
	private String zipcode;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstAddress() {
		return firstAddress;
	}
	public void setFirstAddress(String address) {
		this.firstAddress = address;
	}
	public String getSecondAddress() {
		return secondAddress;
	}
	public void setSecondAddress(String address) {
		this.secondAddress = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
