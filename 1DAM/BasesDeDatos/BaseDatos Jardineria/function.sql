-- 1 Función para obtener la cantidad de productos en stock por código de productoFunción para obtener la cantidad de productos en stock por código de producto
DELIMITER $$
DROP FUNCTION IF EXISTS cantidad_stock_producto$$
CREATE FUNCTION cantidad_stock_producto(codProducto VARCHAR(15))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE stock INT;
	SELECT cantidad_en_stock INTO stock
	FROM producto
	WHERE codigo_producto = codProducto;
	RETURN stock;
END$$
DELIMITER ;
SELECT cantidad_stock_producto(11679);
-- 2 Función para obtener el nombre completo de un cliente dado su código 
DELIMITER $$
DROP FUNCTION IF EXISTS nombre_completo_cliente$$
CREATE FUNCTION nombre_completo_cliente(codCliente INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	DECLARE nombreCompleto VARCHAR(100);
	SET nombreCompleto=(SELECT CONCAT(nombre_contacto, ' ', apellido_contacto)
	FROM cliente
	WHERE codigo_cliente = codCliente);
    RETURN nombreCompleto;
END$$
DELIMITER ;
SELECT nombre_completo_cliente(3);
-- 3 Calcular el total de un pedido dado su código
DELIMITER $$
DROP FUNCTION IF EXISTS total_pedido$$
CREATE FUNCTION total_pedido(codPedido INT)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
	DECLARE total DECIMAL(15,2);
	SELECT SUM(cantidad * precio_unidad) INTO total
	FROM detalle_pedido
	WHERE codigo_pedido = codPedido;
	RETURN total;
END$$
DELIMITER ;
SELECT total_pedido(3);
-- 4 Obtener el nombre completo de un empleado y su jefe
DELIMITER $$
DROP FUNCTION IF EXISTS empleado_y_jefe$$
CREATE FUNCTION empleado_y_jefe(codEmpleado INT)
RETURNS VARCHAR(200)
DETERMINISTIC
BEGIN
	DECLARE jefeNombre VARCHAR(100);
	DECLARE empNombre VARCHAR(100);

	SELECT CONCAT(nombre, ' ', apellido1)
	INTO empNombre
	FROM empleado
	WHERE codigo_empleado = codEmpleado;

	SELECT CONCAT(nombre, ' ', apellido1)
	INTO jefeNombre
	FROM empleado
	WHERE codigo_empleado = (SELECT codigo_jefe
	FROM empleado
	WHERE codigo_empleado = codEmpleado);

	RETURN CONCAT(empNombre, ' <-trabajador jefe->', jefeNombre);
END$$
DELIMITER ;
select empleado_y_jefe(3);
-- 5  Calcular el total de ventas de un cliente
DELIMITER $$
DROP FUNCTION IF EXISTS total_ventas_cliente$$
CREATE FUNCTION total_ventas_cliente(codCliente INT)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
	DECLARE total DECIMAL(15,2);
	SELECT SUM(dp.cantidad * dp.precio_unidad) INTO total
	FROM pedido p
	JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido
	WHERE p.codigo_cliente = codCliente;
	RETURN total; 
END$$
DELIMITER ;
SELECT total_ventas_cliente(5);
-- 6 Función para obtener la cantidad de productos por gama
DELIMITER $$
DROP FUNCTION IF EXISTS cantidad_productos_por_gama$$
CREATE FUNCTION cantidad_productos_por_gama(nombreGama VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE cantidad INT;
	SELECT COUNT(*) INTO cantidad
	FROM producto
	WHERE gama = nombreGama;
	RETURN cantidad;
END$$
DELIMITER ;

SELECT cantidad_productos_por_gama('Herramientas');
-- 7 Función para obtener el total económico de un pedido (cantidad * precio unidad)
DELIMITER $$
DROP FUNCTION IF EXISTS total_economico_pedido$$
CREATE FUNCTION total_economico_pedido(codPedido INT)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
	DECLARE total DECIMAL(15,2);
	SELECT SUM(cantidad * precio_unidad) INTO total
	FROM detalle_pedido
	WHERE codigo_pedido = codPedido;
	RETURN IFNULL(total, 0.00);
END$$
DELIMITER ;

SELECT total_economico_pedido(10);
-- 8 Función para obtener el crédito disponible de un cliente
DELIMITER $$
DROP FUNCTION IF EXISTS credito_disponible$$
CREATE FUNCTION credito_disponible(codCliente INT)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
	DECLARE totalPagado DECIMAL(15,2);
	DECLARE limite DECIMAL(15,2);

	SELECT limite_credito INTO limite
	FROM cliente
	WHERE codigo_cliente = codCliente;

	SELECT SUM(total) INTO totalPagado
	FROM pago
	WHERE codigo_cliente = codCliente;

	RETURN limite - totalPagado;
END$$
DELIMITER ;

SELECT credito_disponible(5);
-- 9 Función para contar productos con stock bajo un umbral
DELIMITER $$
DROP FUNCTION IF EXISTS productos_bajo_stock$$
CREATE FUNCTION productos_bajo_stock(umbral INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE cantidad INT;
	SELECT COUNT(*) INTO cantidad
	FROM producto
	WHERE cantidad_en_stock < umbral;
	RETURN cantidad;
END$$
DELIMITER ;

SELECT productos_bajo_stock(10);
-- 10 Función para obtener el nombre completo de un empleado dado su codigo

DELIMITER $$
DROP FUNCTION IF EXISTS nombre_completo_empleado$$
CREATE FUNCTION nombre_completo_empleado(codEmpleado INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	DECLARE nombreCompleto VARCHAR(100);
	SELECT CONCAT(nombre, ' ', apellido1, ' ', COALESCE(apellido2, '')) INTO nombreCompleto -- usamos el coalesce pa que no de error
	FROM empleado
	WHERE codigo_empleado = codEmpleado;
	RETURN nombreCompleto;
END$$
DELIMITER ;

SELECT nombre_completo_empleado(12);
-- 11 Función para obtener el código del último pedido realizado por un cliente dado su código.
DELIMITER $$
DROP FUNCTION IF EXISTS ultimo_pedido_cliente$$
CREATE FUNCTION ultimo_pedido_cliente(codCliente INT)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE codPedido INT;
  SELECT MAX(codigo_pedido) INTO codPedido
  FROM pedido
  WHERE codigo_cliente = codCliente;
  RETURN codPedido;
END$$
DELIMITER ;
SELECT ultimo_pedido_cliente(7);
-- 12 Función para obtener la cantidad total de pedidos con un estado específico dado el estado.
DELIMITER $$
DROP FUNCTION IF EXISTS total_pedidos_por_estado$$
CREATE FUNCTION total_pedidos_por_estado(estadoPedido VARCHAR(15))
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE total INT;
  SELECT COUNT(*) INTO total
  FROM pedido
  WHERE estado = estadoPedido;
  RETURN total;
END$$
DELIMITER ;
SELECT total_pedidos_por_estado('ENTREGADO');
-- 13 Función para obtener el total pagado por un cliente en todos sus pagos dado su código.
DELIMITER $$
DROP FUNCTION IF EXISTS total_pagado_cliente$$
CREATE FUNCTION total_pagado_cliente(codCliente INT)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
  DECLARE total_pagado DECIMAL(15,2);
  SELECT SUM(total) INTO total_pagado
  FROM pago
  WHERE codigo_cliente = codCliente;
  RETURN total_pagado;
END$$
DELIMITER ;
SELECT total_pagado_cliente(15);
-- 14 Función para obtener el código del jefe directo de un empleado dado su código.
DELIMITER $$
DROP FUNCTION IF EXISTS jefe_directo$$
CREATE FUNCTION jefe_directo(codEmpleado INT)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE jefe INT;
  SELECT codigo_jefe INTO jefe
  FROM empleado
  WHERE codigo_empleado = codEmpleado;
  RETURN jefe;
END$$
DELIMITER ;
SELECT jefe_directo(12);
-- 15 Función para obtener la cantidad de productos que hay en una gama concreta dada.
DELIMITER $$
DROP FUNCTION IF EXISTS productos_por_gama$$
CREATE FUNCTION productos_por_gama(gamaNombre VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE total INT;
  SELECT COUNT(*) INTO total
  FROM producto
  WHERE gama = gamaNombre;
  RETURN total;
END$$
DELIMITER ;
SELECT productos_por_gama('Herramientas'); -- Es la funcion n6
-- 16 Función para obtener el precio medio de los productos de una gama concreta dada
DELIMITER $$
DROP FUNCTION IF EXISTS precio_medio_gama$$
CREATE FUNCTION precio_medio_gama(nombreGama VARCHAR(50))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
  DECLARE media DECIMAL(10,2);
  SELECT AVG(precio_venta) INTO media
  FROM producto
  WHERE gama = nombreGama;
  RETURN media;
END$$
DELIMITER ;
SELECT precio_medio_gama('Herramientas');
-- 17 Función para obtener la cantidad de pedidos de un cliente en un rango de fechas
DELIMITER $$
DROP FUNCTION IF EXISTS pedidos_cliente_fecha$$
CREATE FUNCTION pedidos_cliente_fecha(codCliente INT, fechaInicio DATE, fechaFin DATE)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE cantidad INT;
  SELECT COUNT(*) INTO cantidad
  FROM pedido
  WHERE codigo_cliente = codCliente
    AND fecha_pedido BETWEEN fechaInicio AND fechaFin;
  RETURN cantidad;
END$$
DELIMITER ;
SELECT pedidos_cliente_fecha(1, '1990-01-17', '2025-06-08');
-- 18 Función para verificar si un cliente tiene pedidos pendientes de pago (estado ≠ 'Entregado')
DELIMITER $$
DROP FUNCTION IF EXISTS tiene_pedidos_pendientes$$
CREATE FUNCTION tiene_pedidos_pendientes(codCliente INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
  DECLARE tiene INT;
  SELECT COUNT(*) INTO tiene
  FROM pedido
  WHERE codigo_cliente = codCliente
    AND estado != 'Entregado';
  RETURN IF(tiene > 0, 1, 0);
END$$
DELIMITER ;
SELECT tiene_pedidos_pendientes(3);
-- 19 Función para obtener la fecha del último pago realizado por un cliente
DELIMITER $$
DROP FUNCTION IF EXISTS ultima_fecha_pago$$
CREATE FUNCTION ultima_fecha_pago(codCliente INT)
RETURNS DATE
DETERMINISTIC
BEGIN
  DECLARE ultima DATE;
  SELECT MAX(fecha_pago) INTO ultima
  FROM pago
  WHERE codigo_cliente = codCliente;
  RETURN ultima;
END$$
DELIMITER ;
SELECT ultima_fecha_pago(4);
-- 20  Función para obtener la suma total de unidades en stock de todos los productos.
DELIMITER $$
DROP FUNCTION IF EXISTS total_stock$$
CREATE FUNCTION total_stock()
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE suma INT;
  SELECT SUM(cantidad_en_stock) INTO suma
  FROM producto;
  RETURN suma;
END$$
DELIMITER ;
SELECT total_stock();
-- 21 Función para obtener el número de empleados que trabajan en una oficina dada, dado el código de oficina
DELIMITER $$
DROP FUNCTION IF EXISTS empleados_en_oficina$$
CREATE FUNCTION empleados_en_oficina(codOficina VARCHAR(10))
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE cantidad INT;
  SELECT COUNT(*) INTO cantidad
  FROM empleado
  WHERE codigo_oficina = codOficina;
  RETURN cantidad;
END$$
DELIMITER ;
SELECT empleados_en_oficina('TAL-ES');
-- FUNCIONES CON CASE
-- 22 Función para obtener el estado de un pedido dado su código utilizando CASE
DELIMITER $$
DROP FUNCTION IF EXISTS estado_pedido$$
CREATE FUNCTION estado_pedido(codPedido INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE estado VARCHAR(50);
  SELECT CASE estado
           WHEN 'Pendiente' THEN 'Aún realizado'
           WHEN 'Rechazado' THEN 'No se ha aceptado'
           WHEN 'Entregado' THEN 'Pedido finalizado'
           ELSE 'Otro estado'
         END
  INTO estado
  FROM pedido
  WHERE codigo_pedido = codPedido;
  RETURN estado;
END$$
DELIMITER ;
SELECT estado_pedido(1);
-- 23 Función para obtener la descripción de un producto utilizando CASE
DELIMITER $$
DROP FUNCTION IF EXISTS descripcion_producto$$
CREATE FUNCTION descripcion_producto(codProducto VARCHAR(15))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
  DECLARE descripcion VARCHAR(100);
  SELECT CASE
           WHEN descripcion IS NULL OR descripcion = '' THEN 'Sin descripción'
           ELSE descripcion
         END
  INTO descripcion
  FROM producto
  WHERE codigo_producto = codProducto;
  RETURN descripcion;
END$$
DELIMITER ;

SELECT descripcion_producto('FR-23');
-- 24 Función para obtener la región de una oficina utilizando CASE
DELIMITER $$
DROP FUNCTION IF EXISTS region_oficina$$
CREATE FUNCTION region_oficina(codOficina VARCHAR(10))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE regionRes VARCHAR(50);
  SELECT CASE
           WHEN region IS NULL THEN 'Sin región'
           ELSE region
         END
  INTO regionRes
  FROM oficina
  WHERE codigo_oficina = codOficina;
  RETURN regionRes;
END$$
DELIMITER ;

SELECT region_oficina('MAD-ES');
-- 25 Función para obtener el estado de un pedido basado en la fecha de entrega
DELIMITER $$
DROP FUNCTION IF EXISTS estado_segun_fecha_entrega$$
CREATE FUNCTION estado_segun_fecha_entrega(codPedido INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE estado VARCHAR(50);
  SELECT CASE
           WHEN fecha_entrega IS NULL THEN 'No entregado'
           ELSE 'Entregado'
         END
  INTO estado
  FROM pedido
  WHERE codigo_pedido = codPedido;
  RETURN estado;
END$$
DELIMITER ;

SELECT estado_segun_fecha_entrega(125);
--  26 Función para obtener la categoría de cliente basada en el límite de crédito
DELIMITER $$
DROP FUNCTION IF EXISTS categoria_cliente$$
CREATE FUNCTION categoria_cliente(codCliente INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE categoria VARCHAR(50);
  DECLARE limite DECIMAL(15,2);

  SELECT limite_credito INTO limite
  FROM cliente
  WHERE codigo_cliente = codCliente;

  SET categoria = CASE
                    WHEN limite IS NULL THEN 'Sin crédito'
                    WHEN limite < 10000 THEN 'Plata'
                    WHEN limite < 25000 THEN 'Oro'
                    ELSE 'Platino'
                  END;

  RETURN categoria;
END$$
DELIMITER ;

SELECT categoria_cliente(1);
-- 27 Función para obtener el estado de un empleado basado en su puesto
DELIMITER $$
DROP FUNCTION IF EXISTS estado_empleado$$
CREATE FUNCTION estado_empleado(codEmpleado INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE estado VARCHAR(50);
  DECLARE cargo VARCHAR(50);

  SELECT puesto INTO cargo
  FROM empleado
  WHERE codigo_empleado = codEmpleado;

  SET estado = CASE
                 WHEN cargo IS NULL THEN 'Sin puesto definido'
                 WHEN cargo LIKE '%Director%' THEN 'Alta dirección'
                 WHEN cargo LIKE '%Ventas%' THEN 'Departamento de ventas'
                 ELSE 'Empleado estándar'
               END;

  RETURN estado;
END$$
DELIMITER ;

SELECT estado_empleado(5);






