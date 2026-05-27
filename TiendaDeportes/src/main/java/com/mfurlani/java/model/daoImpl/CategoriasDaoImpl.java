package com.mfurlani.java.model.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfurlani.java.model.dao.CategoriasDao;
import com.mfurlani.java.model.entity.Categorias;

public class CategoriasDaoImpl implements CategoriasDao {
	private static final Logger logger = LoggerFactory.getLogger(CategoriasDao.class);
	
	private static final String CREATE = "INSERT INTO categorias "+"(nombre,descripcion,estado) "+" VALUES(?,?,?)";
	@Override
	public Categorias findByCateogira(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
