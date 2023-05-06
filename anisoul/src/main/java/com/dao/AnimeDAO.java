package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Anime;

@Service
public class AnimeDAO {
	
	@Autowired
	AnimeRepository Animerepo;

	public List<Anime> GetAnimeBySection(String animeSection) {		
		if(Animerepo.GetAnimeBySection(animeSection)==null){
			return null;
		}
			return Animerepo.GetAnimeBySection(animeSection);
		}
		

	public Anime RegisterAnime(Anime anime) {
		// TODO Auto-generated method stub
		return Animerepo.save(anime);
	}

	public Anime GetAnimeByTitle(String animeTitle) {
		// TODO Auto-generated method stub
		Anime anime = Animerepo.GetAnimeByTitle(animeTitle);
		if(anime!=null){
			return anime;
		}
		return new Anime(0,"Title Not Found!!","Description Not Found!!","Image Not Found!!","Section Not Found","Genre Not Found!!");
	}

	public Anime GetAnimeById(int animeId) {
		// TODO Auto-generated method stub
		return Animerepo.findById(animeId).orElse(new Anime(0,"Title Not Found!!","Description Not Found!!","Image Not Found","Section Not Found!!","Genre Not Found"));
	}


	public void DeleteAnime(int animeId) {
		// TODO Auto-generated method stub
		Animerepo.deleteById(animeId);
		
	}


	public List<Anime> GetAllAnime() {
		// TODO Auto-generated method stub
		return Animerepo.findAll();
	}

}
