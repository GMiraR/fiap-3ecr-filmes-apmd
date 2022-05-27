package br.com.fiap.movies.domain;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String synopsis;

	private String genre;

	private String streaming;

	private boolean wasMovieWatched;

	private int rating;
	
	public Vector<String> getDataArray() {
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(title);
		data.add(synopsis);
		data.add(genre);
		data.add(streaming);
		data.add(wasMovieWatched ? "yes" : "no");
		data.add(rating +"");
		
		return data;
	}


	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getTitle() { return title; }

	public void setTitle(String titulo) { this.title = titulo; }

	public String getSynopsis() { return synopsis; }

	public void setSynopsis(String sinopse) { this.synopsis = sinopse; }

	public String getGenre() { return genre; }

	public void setGenre(String genero) { this.genre = genero; }

	public String getStreaming() { return streaming; }

	public void setStreaming(String ondeAssistir) { this.streaming = ondeAssistir; }

	public boolean isWasMovieWatched() { return wasMovieWatched; }

	public void setWasMovieWatched(boolean assistido) { this.wasMovieWatched = assistido; }

	public int getRating() { return rating; }


	public void setRating(int avaliacao) { this.rating = avaliacao; }
	
	

}
