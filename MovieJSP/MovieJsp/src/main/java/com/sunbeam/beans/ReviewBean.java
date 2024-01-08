package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.ReviewImpl;
import com.sunbeam.daos.ReviewsDao;
import com.sunbeam.pojos.Reviews;

public class ReviewBean {
private List<Reviews> review;

public ReviewBean() {

}

public ReviewBean(List<Reviews> review) {
	
	this.review = new ArrayList<Reviews>();
}

public List<Reviews> getReview() {
	return review;
}

public void setReview(List<Reviews> review) {
	this.review = review;
}

public void fetchReview() {
	try(ReviewsDao reviewDao=new ReviewImpl()){		
		review = reviewDao.findAll();
	}catch(Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}

}
