package com.mfurlani.java.model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfurlani.java.exceptions.UserNotFoundException;
import com.mfurlani.java.model.dao.UserDao;
import com.mfurlani.java.model.entity.User;
import com.mfurlani.java.model.jdbc.DBConnection;


public class UserDaoImpl implements UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private static final String CREATE = "INSERT INTO usuarios " +
            "(username, nombre, apellido, email, telefono, password_hash, rol, activo, fecha_creacion, fecha_actualizacion) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
	
	private static final String FIND_BY_ID = "SELECT username, password FROM usuarios WHERE username = ?";
	
	@Override
	public boolean create(User usuario) {
		
		try (Connection connection = DBConnection.getInstance()){
			if(logger.isDebugEnabled()) {
				logger.debug("entre a la creacion de usuario nombre" + usuario.getNombre());	
			}
			PreparedStatement ps = connection.prepareStatement(CREATE);
			ps.setString(1, usuario.getUsername());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getEmail());
			ps.setString(5, usuario.getTelefono());
			ps.setString(6, usuario.getPassword());
			ps.setString(7, usuario.getRol().name());
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			logger.error("no se creo el usuario",e);
		}
		
		
		return false;
	}

	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
