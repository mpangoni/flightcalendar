package br.pangoni.flightcalendar.infrastructure;

public interface ContentProvider{
	
    public String invoke(String method, String path, String parameters);
}