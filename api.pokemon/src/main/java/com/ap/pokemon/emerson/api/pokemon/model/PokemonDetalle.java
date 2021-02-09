package com.ap.pokemon.emerson.api.pokemon.model;

import java.util.List;

public class PokemonDetalle {

	private Integer base_happiness;
	private Integer  capture_rate;
	
	private List<?> color;
	private List<?>egg_groups;
	private List<?> evolution_chain;
	private String evolves_from_species;
	
	private List<?> flavor_text_entries;

	public Integer getBase_happiness() {
		return base_happiness;
	}

	public void setBase_happiness(Integer base_happiness) {
		this.base_happiness = base_happiness;
	}

	public Integer getCapture_rate() {
		return capture_rate;
	}

	public void setCapture_rate(Integer capture_rate) {
		this.capture_rate = capture_rate;
	}

	public List<?> getColor() {
		return color;
	}

	public void setColor(List<?> color) {
		this.color = color;
	}

	public List<?> getEgg_groups() {
		return egg_groups;
	}

	public void setEgg_groups(List<?> egg_groups) {
		this.egg_groups = egg_groups;
	}

	public List<?> getEvolution_chain() {
		return evolution_chain;
	}

	public void setEvolution_chain(List<?> evolution_chain) {
		this.evolution_chain = evolution_chain;
	}

	public String getEvolves_from_species() {
		return evolves_from_species;
	}

	public void setEvolves_from_species(String evolves_from_species) {
		this.evolves_from_species = evolves_from_species;
	}

	public List<?> getFlavor_text_entries() {
		return flavor_text_entries;
	}

	public void setFlavor_text_entries(List<?> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
	}
	
	
	
}
