package br.pangoni.flightcalenader.infrastrucuture;

import org.junit.Test;

import br.pangoni.flightme.infrastructure.content.QueryFlightsCommand;

public class QueryFlightsCommandTest {

	@Test
	public void testParseObject() {
		new  QueryFlightsCommand(new DummyContentProvider()).execute();
	}
}
