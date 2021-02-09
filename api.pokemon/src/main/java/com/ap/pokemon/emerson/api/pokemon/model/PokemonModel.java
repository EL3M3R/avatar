package com.ap.pokemon.emerson.api.pokemon.model;

import java.util.ArrayList;
import java.util.List;

public class PokemonModel {

	private Integer count;
	private String next;
	private String previous;
	private  List<?> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<?> results) {
		this.results = results;
	}
	
	
	
	
}
