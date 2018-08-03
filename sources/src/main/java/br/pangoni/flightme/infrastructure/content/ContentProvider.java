package br.pangoni.flightme.infrastructure.content;

public interface ContentProvider{
	
    public String invoke(String method, String path, String parameters);
}