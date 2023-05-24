package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.WatchList;

@Service
public class WatchListDAO {

	@Autowired
	WatchListRepository wlRepo;

	//method for adding anime to watchlist
	public WatchList RegisterWatchList(WatchList watchlist) {
		return wlRepo.save(watchlist);
	}

//	method for deleting anime data from the watchlist using watchId
	public void DeleteWatchList(int watchId) {
		wlRepo.DeleteWatchList(watchId);
	}

//	getting list of objects in the watclist table using userId
	public List<WatchList> GetWatchListByUserId(int userId) {
		if (wlRepo.GetWatchListByUserId(userId) == null) {
			return null;
		}
		return wlRepo.GetWatchListByUserId(userId);
	}

}
