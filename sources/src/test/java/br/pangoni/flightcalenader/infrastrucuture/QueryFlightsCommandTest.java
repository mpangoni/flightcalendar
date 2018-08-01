package br.pangoni.flightcalenader.infrastrucuture;

import org.junit.Test;

import br.pangoni.flightcalendar.infrastructure.QueryFlightsCommand;

public class QueryFlightsCommandTest {

	@Test
	public void testParseObject() {
		new  QueryFlightsCommand(new DummyContentProvider()).execute();
	}
}
