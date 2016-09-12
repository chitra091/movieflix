package io.egen.movieflix.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Genre.findByGenre", query = "SELECT g from Genre g where g.genre=:genre")
})
public class Genre {
	@Id
	private String id;
	private String genre;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Genre() {
		id = UUID.randomUUID().toString();
	}
}
