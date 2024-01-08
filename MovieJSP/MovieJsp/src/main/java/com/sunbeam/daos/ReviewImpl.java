package com.sunbeam.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Reviews;

public class ReviewImpl extends Dao implements ReviewsDao{
	public ReviewImpl () throws Exception {
	}
//	public int save(Reviews r) throws Exception {
//		String sql = "INSERT INTO reviews(id, movie_id, review, rating, user_id, modified) VALUES(default, ?, ?, ?, ?, ?)";
//		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, r.getMovieId());
//			stmt.setString(2, r.getReview());
//			stmt.setInt(3, r.getRating());
//			stmt.setInt(4, r.getUserId());
//			stmt.setTimestamp(5, DateTimeUtil.utilDateToSqlTs(r.getModified()));
//			int count = stmt.executeUpdate();
//			return count;
//		} //stmt.close();		
//	}
	
	public int update(Reviews r) throws Exception {
		String sql = "UPDATE reviews SET  review=?, rating=? WHERE  movie=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, r.getReview());
			stmt.setInt(2, r.getRating());
			stmt.setInt(3, r.getMovieId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();		
	}
	public List<Reviews> findAll() throws Exception {
		List<Reviews> list = new ArrayList<Reviews>();
		String sql = "SELECT * FROM reviews ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int userId = rs.getInt("user_id");
					java.sql.Date sqlDate =rs.getDate("modified");
					java.util.Date utilDate = new java.util.Date(sqlDate.getTime());				
					Reviews r = new Reviews(id, movieId, userId, review, rating, utilDate);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
//	public List<Review> findByUserId(int userId) throws Exception {
//		List<Review> list = new ArrayList<Review>();
//		String sql = "SELECT * FROM reviews WHERE user_id=? ORDER BY modified DESC";
//		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, userId);
//			try(ResultSet rs = stmt.executeQuery()) {
//				while(rs.next()) {
//					int id = rs.getInt("id");
//					int movieId = rs.getInt("movie_id");
//					String review = rs.getString("review");
//					int rating = rs.getInt("rating");
//					int usrId = rs.getInt("user_id");
//					Date modified = DateTimeUtil.sqlTsToUtilDate(rs.getTimestamp("modified"));
//					Review r = new Review(id, movieId, usrId, review, rating, modified);
//					list.add(r);
//				}
//			} // rs.close();
//		} // stmt.close();
//		return list;
//	}
//	public List<Review> getSharedWithUser(int userId) throws Exception {
//		List<Review> list = new ArrayList<Review>();
//		String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
//		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, userId);
//			try(ResultSet rs = stmt.executeQuery()) {
//				while(rs.next()) {
//					int id = rs.getInt("id");
//					int movieId = rs.getInt("movie_id");
//					String review = rs.getString("review");
//					int rating = rs.getInt("rating");
//					int usrId = rs.getInt("user_id");
//					Date modified = DateTimeUtil.sqlTsToUtilDate(rs.getTimestamp("modified"));
//					Review r = new Review(id, movieId, usrId, review, rating, modified);
//					list.add(r);
//				}
//			} // rs.close();
//		} // stmt.close();
//		return list;
//	}
	public Reviews findById(int id) throws Exception {
		String sql = "SELECT * FROM reviews WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					//Date modified = DateTimeUtil.sqlTsToUtilDate(rs.getTimestamp("modified"));
					java.sql.Date sqlDate =rs.getDate("modified");
					java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
					Reviews r = new Reviews(id, movieId, usrId, review, rating, utilDate);
					return r;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}
//	public int shareReview(int reviewId, int userId) throws Exception {
//		String sql = "INSERT INTO shares(review_id, user_id) VALUES (?, ?)";
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, reviewId);
//			stmt.setInt(2, userId);
//			int count = stmt.executeUpdate();
//			return count;
//		}
//		catch (SQLIntegrityConstraintViolationException e) {
//			// do nothing
//		}
//		return 0;
//	}
	
}
