package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.ReviewImpl;
import com.sunbeam.daos.ReviewsDao;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Reviews;

public class FindReview {
private int id;
private Reviews review ;
private List<Movie> movieList;
public FindReview() {
	this.movieList = new ArrayList<Movie>();
	
}
public FindReview(int id, Reviews review) {

	this.id = id;
	this.review = review;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Reviews getReview() {
	return review;
}
public void setReview(Reviews review) {
	this.review = review;
}

public void fetchMovie() {
	try(MovieDao movieDao = new MovieDaoImpl()) {
		this.movieList = movieDao.findAll();
	}
	catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}	
}
public void fetchReview() {
	try(ReviewsDao reviewDao = new ReviewImpl()) {
		this.review = reviewDao.findById(id);
	}
	catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	
}

}
