-- ============================================================
-- MiTienda - Base de Datos
-- Sistema de gestión de tienda online
-- ============================================================

CREATE DATABASE IF NOT EXISTS mitienda_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE mitienda_db;

-- ============================================================
-- TABLA: usuarios
-- Almacena los usuarios del sistema (admin/vendedores)
-- ============================================================
CREATE TABLE usuarios (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  nombre          VARCHAR(100) NOT NULL,
  apellido        VARCHAR(100) NOT NULL,
  email           VARCHAR(150) NOT NULL UNIQUE,
  telefono        VARCHAR(20),
  password_hash   VARCHAR(255) NOT NULL,
  rol             ENUM('admin', 'vendedor') DEFAULT 'vendedor',
  activo          TINYINT(1) DEFAULT 1,
  fecha_creacion  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: categorias
-- Catálogo de categorías de productos
-- ============================================================
CREATE TABLE categorias (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  nombre          VARCHAR(100) NOT NULL UNIQUE,
  descripcion     TEXT,
  activo          TINYINT(1) DEFAULT 1
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: productos
-- Catálogo de productos de la tienda
-- ============================================================
CREATE TABLE productos (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  nombre          VARCHAR(200) NOT NULL,
  descripcion     TEXT,
  precio          DECIMAL(12, 2) NOT NULL,
  stock           INT NOT NULL DEFAULT 0,
  stock_minimo    INT DEFAULT 5,
  sku             VARCHAR(50) NOT NULL UNIQUE,
  categoria_id    INT,
  proveedor       VARCHAR(200),
  imagen_url      VARCHAR(500),
  estado          ENUM('activo', 'inactivo') DEFAULT 'activo',
  fecha_creacion  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: carritos
-- Carritos de compra por usuario
-- ============================================================
CREATE TABLE carritos (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id      INT NOT NULL,
  fecha_creacion  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: carrito_items
-- Productos agregados a cada carrito
-- ============================================================
CREATE TABLE carrito_items (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  carrito_id      INT NOT NULL,
  producto_id     INT NOT NULL,
  cantidad        INT NOT NULL DEFAULT 1,
  FOREIGN KEY (carrito_id) REFERENCES carritos(id) ON DELETE CASCADE,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: ventas
-- Cabecera de cada venta realizada
-- ============================================================
CREATE TABLE ventas (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  numero_venta    VARCHAR(20) NOT NULL UNIQUE,
  usuario_id      INT NOT NULL,
  subtotal        DECIMAL(12, 2) NOT NULL,
  descuento       DECIMAL(12, 2) DEFAULT 0,
  envio           DECIMAL(12, 2) DEFAULT 0,
  iva             DECIMAL(12, 2) NOT NULL,
  total           DECIMAL(12, 2) NOT NULL,
  estado          ENUM('pendiente', 'completada', 'cancelada') DEFAULT 'pendiente',
  fecha_creacion  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- TABLA: detalle_venta
-- Líneas de detalle de cada venta
-- ============================================================
CREATE TABLE detalle_venta (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  venta_id        INT NOT NULL,
  producto_id     INT NOT NULL,
  cantidad        INT NOT NULL,
  precio_unitario DECIMAL(12, 2) NOT NULL,
  subtotal        DECIMAL(12, 2) NOT NULL,
  FOREIGN KEY (venta_id) REFERENCES ventas(id) ON DELETE CASCADE,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- INSERTS DE EJEMPLO
-- ============================================================

-- Usuario administrador por defecto (password: admin123)
INSERT INTO usuarios (nombre, apellido, email, telefono, password_hash, rol)
VALUES ('Admin', 'MiTienda', 'admin@mitienda.cl', '+56 9 1234 5678',
        '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'admin');

-- Categorías de ejemplo
INSERT INTO categorias (nombre, descripcion) VALUES
  ('Electrónica', 'Productos electrónicos y tecnología'),
  ('Ropa', 'Prendas de vestir y accesorios'),
  ('Hogar', 'Artículos para el hogar'),
  ('Deportes', 'Equipamiento e indumentaria deportiva'),
  ('Juguetes', 'Juguetes y juegos');

-- Productos de ejemplo
INSERT INTO productos (nombre, descripcion, precio, stock, stock_minimo, sku, categoria_id, proveedor, estado) VALUES
  ('Laptop Pro 15"', 'Laptop de última generación con 16GB RAM', 899990, 15, 5, 'SKU-001', 1, 'TechWorld', 'activo'),
  ('Smartphone X200', 'Pantalla AMOLED 6.7" 128GB', 549990, 42, 10, 'SKU-002', 1, 'MobileCorp', 'activo'),
  ('Auriculares Bluetooth', 'Cancelación de ruido activa', 89990, 78, 15, 'SKU-003', 1, 'SoundPro', 'activo'),
  ('Polera Algodón Premium', 'Algodón orgánico, varios colores', 24990, 0, 10, 'SKU-004', 2, 'TextilChile', 'inactivo'),
  ('Reloj de Pared Moderno', 'Diseño minimalista, silencioso', 34990, 23, 5, 'SKU-005', 3, 'HogarDecor', 'activo'),
  ('Balón de Fútbol Profesional', 'Tamaño oficial, cuero sintético', 45990, 12, 5, 'SKU-006', 4, 'SportsClub', 'activo'),
  ('Cámara Digital 4K', 'Grabación 4K, 20MP, estabilizador', 299990, 8, 5, 'SKU-007', 1, 'TechWorld', 'activo');
