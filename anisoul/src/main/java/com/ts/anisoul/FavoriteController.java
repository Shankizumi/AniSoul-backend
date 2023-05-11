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

@RestController
public class FavoriteController {

	@Autowired
	FavoriteDAO favDAO;
	
	@PostMapping("/RegisterFavorite")
	public Favorite RegisterFavorite(@RequestBody Favorite favorite){
		return favDAO.RegisterFavorite(favorite);		
	}
	
	@GetMapping("/GetFavoriteByUserId/{userId}")
	public List<Favorite> GetFavoriteByUserId(@PathVariable("userId") int userId){
		return favDAO.GetFavoriteByUserId(userId);
		
	}
	
	@DeleteMapping("/DeleteFavorite/{userId}/{animeId}")
	public String DeleteFavorite(@PathVariable("userId") int userId,@PathVariable("animeId") int animeId){
		favDAO.DeleteFavorite(userId,animeId);
		return "Favorite Deleted Successfully";
	}
}
