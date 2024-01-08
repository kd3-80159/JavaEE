package com.sunbeam.pojos;

import java.util.Date;

public class Movie {

	private int id;
	private String  title;
	private Date  rel_date;
	public Movie(int id, String title,  Date rel_date) {
		super();
		this.id = id;
		this.title = title;
		this.rel_date = rel_date;
	}
	public int getMovie_id() {
		return id;
	}
	public void setMovie_id(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public  Date getRelease_date() {
		return rel_date;
	}
	public void setRelease_date( Date release_date) {
		this.rel_date = release_date;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + id + ", title=" + title + ", release_date=" + rel_date + "]";
	}
	
	//hash&equal remain
	
	
}
