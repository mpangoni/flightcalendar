package br.pangoni.flightcalendar.application;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pangoni.flightcalendar.domain.Trip;

@RestController
@RequestMapping(value="/shopcart")
public class ShowShopCartController {
	
	@GetMapping(value="/show")
	public List<Trip> showSelectedTrips(){
		return null;
	}
	
	@DeleteMapping(value="/remove")
	public List<Trip> removeTrip(String id){
		return null;
	}
	
	@PostMapping(value="/checkout")
	public boolean checkout(){
		return false;
	}
}