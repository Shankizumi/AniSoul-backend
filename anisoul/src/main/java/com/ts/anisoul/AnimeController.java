package com.ts.anisoul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AnimeDAO;
import com.dto.Anime;

@RestController
public class AnimeController {
	
	@Autowired
	AnimeDAO animeDAO;
	
	@GetMapping("/GetAnimeBySection/{animeSection}")
	public Anime GetAnimeBySection(@PathVariable("animeSection") String animeSection){
		return animeDAO.GetAnimeBySection(animeSection);
		
	}
	
	@PostMapping("/RegisterAnime")
	public Anime RegisterAnime(@RequestBody Anime anime){
		return animeDAO.RegisterAnime(anime);
		
	}
	
	@GetMapping("/GetAnimeByTitle/{animeTitle}")
	public Anime GetAnimeByTitle(@PathVariable("animeTitle") String animeTitle ){
		return animeDAO.GetAnimeByTitle(animeTitle);
		
	}
	
	@GetMapping("/GetAnimeById/{animeId}")
	public Anime GetAnimeById(@PathVariable("animeId") int animeId){
		return animeDAO.GetAnimeById(animeId);
	}
	

}
