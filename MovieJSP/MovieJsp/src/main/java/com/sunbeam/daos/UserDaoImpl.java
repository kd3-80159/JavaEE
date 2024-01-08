package com.sunbeam.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojos.User;

public class UserDaoImpl extends Dao implements UserDao{
	public UserDaoImpl () throws Exception {
	}
	public int save(User u) throws Exception {
		String sql = "INSERT INTO users(id, first_name, last_name, email, mobile, birth, password) VALUES(default, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getMobile());
	 		java.util.Date uDate = u.getBirth();
	 		java.sql.Date  sqlDate = new java.sql.Date(uDate.getTime());
			stmt.setDate(5, sqlDate);
			stmt.setString(6, u.getPassword());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
	
//	public int update(User u) throws Exception {
//		String sql = "UPDATE users SET first_name=?, last_name=?, mobile=?, birth=? WHERE id=?";
//		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setString(1, u.getFirst_name());
//			stmt.setString(2, u.getLast_name());
//			stmt.setString(3, u.getEmail());
//			stmt.setDate(4, DateTimeUtil.utilDateToSqlDate(u.getBirth()));
//			stmt.setInt(5, u.getId());
//			int count = stmt.executeUpdate();
//			return count;
//		} //stmt.close();
//	}

	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql = "UPDATE users SET password=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}

	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					 email = rs.getString("email");
					String mobile = rs.getString("mobile");
					
					java.sql.Date sqlDate =rs.getDate("birth");
					
					 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
					//Date uDate = DateTimeUtil.sqlDateToUtilDate(rs.getDate("birth"));
					return new User(id, fname, lname, email, mobile, utilDate, password);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

//	public List<User> findAll() throws Exception {
//		List<User> list = new ArrayList<User>();
//		String sql = "SELECT * FROM users";
//		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			try(ResultSet rs = stmt.executeQuery()) {
//				while(rs.next()) {
//					int id = rs.getInt("id");
//					String fname = rs.getString("first_name");
//					String lname = rs.getString("last_name");
//					String password = rs.getString("password");
//					String email = rs.getString("email");
//					String mobile = rs.getString("mobile");
//					Date uDate = DateTimeUtil.sqlDateToUtilDate(rs.getDate("birth"));
//					User u = new User(id, fname, lname, email, password, uDate, mobile);
//					list.add(u);
//				}
//			} // rs.close();
//		} // stmt.close();
//		return list;
//	}
}
