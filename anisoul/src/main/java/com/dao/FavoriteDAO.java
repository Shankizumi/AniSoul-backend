package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Favorite;

@Service
public class FavoriteDAO {

	@Autowired
	FavoriteRepository favRepo;

//	adding anime to favourite list
	public Favorite RegisterFavorite(Favorite favorite) {
		return favRepo.save(favorite);
	}

//	getting a list of anime from favorite list based on userId
	public List<Favorite> GetFavoriteByUserId(int userId) {
		if (favRepo.GetFavoriteByUserId(userId) == null) {
			return null;
		}
		return favRepo.GetFavoriteByUserId(userId);
	}

//	delete anime card based on favoriteId
	public void DeleteFavorite(int favoriteId) {
		favRepo.DeleteFavorite(favoriteId);

	}
}
