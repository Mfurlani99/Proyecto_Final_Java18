package com.mfurlani.java.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Productos {

    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    private int stockMinimo;
    private String sku;
    private int categoriaId;
    private String proveedor;
    private String imagenUrl;
    private boolean estado;

    // MySQL las genera automáticamente
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    
    
    public Productos(int id, String nombre, String descripcion, BigDecimal precio, int stock, int stockMinimo,
			String sku, int categoriaId, String proveedor, String imagenUrl, boolean estado,
			LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
		this.sku = sku;
		this.categoriaId = categoriaId;
		this.proveedor = proveedor;
		this.imagenUrl = imagenUrl;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}
	// Getters y Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaCreacion(LocalDateTime fechaCreacion) { 
        return this.fechaCreacion = fechaCreacion; 
    }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { 
        this.fechaActualizacion = fechaActualizacion; 
    }
}