package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Favorite;

@Service
public class FavoriteDAO {

	@Autowired
	FavoriteRepository favRepo;

	public Favorite RegisterFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		return favRepo.save(favorite);
	}

	public List<Favorite> GetFavoriteByUserId(int userId) {
		// TODO Auto-generated method stub
		if(favRepo.GetFavoriteByUserId(userId)==null){
		return null;
		}
		return favRepo.GetFavoriteByUserId(userId);
	}

	public void DeleteFavorite(int userId, int animeId) {
		// TODO Auto-generated method stub
		favRepo.DeleteFavorite(userId,animeId);
		
	}
}
