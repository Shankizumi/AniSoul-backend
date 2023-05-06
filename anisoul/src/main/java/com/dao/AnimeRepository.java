package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer>{

	@Query("from Anime a where a.animeSection= :animeSection")
	public List<Anime> GetAnimeBySection(@Param("animeSection") String animeSection);


	@Query("from Anime a where a.animeTitle= :animeTitle")
	public Anime GetAnimeByTitle(@Param("animeTitle") String animeTitle);

}
