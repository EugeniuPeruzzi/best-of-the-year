package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControler {
	
	private List<Song> getBestSong(){
		return null;
		
	}
	
	
	//passaggio di una variabile al html
	@GetMapping("/")
	public String myName(Model model) {
		
		final String username = "Eugeniu";
		
		model.addAttribute("username", username);
		return "index";
	}
}
