package com.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episode {
	
	@Id
	private int episodeId;
	
	@ManyToOne
	@JoinColumn(name="animeId")
	Anime anime;
	
	private int episodeNo;
	private String episodeLink;
	public Episode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Episode(Anime anime, int episodeNo, String episodeLink) {
		super();
		this.anime = anime;
		this.episodeNo = episodeNo;
		this.episodeLink = episodeLink;
	}
	public Anime getAnime() {
		return anime;
	}
	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	public int getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}
	public String getEpisodeLink() {
		return episodeLink;
	}
	public void setEpisodeLink(String episodeLink) {
		this.episodeLink = episodeLink;
	}
	@Override
	public String toString() {
		return "Episode [anime=" + anime + ", episodeNo=" + episodeNo + ", episodeLink=" + episodeLink + "]";
	}
	
	

}
