package com.mfurlani.java.model.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfurlani.java.exceptions.UserNotFoundException;
import com.mfurlani.java.model.dao.UserDao;
import com.mfurlani.java.model.entity.User;


public class UserDaoImpl implements UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private static final String CREATE = "INSERT INTO usuarios " +
            "(username, nombre, apellido, email, telefono, password_hash, rol, activo, fecha_creacion, fecha_actualizacion) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
	
	private static final String FIND_BY_ID = "SELECT username, password FROM usuarios WHERE username = ?";
	
	@Override
	public boolean create(User usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
