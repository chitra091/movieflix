package io.egen.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Catalog.findAll", query = "SELECT c from Catalog c"),
	@NamedQuery(name = "Catalog.findByType", query = "SELECT c from Catalog c where c.type=:type"),
	@NamedQuery(name = "Catalog.findByYear", query = "SELECT c from Catalog c where c.year=:year"),
	@NamedQuery(name = "Catalog.findByTopRating", query = "SELECT c from Catalog c where c.type=:type ORDER by c.imdbRating DESC"),
	@NamedQuery(name = "Catalog.findByGenre", query = "SELECT c from Catalog c where c.genre LIKE :genre"),
	@NamedQuery(name = "Catalog.findByTitle", query = "SELECT c from Catalog c where c.title LIKE :title")
})
public class Catalog {
	@Id
	private String id;
	@Column(unique = true)
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	@OneToMany
	private List<Genre> genres;
	private String director;
	private String writer;
	private String actors;
	@OneToMany
	private List<Actor> actors_list;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metascore;
	private String type;
	private float imdbRating;
	private int imdbVotes;
	private String imdbID;
	@OneToMany
	private List<Comments> comments;
	@OneToMany
	private List<Rate> rate;

	public Catalog() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public List<Actor> getActors_list() {
		return actors_list;
	}

	public void setActors_list(List<Actor> actors_list) {
		this.actors_list = actors_list;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbId(String imdbID) {
		this.imdbID = imdbID;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Rate> getRate() {
		return rate;
	}

	public void setRate(List<Rate> rate) {
		this.rate = rate;
	}
}
