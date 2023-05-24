package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Anime;

@Service
public class AnimeDAO {

	@Autowired
	AnimeRepository Animerepo;

//	getting anime by anime section
	public List<Anime> GetAnimeBySection(String animeSection) {
		if (Animerepo.GetAnimeBySection(animeSection) == null) {
			return null;
		}
		return Animerepo.GetAnimeBySection(animeSection);
	}

//	registering anime
	public Anime RegisterAnime(Anime anime) {
		return Animerepo.save(anime);
	}

//	getting anime by title
	public Anime GetAnimeByTitle(String animeTitle) {
		Anime anime = Animerepo.GetAnimeByTitle(animeTitle);
		if (anime != null) {
			return anime;
		}
		return new Anime(0, "Title Not Found!!", "Description Not Found!!", "Image Not Found!!", "Section Not Found",
				"Genre Not Found!!");
	}
	
//  getting anime by animeid
	public Anime GetAnimeById(int animeId) {
		return Animerepo.findById(animeId).orElse(new Anime(0, "Title Not Found!!", "Description Not Found!!",
				"Image Not Found", "Section Not Found!!", "Genre Not Found"));
	}

//	deleting the anime by animeId
	public void DeleteAnime(int animeId) {
		Animerepo.deleteById(animeId);

	}

//	getting a list of anime
	public List<Anime> GetAllAnime() {
		return Animerepo.findAll();
	}

//	getting a list of anime by specific genre
	public List<Anime> GetAnimeByGenre(String Genre) {
		if (Animerepo.GetAnimeByGenre(Genre) == null) {
			return null;
		}
		return Animerepo.GetAnimeByGenre(Genre);

	}

}
