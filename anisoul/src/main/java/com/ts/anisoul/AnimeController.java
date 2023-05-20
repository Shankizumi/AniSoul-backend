package com.ts.anisoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AnimeDAO;
import com.dto.Anime;

@RestController
public class AnimeController {
	
	@Autowired
	AnimeDAO animeDAO;
	
	@GetMapping("/GetAnimeBySection/{animeSection}")
	public List<Anime> GetAnimeBySection(@PathVariable("animeSection") String animeSection){
		return animeDAO.GetAnimeBySection(animeSection);
		
	}
	
	@PostMapping("/RegisterAnime")
	public Anime RegisterAnime(@RequestBody Anime anime){
		System.out.println(anime.getAnimeId());
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
	
	@GetMapping("/GetAllAnime")
	public List<Anime> GetAllAnime(){
		return animeDAO.GetAllAnime();
		
	}
	
	@GetMapping("/GetAnimeByGenre/{Genre}")
	public List<Anime> GetAnimeByGenre(@PathVariable("Genre") String Genre){
		return animeDAO.GetAnimeByGenre(Genre);
		
	}
	
	@PutMapping("/UpdateAnime")
	public void UpdateAnime(@RequestBody Anime anime){
		 animeDAO.RegisterAnime(anime);
	}
	
	@DeleteMapping("/DeleteAnime/{animeId}")
	public void  DeleteAnime(@PathVariable("animeId") int animeId){
		
		 animeDAO.DeleteAnime(animeId);
		
	}

}
