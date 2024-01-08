package com.sunbeam.pojos;

import java.util.Date;

public class Reviews {
	private  int id ;
	private  int movieId;
	private String  review;
	private  int rating ;
	private int userId;
	private Date modified;
	public Reviews() {

	}
	public Reviews(int id, int movieId,int userId, String review, int rating,  Date modified) {
	
		this.id = id;
		this.movieId =movieId;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.modified = modified;
	}
	public Reviews(int id, int movieId, String review, int rating) {
	
		this.id = id;
		this.movieId = movieId;
		this.review = review;
		this.rating = rating;


	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", movieId=" + movieId + ", review=" + review + ", rating=" + rating + ", userId="
				+ userId + ", modified=" + modified + "]";
	}
	
}	
	
	

