package com.sunbeam.beans;

import com.sunbeam.daos.ReviewImpl;
import com.sunbeam.daos.ReviewsDao;
import com.sunbeam.pojos.Reviews;

public class UpdateReviewBean {
private int rating;
private int id;
private int movieId;
private String review;
private String message;

public UpdateReviewBean() {

}

public UpdateReviewBean(int rating, int id, int movieId, String review, String message) {
	super();
	this.rating = rating;
	this.id = id;
	this.movieId = movieId;
	this.review = review;
	this.message = message;
}



public int getRating() {
	return rating;
}



public void setRating(int rating) {
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
	review = review;
}



public String getMessage() {
	return message;
}



public void setMessage(String message) {
	this.message = message;
}



@Override
public String toString() {
	return "UpdateReview [rating=" + rating + ", id=" + id + ", movieId=" + movieId + ", Review=" + review
			+ ", message=" + message + "]";
}



public void  updateReview() {
	try(ReviewsDao reviewDao= new ReviewImpl()){
		int count;
		Reviews r = new Reviews( id,  movieId, review,  rating);
		count=reviewDao.update(r);
		this.message="Candidates Updated: " + count;
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
