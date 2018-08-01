package br.pangoni.flightcalendar.infrastructure;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QueryFlightsCommand extends AbstractCommand {

	private static final String METHOD = "GET";
	private static final String PATH = "v1/shop/flights";
	private static final String QUERY_TEMPLATE = "origin=%s&destination=%s&departuredate=%s&returndate=%s&onlineitinerariesonly=N&limit=10&offset=1&eticketsonly=N&sortby=departuretime&order=asc&sortby2=elapsedtime&order2=asc&pointofsalecountry=BR";

	private String departureDate;
	private String resturDate;
	
	private String originIATACode;
	private String destinyIATACode;
	
	
	public QueryFlightsCommand(ContentProvider provider) {
		super(provider);
	}

	public void setDepartureDate(String date) {
		this.departureDate = date;
	}

	public void setReturnDate(String date) {
		this.resturDate = date;
	}
	
	public void setOriginCityIATACode(String code) {
		this.originIATACode = code;
	}

	public void setDestinyCityIATACode(String code) {
		this.destinyIATACode = code;
	}

	@Override
	public JsonNode execute() {
		
		String query = String.format(QUERY_TEMPLATE, this.originIATACode, this.destinyIATACode, this.departureDate,this.resturDate);
		String json = provider.invoke(METHOD, PATH, query);
		
		return parse(json);

	}
	
	private JsonNode parse(String json) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		
			return mapper.readTree(json);

		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}