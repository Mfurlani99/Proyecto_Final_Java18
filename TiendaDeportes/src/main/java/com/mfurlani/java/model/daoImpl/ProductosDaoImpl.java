package com.mfurlani.java.model.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mfurlani.java.model.dao.ProductosDao;
import com.mfurlani.java.model.entity.Productos;

public class ProductosDaoImpl implements ProductosDao{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductosDao.class);
	
	private static String CREATE = "INSERT INTO productos " +
            "(nombre, descripcion, precio, stock, stock_minimo, sku, categoria_id, proveedor, imagen_url, estado) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public Productos findByproducto(String producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productos findByid(int idp) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
