package com.dto;

/*import javax.persistence.Column;
*/
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
	/*@Column(name="anime")*/
	Anime anime;
	
	private int episodeNo;
	private String episodeLink;
	private String type;
	public Episode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Episode(int episodeId, Anime anime, int episodeNo, String episodeLink, String type) {
		super();
		this.episodeId = episodeId;
		this.anime = anime;
		this.episodeNo = episodeNo;
		this.episodeLink = episodeLink;
		this.type = type;
	}
	public int getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Episode [episodeId=" + episodeId + ", anime=" + anime + ", episodeNo=" + episodeNo + ", episodeLink="
				+ episodeLink + ", type=" + type + "]";
	}
	
	
	
	

}
