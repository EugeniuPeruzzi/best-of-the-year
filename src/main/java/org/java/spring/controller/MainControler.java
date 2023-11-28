package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControler {
	
	private List<Song> getBestSong(){
		
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Akon - Smack That"));
		songs.add(new Song(2, "Eminem - Mockin' Bird"));
		songs.add(new Song(3, "Slipknot - The Devil In I"));
		songs.add(new Song(4, "Jericho - Iniko"));
		songs.add(new Song(5, "Brenan Ssavage - Scars"));
		songs.add(new Song(6, "Tiesto - Lay Low"));
		songs.add(new Song(7, "Ahmed Spins - Anchor Point"));
		songs.add(new Song(8, "Post Malone Hollywood's Bleeding"));

		
		return songs;	
	}
	
	private List<Movie> getBestMovies() {

	    List<Movie> movies = new ArrayList<>();
	    movies.add(new Movie(1, "The Shawshank Redemption"));
	    movies.add(new Movie(2, "The Godfather"));
	    movies.add(new Movie(3, "The Dark Knight"));
	    movies.add(new Movie(4, "Pulp Fiction"));
	    movies.add(new Movie(5, "Schindler's List"));
	    movies.add(new Movie(6, "Forrest Gump"));
	    movies.add(new Movie(7, "The Matrix"));
	    movies.add(new Movie(8, "Inception"));

	    return movies;
	}

	
	
	//passaggio di una variabile al html
	@GetMapping("/")
	public String myName(Model model) {
		
		final String username = "Eugeniu";
		
		model.addAttribute("username", username);
		return "index";
	}
}
