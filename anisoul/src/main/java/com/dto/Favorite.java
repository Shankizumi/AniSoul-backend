package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorite {

	@Id
	@GeneratedValue
	private int favoriteId;
	private int userId;
	private int animeId;
	private String animeTitle;
	private String animeDesc;
	private String animeImage;
	private String animeSection;
	private String Genre;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int favoriteId, int userId, int animeId, String animeTitle, String animeDesc, String animeImage,
			String animeSection, String genre) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.animeId = animeId;
		this.animeTitle = animeTitle;
		this.animeDesc = animeDesc;
		this.animeImage = animeImage;
		this.animeSection = animeSection;
		Genre = genre;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAnimeId() {
		return animeId;
	}

	public void setAnimeId(int animeId) {
		this.animeId = animeId;
	}

	public String getAnimeTitle() {
		return animeTitle;
	}

	public void setAnimeTitle(String animeTitle) {
		this.animeTitle = animeTitle;
	}

	public String getAnimeDesc() {
		return animeDesc;
	}

	public void setAnimeDesc(String animeDesc) {
		this.animeDesc = animeDesc;
	}

	public String getAnimeImage() {
		return animeImage;
	}

	public void setAnimeImage(String animeImage) {
		this.animeImage = animeImage;
	}

	public String getAnimeSection() {
		return animeSection;
	}

	public void setAnimeSection(String animeSection) {
		this.animeSection = animeSection;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", userId=" + userId + ", animeId=" + animeId + ", animeTitle="
				+ animeTitle + ", animeDesc=" + animeDesc + ", animeImage=" + animeImage + ", animeSection="
				+ animeSection + ", Genre=" + Genre + "]";
	}

}
