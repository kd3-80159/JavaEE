package com.sunbeam.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.daos.Dao;
import com.sunbeam.daos.MovieDao;
import com.sunbeam.pojos.Movie;
public class MovieDaoImpl extends Dao implements MovieDao{
	public MovieDaoImpl () throws Exception {
	}
	public List<Movie> findAll() throws Exception {
		List<Movie> list = new ArrayList<>();
		String sql = "SELECT * FROM movies";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("movie_id");
					String title = rs.getString("title");
					java.sql.Date sqlDate =rs.getDate("release_date");
					 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
					 Movie m = new Movie(id, title, utilDate);
					list.add(m);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
//	system.out.println("*****************************************************");
	
	public Movie findById(int id) throws Exception {
		String sql = "SELECT * FROM movies WHERE movie_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					id = rs.getInt("movie_id");
					String title = rs.getString("title");
					java.sql.Date sqlDate =rs.getDate("release_date");
					 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
					Movie m = new Movie(id, title, utilDate);
					return m;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
}
