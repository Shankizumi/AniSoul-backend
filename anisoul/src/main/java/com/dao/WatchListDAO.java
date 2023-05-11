package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dto.WatchList;

@Service
public class WatchListDAO {
	
	@Autowired
	WatchListRepository wlRepo;

	public WatchList RegisterWatchList(WatchList watchlist) {
		// TODO Auto-generated method stub
		return wlRepo.save(watchlist);
	}
	

	public void DeleteWatchList(int animeId) {
		// TODO Auto-generated method stub
		 wlRepo.DeleteWatchList(animeId);		
	}

	public List<WatchList> GetWatchListByUserId(int userId) {
		// TODO Auto-generated method stub
		if(wlRepo.GetWatchListByUserId(userId)==null){
		return null;
		}
		return wlRepo.GetWatchListByUserId(userId);
	}

}
