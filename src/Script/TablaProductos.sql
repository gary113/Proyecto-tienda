
use tiendabd

DROP TABLE IF EXISTS productos;
CREATE TABLE productos(
    IdProducto INT(6) UNSIGNED ZEROFILL AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    InicialesProducto CHAR(2) NOT NULL DEFAULT 'CP',
    DescripcionProducto VARCHAR(40) NOT NULL,
    StockProducto SMALLINT UNSIGNED NOT NULL,
    PrecioProducto DOUBLE UNSIGNED NOT NULL
);

INSERT INTO productos (DescripcionProducto, StockProducto, PrecioProducto) VALUES 
('Leche Gloria', 5, 3),
('Arroz Costeño', 10, 3.5),
('Aceite Primor', 9, 6),
('Papel Suave', 3, 2.5),
('Shampú Head&Shoulders', 2, 4);


-- Listar productos
DROP PROCEDURE IF EXISTS ListarProductos;
DELIMITER @@
CREATE PROCEDURE ListarProductos(Texto VARCHAR(15))
BEGIN
    SELECT CONCAT(InicialesProducto,IdProducto), DescripcionProducto, StockProducto, PrecioProducto 
        FROM productos WHERE IdProducto LIKE CONCAT('%',Texto,'%') 
        OR InicialesProducto LIKE CONCAT('%',Texto,'%') 
        OR DescripcionProducto LIKE CONCAT('%',Texto,'%') 
        OR StockProducto LIKE CONCAT('%',Texto,'%')
        OR PrecioProducto LIKE CONCAT('%',Texto,'%');
END
@@ DELIMITER ;

-- Agregar producto
DROP PROCEDURE IF EXISTS AgregarProducto;
DELIMITER @@
CREATE PROCEDURE AgregarProducto(Des VARCHAR(40), Sto SMALLINT, Pre DOUBLE)
BEGIN
    INSERT INTO productos (DescripcionProducto, StockProducto, PrecioProducto) VALUES (Des, Sto, Pre);
END
@@ DELIMITER ;

-- Modificar producto
DROP PROCEDURE IF EXISTS ModificarProducto;
DELIMITER @@
CREATE PROCEDURE ModificarProducto(Idp INT, Des VARCHAR(40), Sto SMALLINT, Pre DOUBLE)
BEGIN
    UPDATE productos SET DescripcionProducto = Des, StockProducto = Sto, PrecioProducto = Pre WHERE IdProducto = Idp;
END
@@ DELIMITER ;

-- Eliminar producto
DROP PROCEDURE IF EXISTS EliminarProducto;
DELIMITER @@
CREATE PROCEDURE EliminarProducto(Idp INT)
BEGIN
    DELETE FROM productos WHERE IdProducto = Idp;
END
@@ DELIMITER ;

-- Obtener producto
DROP PROCEDURE IF EXISTS ObtenerProducto;
DELIMITER @@
CREATE PROCEDURE ObtenerProducto(Idp INT)
BEGIN
    SELECT CONCAT(InicialesProducto,IdProducto), DescripcionProducto, StockProducto, PrecioProducto 
    FROM productos WHERE IdProducto = Idp;
END
@@ DELIMITER ;