package io.egen.movieflix.repository;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Actor;
import io.egen.movieflix.entity.Catalog;
import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Genre;
import io.egen.movieflix.entity.Rate;

@Repository
public class CatalogRepositoryImp implements CatalogRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Catalog> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findAll", Catalog.class);
		return query.getResultList();
	}

	@Override
	public List<Catalog> findByType(String type) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByType", Catalog.class);
		query.setParameter("type", type);
		List<Catalog> catalog = query.getResultList();
		return catalog;
	}

	@Override
	public List<Catalog> findByYear(int year) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByYear", Catalog.class);
		query.setParameter("year", year);
		List<Catalog> catalog = query.getResultList();
		return catalog;
	}

	@Override
	public Catalog create(Catalog catalog) {
		// TODO Auto-generated method stub
		List<Genre> g_list = new LinkedList<>();
		List<Actor> a_list = new LinkedList<>();
		String[] temp = catalog.getGenre().split(",");
		for(String a: temp){
			a = a.replaceAll(" ", "");
			Genre g = new Genre();
			g.setGenre(a);
			g_list.add(g);
			em.persist(g);
		}
		catalog.setGenres(g_list);
		String[] temp1 = catalog.getActors().split(",");
		for(String p: temp1){
			p = p.replaceAll(" ", "");
			Actor a = new Actor();
			a.setActor(p);
			a_list.add(a);
			em.persist(a);
		}
		catalog.setActors_list(a_list);
		em.persist(catalog);
		return catalog;
	}

	@Override
	public Catalog update(String id, Catalog catalog) {
		// TODO Auto-generated method stub
		return em.merge(catalog);
	}

	@Override
	public void delete(Catalog catalog) {
		// TODO Auto-generated method stub
		em.remove(catalog);
	}

	@Override
	public List<Catalog> findByTopRating(String type) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByTopRating", Catalog.class);
		query.setParameter("type", type);
		List<Catalog> catalog = query.getResultList();
		return catalog;
	}

	@Override
	public List<Catalog> findByGenre(String genre) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByGenre", Catalog.class);
		query.setParameter("genre", "%"+genre+"%");
		List<Catalog> catalog = query.getResultList();
		return catalog;
	}

	@Override
	public Catalog findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(Catalog.class, id);
	}

	@Override
	public Catalog rate(Catalog catalog, Rate rate) {
		// TODO Auto-generated method stub
		em.persist(rate);
		List<Rate> rate_list = new LinkedList<>();
		rate_list.add(rate);
		catalog.setRate(rate_list);
		return em.merge(catalog);
	}

	@Override
	public Catalog comment(Catalog catalog, Comments comments) {
		// TODO Auto-generated method stub
		em.persist(comments);
		List<Comments> comment_list = new LinkedList<>();
		comment_list.add(comments);
		catalog.setComments(comment_list);
		return em.merge(catalog);
	}

	@Override
	public Catalog view_comment(String title) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByTitle", Catalog.class);
		query.setParameter("title", "%"+title+"%");
		List<Catalog> catalog = query.getResultList();
		return catalog.get(0);
	}

	@Override
	public Catalog view_rating(String title) {
		// TODO Auto-generated method stub
		TypedQuery<Catalog> query = em.createNamedQuery("Catalog.findByTitle", Catalog.class);
		query.setParameter("title", "%"+title+"%");
		List<Catalog> catalog = query.getResultList();
		return catalog.get(0);
	}
}
