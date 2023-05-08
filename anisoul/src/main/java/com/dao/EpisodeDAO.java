package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Episode;

@Service
public class EpisodeDAO {

	@Autowired
	EpisodeRepository epiRepo;

	public Episode RegisterEpisode(Episode episode) {
		// TODO Auto-generated method stub
		return epiRepo.save(episode);
	}
}
