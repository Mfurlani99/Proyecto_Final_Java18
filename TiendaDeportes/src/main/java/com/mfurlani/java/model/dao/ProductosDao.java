package com.mfurlani.java.model.dao;

import com.mfurlani.java.model.entity.Productos;

public interface ProductosDao {

	Productos findByproducto(String producto);
	Productos findByid(int idp);
	
}
