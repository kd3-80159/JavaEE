package com.sunbeam.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String birth;
	private boolean status;
	public RegistrationBean() {

	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void saveUser() {
		try(UserDao userDao = new UserDaoImpl()){
			int cnt;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date utilDate = sdf.parse(birth);
			User u = new User(firstName, lastName, email, password,utilDate,mobile);
			cnt = userDao.save(u);
			if(cnt==1) {
				status=true;
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "RegistrationBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", birth=" + birth + "]";
	}

}
