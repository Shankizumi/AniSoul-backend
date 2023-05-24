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

import com.dao.EpisodeDAO;
import com.dto.Anime;
import com.dto.Episode;

@RestController
public class EpisodeController {

	@Autowired
	EpisodeDAO epDAO;

	@PostMapping("/RegisterEpisode")
	public Episode RegisterEpisode(@RequestBody Episode episode) {
		System.out.println("hii");
		return epDAO.RegisterEpisode(episode);

	}

	@PostMapping("/RegisterListEpisode")
	public void RegisterListEpisode(@RequestBody List<Episode> episode) {
		epDAO.RegisterListEpisode(episode);

	}

	@GetMapping("/GetAllEpisodes")
	public List<Episode> GetAllEpisodes() {
		return epDAO.GetAllEpisodes();

	}

	@PutMapping("/UpdateEpisode")
	public Episode UpdateEpisode(@RequestBody Episode episode) {
		return epDAO.RegisterEpisode(episode);
	}

	@DeleteMapping("/DeleteEpisode/{episodeId}")
	public void DeleteEpisode(@PathVariable("episodeId") int episodeId) {
		epDAO.DeleteEpisode(episodeId);
		System.out.println("hello");

	}

	@GetMapping("/GetEpisodeById")
	public List<Episode> getEpisodeById(@RequestBody Anime anime) {
		return epDAO.getEpisode(anime);
	}

	@GetMapping("/GetEpisodeByAnimeId/{animeId}")
	public List<Episode> GetEpisodeByAnimeId(@PathVariable("animeId") int animeId) {
		return epDAO.GetEpisodeByAnimeId(animeId);

	}

}
