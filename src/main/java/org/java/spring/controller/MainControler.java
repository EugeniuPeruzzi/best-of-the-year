package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainControler {
	
	private List<Song> getBestSong(){
		
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(0, "Akon - Smack That"));
		songs.add(new Song(1, "Eminem - Mockin' Bird"));
		songs.add(new Song(2, "Slipknot - The Devil In I"));
		songs.add(new Song(3, "Jericho - Iniko"));
		songs.add(new Song(4, "Brenan Ssavage - Scars"));
		songs.add(new Song(5, "Tiesto - Lay Low"));
		songs.add(new Song(6, "Ahmed Spins - Anchor Point"));
		songs.add(new Song(7, "Post Malone Hollywood's Bleeding"));

		
		return songs;	
	}
	
	private List<Movie> getBestMovies() {

	    List<Movie> movies = new ArrayList<>();
	    movies.add(new Movie(0, "The Shawshank Redemption"));
	    movies.add(new Movie(1, "The Godfather"));
	    movies.add(new Movie(2, "The Dark Knight"));
	    movies.add(new Movie(3, "Pulp Fiction"));
	    movies.add(new Movie(4, "Schindler's List"));
	    movies.add(new Movie(5, "Forrest Gump"));
	    movies.add(new Movie(6, "The Matrix"));
	    movies.add(new Movie(7, "Inception"));

	    return movies;
	}

	//passaggio di una variabile al html
	@GetMapping("/")
	public String myName(Model model) {
		
		final String username = "Eugeniu";
		
		model.addAttribute("username", username);
		return "index";
	}
	
	
	@GetMapping("/song")
	public String songsRoute(Model model) {
	    List<Song> songsList = getBestSong();
	    StringBuilder songTitles = new StringBuilder();
	    for (Song song : songsList) {
	        songTitles.append(song.getTitolo());
	        songTitles.append(", ");
	    }
	    model.addAttribute("canzoni", songTitles);
	    return "Song";
	}
	
	@GetMapping("/movie")
	public String movieRoute(Model model) {
	    List<Movie> moviesList = getBestMovies();
	    StringBuilder movieTitles = new StringBuilder();
	    for (Movie movie : moviesList) {
	    	movieTitles.append(movie.getTitolo());
	    	movieTitles.append(", ");
	    }
	    model.addAttribute("film", movieTitles);
	    return "Movie";
	}
	
	@GetMapping("/song/{id}")
	public String songsRouteId(Model model,
			@PathVariable int id) {
	    List<Song> songsList = getBestSong();
	    StringBuilder songTitles = new StringBuilder();
	    for (Song song : songsList) {
	        if(song.getId() == id) {
	        	songTitles.append(song.getTitolo());
	        }
	    }
	    model.addAttribute("canzone", songTitles);
	    return "SongId";
	}
	
	@GetMapping("/movie/{id}")
	public String movieRouteId(Model model,
			@PathVariable int id) {
	    List<Movie> moviesList = getBestMovies();
	    StringBuilder movieTitles = new StringBuilder();
	    for (Movie movie : moviesList) {
	        if(movie.getId() == id) {
	        	movieTitles.append(movie.getTitolo());
	        }
	    }
	    model.addAttribute("film", movieTitles);
	    return "MovieId";
	}
	
//	@GetMapping("/song")
//	public String songsRoute(Model model) {
//	    List<Song> songsList = getBestSong();
//	    String songTitles = songsList.stream()
//	    		.map(Song::getTitolo)
//	    		.collect(Collectors.joining(", "));
//	    model.addAttribute("canzoni", songTitles);
//	    return "Song";
//	}
	
	
//	@GetMapping("/movie")
//	public String moviesRoute(Model model) {
//	    List<Movie> moviesList = getBestMovies();
//	    String movieTitles = moviesList.stream()
//	        .map(Movie::getTitolo)
//	        .collect(Collectors.joining(", "));
//	    model.addAttribute("film", movieTitles);
//	    return "Movie";
//	}
	
}
