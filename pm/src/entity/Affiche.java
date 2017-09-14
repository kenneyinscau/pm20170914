package entity;

import java.sql.Timestamp;

/**
 * Affiche entity. @author MyEclipse Persistence Tools
 */

public class Affiche implements java.io.Serializable {

	// Fields

	private Integer aid;
	private User user;
	private String title;
	private String content;
	private Timestamp publishtime;

	// Constructors

	/** default constructor */
	public Affiche() {
	}

	/** full constructor */
	public Affiche(User user, String title, String content,
			Timestamp publishtime) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.publishtime = publishtime;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(Timestamp publishtime) {
		this.publishtime = publishtime;
	}

}