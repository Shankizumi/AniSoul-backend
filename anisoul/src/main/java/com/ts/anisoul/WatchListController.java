package com.ts.anisoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.WatchListDAO;
import com.dto.WatchList;

@RestController
public class WatchListController {
	
	@Autowired
	WatchListDAO wlDAO;
	
	@PostMapping("/RegisterWatchList")
	public WatchList RegisterWatchList(@RequestBody WatchList watchlist){
		return wlDAO.RegisterWatchList(watchlist);
		
	}
	
	@DeleteMapping("/DeleteWatchList/{userId}/{animeId}")
	public String DeleteWatchList(@PathVariable("userId") int userId,@PathVariable("animeId") int animeId){
		 wlDAO.DeleteWatchList(userId,animeId);
		 return "Deleted WatchList Successfully";
	}
	
	@GetMapping("GetWatchListByUserId/{userId}")
	public List<WatchList> GetWatchListByUserId(@PathVariable("userId") int userId){
		return wlDAO.GetWatchListByUserId(userId);
		
	}

}