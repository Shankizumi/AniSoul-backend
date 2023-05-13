package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.Anime;
import com.dto.Episode;
import com.dto.Favorite;
import com.dto.WatchList;

public interface EpisodeRepository extends JpaRepository<Episode, Integer>{

	@Query("from Episode e where e.anime = :anime")
	public List<Episode> findEpList(@Param("anime") Anime anime);
	
	@Query("SELECT e FROM Episode e WHERE e.anime.animeId = :animeId")
	public List<Episode> GetEpisodeByAnimeId(@Param("animeId") int animeId);
	
}
