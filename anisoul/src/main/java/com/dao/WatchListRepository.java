package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.WatchList;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Integer>{

	
	@Modifying
	@Transactional
	@Query("DELETE FROM WatchList w WHERE w.animeId = :animeId AND w.userId = :userId")
	public void DeleteWatchList(@Param("userId") int userId,@Param("animeId") int animeId);

	@Query("from WatchList w where w.userId = :userId")
	public List<WatchList> GetWatchListByUserId(@Param("userId") int userId);

}