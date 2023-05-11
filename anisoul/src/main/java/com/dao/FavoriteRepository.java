package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer>{

	@Query("from Favorite f where f.userId = :userId")
	public List<Favorite> GetFavoriteByUserId(@Param("userId") int userId);

	@Modifying
	@Transactional
	@Query("DELETE FROM Favorite f WHERE f.animeId = :animeId AND f.userId = :userId")
	public void DeleteFavorite(@Param("userId") int userId,@Param("animeId") int animeId);

}
