package com.ts.anisoul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EpisodeDAO;
import com.dto.Episode;

@RestController
public class EpisodeController {

	@Autowired
	EpisodeDAO epDAO;
	
	@PostMapping("/RegisterEpisode")
	public Episode RegisterEpisode(@RequestBody Episode episode){
		return epDAO.RegisterEpisode(episode);
		
	}
	
	
}
