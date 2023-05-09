package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Anime {
	
	@Id
	private int animeId;
	private String animeTitle;
	private String animeDesc;
	private String animeImage;
	private String animeSection;
	private String Genre;
	

	@JsonIgnore
	@OneToMany(mappedBy="anime")
	List<Episode> eplist=new ArrayList<Episode>();
	
	
	public Anime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Anime(int animeId, String animeTitle, String animeDesc, String animeImage, String animeSection,
			String genre) {
		super();
		this.animeId = animeId;
		this.animeTitle = animeTitle;
		this.animeDesc = animeDesc;
		this.animeImage = animeImage;
		this.animeSection = animeSection;
		Genre = genre;
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
		return "Anime [animeId=" + animeId + ", animeTitle=" + animeTitle + ", animeDesc=" + animeDesc + ", animeImage="
				+ animeImage + ", animeSection=" + animeSection + ", Genre=" + Genre + "]";
	}
	

}
