
use tiendabd

DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes(
    IdCliente INT(6) UNSIGNED ZEROFILL AUTO_INCREMENT PRIMARY KEY NOT NULL,
    InicialesCliente CHAR(2) NOT NULL DEFAULT 'CC',
    NombresCliente VARCHAR(20) NOT NULL,
    ApellidosCliente VARCHAR(20) NOT NULL,
    DniCliente CHAR(8) NOT NULL,
    RucCliente CHAR(11) NOT NULL,
    EmailCliente VARCHAR(40) NOT NULL,
    DireccionCliente VARCHAR(100) NOT NULL,
    TelefonoCliente VARCHAR(15) NOT NULL
);

INSERT INTO CLIENTES (NombresCliente, ApellidosCliente, DniCliente, RucCliente, EmailCliente, DireccionCliente, TelefonoCliente) VALUES 
('Gary Alberto', 'Candia Nina', 48060302, 10104717328, 'gr.candia93@gmail.com', '-' , '951016360'),
('Juan', 'Vargas Machuca', 12345678, 11154337344, '-', 'Calla Las Fresas S.J.M.' , '-'),
('Julio', 'Rosas Rosas', 48060302, 10114347658, 'gr.candia93@gmail.com', '-' , '999999999'),
('Maria', 'Rosas Rosas', 48060302, 11104437358, 'gr.candia93@gmail.com', '-' , '888888888');

-- Listar clientes
DROP PROCEDURE IF EXISTS ListarClientes;
DELIMITER @@
CREATE PROCEDURE ListarClientes(Texto VARCHAR(15))
BEGIN
    SELECT CONCAT(InicialesCliente,IdCliente), NombresCliente, ApellidosCliente, DniCliente, RucCliente, EmailCliente, DireccionCliente, TelefonoCliente 
        FROM clientes WHERE IdCliente LIKE CONCAT('%',Texto,'%') 
        OR InicialesCliente LIKE CONCAT('%',Texto,'%') 
        OR NombresCliente LIKE CONCAT('%',Texto,'%') 
        OR ApellidosCliente LIKE CONCAT('%',Texto,'%')
        OR DniCliente LIKE CONCAT('%',Texto,'%')
        OR RucCliente LIKE CONCAT('%',Texto,'%')
        OR EmailCliente LIKE CONCAT('%',Texto,'%')
        OR DireccionCliente LIKE CONCAT('%',Texto,'%')
        OR TelefonoCliente LIKE CONCAT('%',Texto,'%');
END
@@ DELIMITER ;

-- Agregar cliente
DROP PROCEDURE IF EXISTS AgregarCliente;
DELIMITER @@
CREATE PROCEDURE AgregarCliente(Nom VARCHAR(20), Ape VARCHAR(20), Dni CHAR(8), Ruc CHAR(8), Ema VARCHAR(40), Dir VARCHAR(100), Tel VARCHAR(15))
BEGIN
    INSERT INTO clientes (NombresCliente, ApellidosCliente, DniCliente, RucCliente, EmailCliente, DireccionCliente, TelefonoCliente)
    VALUES (Nom, Ape, Dni, Ruc, Ema, Dir, Tel);
END
@@ DELIMITER ;

-- Modificar cliente
DROP PROCEDURE IF EXISTS ModificarCliente;
DELIMITER @@
CREATE PROCEDURE ModificarCliente(Idc INT(6), Nom VARCHAR(20), Ape VARCHAR(20), Dni CHAR(8), Ruc CHAR(8), Ema VARCHAR(40), Dir VARCHAR(100), Tel VARCHAR(15))
BEGIN
    UPDATE clientes SET NombresCliente = Nom, ApellidosCliente = Ape, DniCliente = Dni, RucCliente = Ruc, EmailCliente = Ema, DireccionCliente = Dir, TelefonoCliente = Tel 
    WHERE IdCliente = Idc;
END
@@ DELIMITER ;

-- Eliminar cliente
DROP PROCEDURE IF EXISTS EliminarCliente;
DELIMITER @@
CREATE PROCEDURE EliminarCliente(Idc INT(6))
BEGIN
    DELETE FROM clientes WHERE IdCliente = Idc;
END
@@ DELIMITER ;

-- Obtener cliente
DROP PROCEDURE IF EXISTS ObtenerCliente;
DELIMITER @@
CREATE PROCEDURE ObtenerCliente(Idc INT(6))
BEGIN
    SELECT CONCAT(InicialesCliente,IdCliente), NombresCliente, ApellidosCliente, DniCliente, RucCliente, EmailCliente, DireccionCliente, TelefonoCliente 
    FROM clientes WHERE IdCliente = Idc;
END
@@ DELIMITER ;