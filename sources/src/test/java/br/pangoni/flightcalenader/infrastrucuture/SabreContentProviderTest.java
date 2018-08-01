package br.pangoni.flightcalenader.infrastrucuture;

import org.junit.Test;

import br.pangoni.flightcalendar.infrastructure.SabreContentProvider;

public class SabreContentProviderTest {

	
	@Test
	public void testSimpleSabreConnection() {
		System.out.println(new SabreContentProvider().invoke("GET","v1/shop/flights","origin=SAO&destination=MIA&departuredate=2018-10-07&returndate=2018-10-09&onlineitinerariesonly=N&limit=50&offset=1&eticketsonly=N&sortby=departuretime&order=asc&sortby2=elapsedtime&order2=asc&pointofsalecountry=BR"));
	}
}
