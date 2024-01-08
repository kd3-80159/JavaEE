package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Reviews;

public interface ReviewsDao extends  AutoCloseable {
	public List<Reviews> findAll() throws Exception;
	public int deleteById(int reviewId)throws Exception;
	public Reviews findById(int id) throws Exception;
	public int update(Reviews r) throws Exception;
}
