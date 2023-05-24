package com.ts.anisoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.FavoriteDAO;
/*import com.dao.FavoriteDAO;
*/
import com.dto.Favorite;
import com.dto.WatchList;

@RestController
public class FavoriteController {

	@Autowired
	FavoriteDAO favDAO;

	@PostMapping("/RegisterFavorite")
	public Favorite RegisterFavorite(@RequestBody Favorite favorite) {
		List<Favorite> allAnime = favDAO.GetFavoriteByUserId(favorite.getUserId());

		for (Favorite ob : allAnime) {
			if (ob.getAnimeTitle().equals(favorite.getAnimeTitle())) {
				return null;
			}
		}
		return favDAO.RegisterFavorite(favorite);
	}

	@GetMapping("/GetFavoriteByUserId/{userId}")
	public List<Favorite> GetFavoriteByUserId(@PathVariable("userId") int userId) {
		return favDAO.GetFavoriteByUserId(userId);

	}

	@DeleteMapping("/DeleteFavorite/{favoriteId}")
	public String DeleteFavorite(@PathVariable("favoriteId") int favoriteId) {
		favDAO.DeleteFavorite(favoriteId);
		return "Favorite Deleted Successfully";
	}
}
