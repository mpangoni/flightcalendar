package br.pangoni.flightme.infrastructure.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.account.PersonalData;

class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet resultset, int rowNum) throws SQLException {
		
		Account account = new Account(resultset.getString(2), false);		
		PersonalData data = new PersonalData();

		account.setId(resultset.getLong(1));
		account.setPersonalData( data );	

		data.setFirstName(resultset.getString(3));
		data.setLastName(resultset.getString(4));
		
		data.setFirstAddress(resultset.getString(5));
		data.setSecondAddress(resultset.getString(6));
		
		data.setCity(resultset.getString(7));
		data.setState(resultset.getString(8));
		data.setZipcode(resultset.getString(9));
		
		return account;
	}

}
