-- 1. Insertar un nuevo cliente con todos sus datos y representante de ventas
DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_cliente$$
CREATE PROCEDURE insertar_cliente(
	IN codCliente INT,
	IN nombreCliente VARCHAR(50),
	IN nombreContacto VARCHAR(30),
	IN apellidoContacto VARCHAR(30),
	IN telefono VARCHAR(15),
	IN fax VARCHAR(15),
	IN direccion1 VARCHAR(50),
	IN direccion2 VARCHAR(50),
	IN ciudad VARCHAR(50),
	IN region VARCHAR(50),
	IN pais VARCHAR(50),
	IN codigoPostal VARCHAR(10),
	IN codEmpleadoRepVentas INT,
	IN limiteCredito DECIMAL(15,2)
)
BEGIN
	INSERT INTO cliente VALUES (
		codCliente, nombreCliente, nombreContacto, apellidoContacto,
		telefono, fax, direccion1, direccion2, ciudad,
		region, pais, codigoPostal, codEmpleadoRepVentas, limiteCredito
	);
END$$
DELIMITER ;
CALL insertar_cliente(3002, 'Floristería El Paraíso', 'Luis', 'Martínez', '111222333', '444555666', 'Calle Jardín 12', NULL, 'Granada', NULL, 'España', '18001', 25, 20000.00);
SELECT * FROM cliente WHERE codigo_cliente=3002;
-- 2 Registrar un nuevo pedido, incluyendo código de cliente, fechas y estado
DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_pedido$$
CREATE PROCEDURE registrar_pedido(
	IN codPedido INT,
	IN fechaPedido DATE,
	IN fechaEsperada DATE,
	IN fechaEntrega DATE,
	IN estado VARCHAR(15),
	IN comentarios TEXT,
	IN codCliente INT
)
BEGIN
	INSERT INTO pedido VALUES (
		codPedido, fechaPedido, fechaEsperada, fechaEntrega,
		estado, comentarios, codCliente
	);
END$$
DELIMITER ;
CALL registrar_pedido(5000, '2025-06-07', '2025-06-15', NULL, 'Pendiente', 'Entrega urgente', 10);
SELECT * FROM pedido WHERE codigo_pedido=5000;
-- 3 Registrar una línea de detalle de pedido (producto, cantidad, precio, número de línea).
DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_detalle_pedido$$
CREATE PROCEDURE registrar_detalle_pedido(
	IN codPedido INT,
	IN codProducto VARCHAR(15),
	IN cantidad INT,
	IN precio DECIMAL(15,2),
	IN numLinea SMALLINT
)
BEGIN
	INSERT INTO detalle_pedido VALUES (
		codPedido, codProducto, cantidad, precio, numLinea
	);
END$$
DELIMITER ;
CALL registrar_detalle_pedido(30, '30310', 20, 45.50, 1);
SELECT * FROM detalle_pedido WHERE  codigo_pedido=30;
-- 4  Actualizar el stock de un producto después de una venta
DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_stock_producto$$
CREATE PROCEDURE actualizar_stock_producto(
	IN codProducto VARCHAR(15),
	IN cantidadVendida INT
)
BEGIN
	UPDATE producto
	SET cantidad_en_stock = cantidad_en_stock - cantidadVendida
	WHERE codigo_producto = codProducto;
END$$
DELIMITER ;
CALL actualizar_stock_producto('11679', 20);
SELECT * FROM producto WHERE codigo_producto =11679;
-- 5 Obtener todos los pedidos realizados por un cliente determinado.
DELIMITER $$
DROP PROCEDURE IF EXISTS obtener_pedidos_cliente$$
CREATE PROCEDURE obtener_pedidos_cliente(
	IN codCliente INT
)
BEGIN
	SELECT * FROM pedido
	WHERE codigo_cliente = codCliente;
END$$
DELIMITER ;
CALL obtener_pedidos_cliente(1);
-- 6 Obtener el listado de empleados que trabajan en una oficina concreta.
DELIMITER $$
DROP PROCEDURE IF EXISTS empleados_por_oficina$$
CREATE PROCEDURE empleados_por_oficina(
	IN codOficina VARCHAR(10)
)
BEGIN
	SELECT * FROM empleado
	WHERE codigo_oficina = codOficina;
END$$
DELIMITER ;

CALL empleados_por_oficina('MAD-ES');
-- 7 Obtener todos los productos de una gama específica.
DELIMITER $$
DROP PROCEDURE IF EXISTS productos_por_gama$$
CREATE PROCEDURE productos_por_gama(
	IN gamaProd VARCHAR(50)
)
BEGIN
	SELECT * FROM producto
	WHERE gama = gamaProd;
END$$
DELIMITER ;

CALL productos_por_gama('Herramientas');
-- 8 Eliminar un cliente solo si no tiene pedidos ni pagos asociados.
DELIMITER $$
DROP PROCEDURE IF EXISTS eliminar_cliente_si_no_tiene_relaciones$$
CREATE PROCEDURE eliminar_cliente_si_no_tiene_relaciones(
	IN codCliente INT
)
BEGIN
	IF NOT EXISTS (SELECT 1 FROM pedido WHERE codigo_cliente = codCliente) AND
	   NOT EXISTS (SELECT 1 FROM pago WHERE codigo_cliente = codCliente) THEN  -- nos devolveria como un booleano, donde 0 es false y 1 es true, y se tienen que cumplir los dos
		DELETE FROM cliente WHERE codigo_cliente = codCliente;
	END IF;
END$$
DELIMITER ;

CALL eliminar_cliente_si_no_tiene_relaciones(6);
SELECT * FROM cliente;
-- 9  Calcular el total de pagos realizados por un cliente en un rango de fechas.
DELIMITER $$
DROP PROCEDURE IF EXISTS total_pagos_por_cliente_y_fecha$$
CREATE PROCEDURE total_pagos_por_cliente_y_fecha(
	IN codCliente INT,
	IN fechaInicio DATE,
	IN fechaFin DATE,
	OUT totalPagado DECIMAL(15,2)
)
BEGIN
	SELECT IFNULL(SUM(total), 0)
	INTO totalPagado
	FROM pago
	WHERE codigo_cliente = codCliente
	AND fecha_pago BETWEEN fechaInicio AND fechaFin; -- Se puede usar el between entre fechas así porque las fechas tienen un formato adaptado a mysql, o sino tendríamos que usar STR_TO_DATE(fechaIni, '%d/%m/%Y')
END$$
DELIMITER ;

CALL total_pagos_por_cliente_y_fecha(3, '2008-01-01', '2012-12-31', @total);
SELECT @total;
-- 10 Obtener los pedidos pendientes de entrega (estado diferente de 'Entregado')
DELIMITER $$
DROP PROCEDURE IF EXISTS pedidos_pendientes_entrega$$
CREATE PROCEDURE pedidos_pendientes_entrega()
BEGIN
	SELECT * FROM pedido
	WHERE estado <> 'Entregado';
END$$
DELIMITER ;

CALL pedidos_pendientes_entrega();
-- 11 Actualizar el estado de un pedido a 'Entregado' y registrar la fecha de entrega
DELIMITER $$
DROP PROCEDURE IF EXISTS entregar_pedido$$
CREATE PROCEDURE entregar_pedido(
	IN codPedido INT,
	IN fechaEntrega DATE
)
BEGIN
	UPDATE pedido
	SET estado = 'Entregado',
		fecha_entrega = fechaEntrega
	WHERE codigo_pedido = codPedido;
END$$
DELIMITER ;

CALL entregar_pedido(30, CURDATE()); -- Current date
-- 12 Contar cuántos productos hay por gama de producto
DELIMITER $$
DROP PROCEDURE IF EXISTS contar_productos_por_gama$$
CREATE PROCEDURE contar_productos_por_gama(
	IN gamaProducto VARCHAR(50),
	OUT totalProductos INT
)
BEGIN
	SELECT COUNT(*)
	INTO totalProductos
	FROM producto
	WHERE gama = gamaProducto;
END$$
DELIMITER ;

CALL contar_productos_por_gama('Herramientas', @cantidad);
SELECT @cantidad;
 -- 13 Insertar un nuevo pago validando que el cliente existe
 DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_pago$$
CREATE PROCEDURE insertar_pago(
	IN codCliente INT,
	IN formaPago VARCHAR(40),
	IN idTransaccion VARCHAR(50),
	IN fechaPago DATE,
	IN total DECIMAL(15,2)
)
BEGIN
	IF EXISTS (SELECT 1 FROM cliente WHERE codigo_cliente = codCliente) THEN
		INSERT INTO pago VALUES (codCliente, formaPago, idTransaccion, fechaPago, total);
	END IF;
END$$
DELIMITER ;
CALL insertar_pago(1, 'Transferencia', 'TX12345', '2024-06-07', 1500.00);
-- 14 Obtener el listado de gamas con productos disponibles (stock > 0)
DELIMITER $$
DROP PROCEDURE IF EXISTS gamas_con_stock$$
CREATE PROCEDURE gamas_con_stock()
BEGIN
	SELECT DISTINCT gama
	FROM producto
	WHERE cantidad_en_stock > 0;
END$$
DELIMITER ;
CALL gamas_con_stock();
-- 15 Calcular el importe total de un pedido a partir del detalle del pedido
DELIMITER $$
DROP PROCEDURE IF EXISTS calcular_total_pedido$$
CREATE PROCEDURE calcular_total_pedido(
	IN codPedido INT,
	OUT total DECIMAL(15,2)
)
BEGIN
	SELECT SUM(cantidad * precio_unidad)
	INTO total
	FROM detalle_pedido
	WHERE codigo_pedido = codPedido;
END$$
DELIMITER ;
CALL calcular_total_pedido(125, @total);
SELECT @total;
-- 16 Obtener los 5 clientes con mayor límite de crédito
DELIMITER $$
DROP PROCEDURE IF EXISTS top5_clientes_credito$$
CREATE PROCEDURE top5_clientes_credito()
BEGIN
	SELECT nombre_cliente, limite_credito
	FROM cliente
	ORDER BY limite_credito DESC
	LIMIT 5;
END$$
DELIMITER ;
CALL top5_clientes_credito();
-- 17 Listar empleados que no tienen jefe asignado
DELIMITER $$
DROP PROCEDURE IF EXISTS empleados_sin_jefe$$
CREATE PROCEDURE empleados_sin_jefe()
BEGIN
	SELECT * FROM empleado
	WHERE codigo_jefe IS NULL;
END$$
DELIMITER ;
CALL empleados_sin_jefe();
