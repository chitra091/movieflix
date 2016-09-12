package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Catalog;
import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Rate;

public interface CatalogRepository {

	public List<Catalog> findAll();

	public List<Catalog> findByType(String type);

	public List<Catalog> findByYear(int year);

	public Catalog create(Catalog catalog);

	public Catalog update(String id, Catalog catalog);

	public void delete(Catalog catalog);

	public List<Catalog> findByTopRating(String type);

	public List<Catalog> findByGenre(String genre);

	public Catalog findOne(String id);

	public Catalog rate(Catalog catalog, Rate rate);

	public Catalog comment(Catalog catalog, Comments comments);

	public Catalog view_comment(String title);

	public Catalog view_rating(String title);
}
