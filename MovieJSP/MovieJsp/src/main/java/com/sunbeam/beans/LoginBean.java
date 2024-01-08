package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
private String email;
private String password;
//private boolean status;
private User user;
public LoginBean() {
	super();
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
//public boolean getStatus() {
//	return status;
//}
//public void setStatus(boolean status) {
//	this.status = status;
//}
//@Override

//public void authenticate() {
//	try(UserDao userDao = new UserDaoImpl()) {
//		User user = userDao.findByEmail(email);
//		if(user != null && user.getPassword().equals(password))
//			status = true;
//	}
//	catch(Exception ex) {
//		ex.printStackTrace();
//	}
//}
//}

//public void authenticate() {
//try(UserDao userDao = new UserDaoImpl()){
//	User u = userDao.findByEmail(email);
//	if(u!=null && u.getPassword().equals(password)) {
//		this.user=u;
//	}
//}catch(Exception e) {
//	e.printStackTrace();
//}
//}
public void authenticate() {
	try(UserDao userDao = new UserDaoImpl()) {
		User u = userDao.findByEmail(email);
		if(u != null && u.getPassword().equals(password))
			this.user = u;
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}
@Override
public String toString() {
	return "LoginBean [email=" + email + ", password=" + password + ", user=" + user + "]";
}
}
