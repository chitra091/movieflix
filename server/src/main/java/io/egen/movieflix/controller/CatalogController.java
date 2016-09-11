package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Catalog;
import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Rate;
import io.egen.movieflix.service.CatalogService;

@RestController
@RequestMapping(value="/catalog", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CatalogController {
	@Autowired
	private CatalogService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Catalog> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Catalog findOne(@PathVariable String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="type/{type}")
	public List<Catalog> findByType(@PathVariable String type){
		return service.findByType(type);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="year/{year}")
	public List<Catalog> findByYear(@PathVariable int year){
		return service.findByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="top/{type}")
	public List<Catalog> findByTopRating(@PathVariable String type){
		return service.findByTopRating(type);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="genre/{genre}")
	public List<Catalog> findByGenre(@PathVariable String genre){
		return service.findByGenre(genre);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog create(@RequestBody Catalog catalog){
		return service.create(catalog);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog update(@PathVariable String id, @RequestBody Catalog catalog){
		return service.update(id, catalog);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete(@PathVariable String id){
		service.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rate", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog rate(@RequestBody Catalog catalog, @RequestBody Rate rate){
		return service.rate(catalog,rate);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/rate/{title}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public float view_ratings(@PathVariable String title){
		return service.view_rating(title);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/comment", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog comment(@RequestBody Catalog catalog, @RequestBody Comments comments){
		return service.comment(catalog,comments);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/comment/{title}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog comment(@PathVariable String title){
		return service.view_comment(title);
	}
}
