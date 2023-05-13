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

	public Episode RegisterEpisode(Episode episode) {
		// TODO Auto-generated method stub
		return epiRepo.save(episode);
	}

	public void DeleteEpisode(int episodeId) {
		// TODO Auto-generated method stub
		epiRepo.deleteById(episodeId);
	}

	public List<Episode> GetAllEpisodes() {
		// TODO Auto-generated method stub
		return epiRepo.findAll();
	}

	public List<Episode> getEpisode(Anime anime) {
		return epiRepo.findEpList(anime);
	}
	public List<Episode> GetEpisodeByAnimeId(int animeId) {
		// TODO Auto-generated method stub
		
		return epiRepo.GetEpisodeByAnimeId(animeId);
	}

	public void RegisterListEpisode(List<Episode> episode) {
		for(Episode episode1  :episode){
			epiRepo.save(episode1);
			System.out.println("sucess");
		}
	}
}
