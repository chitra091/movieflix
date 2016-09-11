package io.egen.movieflix.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Catalog;
import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Rate;
import io.egen.movieflix.exception.RatingInvalid;
import io.egen.movieflix.repository.CatalogRepository;
@Service
public class CatalogServiceImp implements CatalogService {
	@Autowired
	private CatalogRepository repository;
	
	@Override
	public List<Catalog> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Catalog> findByType(String type) {
		// TODO Auto-generated method stub
		return repository.findByType(type);
	}

	@Override
	public List<Catalog> findByYear(int year) {
		// TODO Auto-generated method stub
		return repository.findByYear(year);
	}
	
	@Transactional
	@Override
	public Catalog create(Catalog catalog) {
		// TODO Auto-generated method stub
		return repository.create(catalog);
	}
	
	@Transactional
	@Override
	public Catalog update(String id, Catalog catalog) {
		// TODO Auto-generated method stub
		Catalog existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Catalog not found");
		}
		return repository.update(id,catalog);
	}

	@Transactional
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Catalog catalog = repository.findOne(id);
		if (catalog == null) {
			throw new EntityNotFoundException("Catalog not found");
		}
		repository.delete(catalog);
	}

	@Override
	public List<Catalog> findByTopRating(String type) {
		// TODO Auto-generated method stub
		return repository.findByTopRating(type);
	}

	@Override
	public List<Catalog> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return repository.findByGenre(genre);
	}

	@Override
	public Catalog findOne(String id) {
		// TODO Auto-generated method stub
		Catalog catalog = repository.findOne(id);
		if(catalog == null){
			throw new EntityNotFoundException("Catalog not found");
		}
		return repository.findOne(id);
	}

	@Override
	public Catalog rate(Catalog catalog, Rate rate) {
		// TODO Auto-generated method stub
		if(rate.getRating()>5){
			throw new RatingInvalid("Rating should be out of 5 stars");
		}
		Catalog cat = repository.findOne(catalog.getId());
		if(cat == null){
			throw new EntityNotFoundException("Catalog not found");
		}
		return repository.rate(catalog, rate);
	}

	@Override
	public Catalog comment(Catalog catalog, Comments comments) {
		// TODO Auto-generated method stub
		Catalog cat = repository.findOne(catalog.getId());
		if(cat == null){
			throw new EntityNotFoundException("Catalog not found");
		}
		return repository.comment(catalog, comments);
	}

	@Override
	public Catalog view_comment(String title) {
		// TODO Auto-generated method stub
		return repository.view_comment(title);
	}

	@Override
	public float view_rating(String title) {
		// TODO Auto-generated method stub
		Catalog catalog = repository.view_rating(title);
		if(catalog.getRate().isEmpty()){
			return 0;
		}
		else{
			float avg=0;
			for(Rate rate: catalog.getRate()){
				avg += rate.getRating();
			}
			return (avg/(float)catalog.getRate().size());
		}
	}
}
