package com.ts.anisoul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EpisodeDAO;

@RestController
public class EpisodeController {

	@Autowired
	EpisodeDAO epDAO;
	
	
}