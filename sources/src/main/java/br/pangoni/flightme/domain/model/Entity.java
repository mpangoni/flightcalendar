package br.pangoni.flightme.domain.model;

public abstract class Entity {

	protected long id;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}
}
