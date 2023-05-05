package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Integer>{

}
