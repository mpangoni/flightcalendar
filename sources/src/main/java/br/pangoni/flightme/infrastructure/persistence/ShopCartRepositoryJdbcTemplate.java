package br.pangoni.flightme.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import br.pangoni.flightme.domain.model.shopcart.ShopCart;
import br.pangoni.flightme.domain.model.shopcart.ShopCartRepository;

@Repository
public class ShopCartRepositoryJdbcTemplate implements ShopCartRepository{

	@Override
	public ShopCart loadShopCart(String email) {
		return null;
	}

	@Override
	public void saveShopCart(ShopCart shopCart) {
		// TODO Auto-generated method stub
		
	}

}
