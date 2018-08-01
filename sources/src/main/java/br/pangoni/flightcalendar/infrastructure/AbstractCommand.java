package br.pangoni.flightcalendar.infrastructure;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractCommand {

	protected ContentProvider provider;
	
	public AbstractCommand(ContentProvider provider) {
		this.provider = provider;
	}
		
    public abstract JsonNode execute();

}