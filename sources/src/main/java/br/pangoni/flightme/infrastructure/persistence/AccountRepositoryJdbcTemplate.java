package br.pangoni.flightme.infrastructure.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.pangoni.flightme.domain.model.account.Account;
import br.pangoni.flightme.domain.model.account.AccountRepository;
import br.pangoni.flightme.domain.model.account.PersonalData;

@Repository
public class AccountRepositoryJdbcTemplate implements AccountRepository{

	private static final String QUERY_IS_NEW_ACCOUNT =
			"SELECT COUNT(email) FROM accounts WHERE email = ?";
	
	private static final String QUERY_FOR_ACCOUNT =
			"SELECT id, email, "
			     + "firstName, lastName, "
			     + "firstAddress, secondAddress, "
			     + "city, state, zipcode " 
		    + "FROM accounts WHERE email = ?";
			     
	private static final String INSERT_FOR_ACCOUNT =
			"INSERT "
	        + "INTO accounts (email, firstName, lastName, firstAddress, secondAddress, city, state, zipcode)"
		  + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_FORM_ACCOUNT = 
			"UPDATE accounts"
			+  "SET firstName = ?, lastName = ?, "
			+      "firstAddress = ?, secondAddress = ?, "
			+       "city = ?, state = ?, zipcode = ? "
		   + "WHERE id = ?";
			
	@Autowired	
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean isNewAccount(String email) {
		
		Integer result = this.jdbcTemplate.queryForObject(QUERY_IS_NEW_ACCOUNT, 
				new Object[]{email}, Integer.class);

		return result.intValue() == 0;
	}

	@Override
	public Account loadAccount(String email) {
		
		return this.jdbcTemplate.queryForObject(QUERY_FOR_ACCOUNT, 
				new Object[]{email}, new AccountRowMapper());

	}

	@Override
	public void saveAccount(Account account) {
		
		if(account.isNewAccount()) {
			insertAccount(account);
		}else{
			updatePersonalData(account.getId(), account.getPersonalData());
		}
	}
	
	private long insertAccount(Account account) {

		KeyHolder holder = new GeneratedKeyHolder();
	    
	    jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                
            	PreparedStatement ps = connection.prepareStatement(INSERT_FOR_ACCOUNT, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, account.getEmail());
                
                if(account.getPersonalData()!= null) {
                    PersonalData data = account.getPersonalData();
                    
                	ps.setString(2, data.getFirstName());
                	ps.setString(3, data.getLastName());
                	ps.setString(4, data.getFirstAddress());
                	ps.setString(5, data.getSecondAddress());
                	ps.setString(6, data.getCity());
                	ps.setString(7, data.getState());
                	ps.setString(8, data.getZipcode());
                }

                return ps;
            }
        }, holder);
 
       account.setId(holder.getKey().intValue());
       return account.getId();        		
	}
	
	private int updatePersonalData(long id, PersonalData data) {
	 
		if(data != null) {
			
			return  jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(UPDATE_FORM_ACCOUNT, Statement.RETURN_GENERATED_KEYS);

                	ps.setString(1, data.getFirstName());
                	ps.setString(2, data.getLastName());
                	ps.setString(3, data.getFirstAddress());
                	ps.setString(4, data.getSecondAddress());
                	ps.setString(5, data.getCity());
                	ps.setString(6, data.getState());
                	ps.setString(7, data.getZipcode());

                	ps.setLong(8, id);
	                return ps;
	            }
	        });
			
		}
		
		return 0;
	}
}
