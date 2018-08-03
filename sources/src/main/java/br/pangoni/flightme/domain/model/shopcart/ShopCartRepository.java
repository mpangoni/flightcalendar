package br.pangoni.flightme.domain.model.shopcart;

public interface ShopCartRepository {

	public ShopCart loadShopCart(String email);
	
	public void saveShopCart(ShopCart shopCart);
}
