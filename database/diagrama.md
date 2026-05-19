# Diagrama de la Base de Datos - MiTienda

```mermaid
erDiagram
    usuarios {
        int id PK
        varchar nombre
        varchar apellido
        varchar email UK
        varchar telefono
        varchar password_hash
        enum rol
        tinyint activo
        timestamp fecha_creacion
        timestamp fecha_actualizacion
    }

    categorias {
        int id PK
        varchar nombre UK
        text descripcion
        tinyint activo
    }

    productos {
        int id PK
        varchar nombre
        text descripcion
        decimal precio
        int stock
        int stock_minimo
        varchar sku UK
        int categoria_id FK
        varchar proveedor
        varchar imagen_url
        enum estado
        timestamp fecha_creacion
        timestamp fecha_actualizacion
    }

    carritos {
        int id PK
        int usuario_id FK
        timestamp fecha_creacion
        timestamp fecha_actualizacion
    }

    carrito_items {
        int id PK
        int carrito_id FK
        int producto_id FK
        int cantidad
    }

    ventas {
        int id PK
        varchar numero_venta UK
        int usuario_id FK
        decimal subtotal
        decimal descuento
        decimal envio
        decimal iva
        decimal total
        enum estado
        timestamp fecha_creacion
    }

    detalle_venta {
        int id PK
        int venta_id FK
        int producto_id FK
        int cantidad
        decimal precio_unitario
        decimal subtotal
    }

    usuarios ||--o{ carritos : "posee"
    usuarios ||--o{ ventas : "realiza"
    categorias ||--o{ productos : "clasifica"
    carritos ||--o{ carrito_items : "contiene"
    productos ||--o{ carrito_items : "incluido en"
    ventas ||--o{ detalle_venta : "desglosa"
    productos ||--o{ detalle_venta : "vendido en"
```
