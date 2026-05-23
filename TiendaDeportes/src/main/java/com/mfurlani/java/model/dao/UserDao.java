package com.mfurlani.java.model.dao;

import com.mfurlani.java.exceptions.UserNotFoundException;
import com.mfurlani.java.model.entity.User;

public interface UserDao {
boolean create (User usuario);
	User findByUsername(String username) throws UserNotFoundException;
	
	
}
