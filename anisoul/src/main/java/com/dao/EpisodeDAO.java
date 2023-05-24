package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Anime;
import com.dto.Episode;

@Service
public class EpisodeDAO {

	@Autowired
	EpisodeRepository epiRepo;

//	registering the anime episode
	public Episode RegisterEpisode(Episode episode) {
		return epiRepo.save(episode);
	}

//	deleting anime episode using episodeId
	public void DeleteEpisode(int episodeId) {
		epiRepo.deleteById(episodeId);
	}

//	getting list of all episodes
	public List<Episode> GetAllEpisodes() {
		return epiRepo.findAll();
	}

//	getting list of all episodes for a specific anime
	public List<Episode> getEpisode(Anime anime) {
		return epiRepo.findEpList(anime);
	}

//	getting list of all episode based on animeId
	public List<Episode> GetEpisodeByAnimeId(int animeId) {

		return epiRepo.GetEpisodeByAnimeId(animeId);
	}

//	getting a list of episode
	public void RegisterListEpisode(List<Episode> episode) {
		for (Episode episode1 : episode) {
			epiRepo.save(episode1);
			System.out.println("sucess");
		}
	}
}
