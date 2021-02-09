package com.ap.pokemon.emerson.api.pokemon.controller;

 import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ap.pokemon.emerson.api.pokemon.model.PokemonDetalle;
import com.ap.pokemon.emerson.api.pokemon.model.PokemonModel;
@Controller

public class PokemonController {
	
	private static String url = "https://pokeapi.co/api/v2/pokemon-species";
	
	@Autowired
	private RestTemplate restTemplate;
	

	@RequestMapping("/")
	public String pokemon(Model model) {
		return "index";
	}
	
	
	@RequestMapping("/listaPokemonPaginacion/{offset}")
	public String listaPokemonPaginacion(@PathVariable("offset") String offset , Model model) {
		
		String pathAdicional = url+"?offset="+offset+"&limit=20";
 		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setSupportedMediaTypes(Collections.singletonList(org.springframework.http.MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		try {
			 result = restTemplate.exchange(pathAdicional,HttpMethod.GET,new HttpEntity<>(headers), PokemonModel.class);		 
		}catch (Exception e) {	
			System.out.print("Error" + e);
 		}
		
		PokemonModel datos = (PokemonModel) result.getBody();		
		model.addAttribute("pokemon", datos.getResults());
 		return "listado";
 	}
	
	
	
	
	@RequestMapping("/listaPokemon")
	public String pokemonLista(Model model) {
 		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setSupportedMediaTypes(Collections.singletonList(org.springframework.http.MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		try {
			 result = restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<>(headers), PokemonModel.class);		 
		}catch (Exception e) {	
			System.out.print("Error" + e);
 		}
		
		PokemonModel datos = (PokemonModel) result.getBody();		
		model.addAttribute("pokemon", datos.getResults());
 		return "listado";
 	}
	
	
	@GetMapping("/listaPokemonVerMas/{urlDetalle}")
	public String listaPokemonVerMas(@PathVariable("urlDetalle") String urlDetalle ,   Model model  )  {
		
		System.out.print("Entro"  + urlDetalle.toString());
		 
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setSupportedMediaTypes(Collections.singletonList(org.springframework.http.MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		try {
			 result = restTemplate.exchange(urlDetalle,HttpMethod.GET,new HttpEntity<>(headers), PokemonDetalle.class);		 
		}catch (Exception e) {	
			System.out.print("Error" + e);
 		}
		
		PokemonDetalle datos = (PokemonDetalle) result.getBody();		
		model.addAttribute("colorPokemon", datos.getColor());
		model.addAttribute("grupoPokemon", datos.getEgg_groups());
		model.addAttribute("evolucionPokemon", datos.getEvolution_chain());
		model.addAttribute("TextoPokemon", datos.getFlavor_text_entries());

		 

		return "detalle";
		
	}
	
}
