DELIMITER $$
DROP FUNCTION IF EXISTS contar_productos$$
CREATE FUNCTION contar_productos(gama VARCHAR(50)) RETURNS INT UNSIGNED
DETERMINISTIC
BEGIN
-- Paso 1. Declaramos una variable local
DECLARE total INT UNSIGNED;
-- Paso 2. Contamos los productos
SET total = (
SELECT count(*)
FROM producto
WHERE producto.gama = gama);
-- Paso 3. Devolvemos el resultado
RETURN total;
END $$
DELIMITER ;
SELECT contar_productos('Herramientas');
-- Exercici2
DELIMITER $$
DROP FUNCTION IF EXISTS nombre_completo$$
CREATE FUNCTION nombre_completo(codigo INTEGER) RETURNS
VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE nombre_completo VARCHAR(100);
SELECT CONCAT(nombre, ' ', apellido1, ' ', COALESCE(apellido2, '')) INTO
nombre_completo
FROM empleado
WHERE codigo = codigo_empleado;
RETURN nombre_completo;
END $$
DELIMITER ;
SELECT nombre_completo(2);
--
DELIMITER //
DROP FUNCTION IF EXISTS obtener_precio_total_pedido//
CREATE FUNCTION obtener_precio_total_pedido(codigo INTEGER) RETURNS DECIMAL (15,2)
DETERMINISTIC
BEGIN 
    DECLARE total DECIMAL(15,2);
    SELECT SUM(dp.cantidad * p.precio_venta) INTO total
    FROM detalle_pedido dp, producto p 
    WHERE dp.codigo_producto = p.codigo_producto
    AND dp.codigo_pedido = codigo;
    RETURN total;
END //
DELIMITER ;

SELECT obtener_precio_total_pedido(2);
--
DELIMITER //
DROP FUNCTION IF EXISTS obtener_cantidad_stock_gama//
CREATE FUNCTION obtener_cantidad_stock_gama(gama_producto VARCHAR(50)) RETURNS INT
DETERMINISTIC
BEGIN 
    DECLARE stock INT;
    SET stock=(SELECT SUM(cantidad_en_stock)
    FROM producto 
    WHERE gama_producto = gama);
    RETURN stock;
END //
DELIMITER ;

SELECT obtener_cantidad_stock_gama('Herramientas');

DELIMITER //
DROP FUNCTION IF EXISTS calcular_descuento_gama//
CREATE FUNCTION calcular_descuento_gama(
    cod_producto VARCHAR(15)
)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN 
    DECLARE precio_base DECIMAL(15,2);
    DECLARE gama_producto VARCHAR(50);
    DECLARE precio_final DECIMAL(15,2);

    -- OBTENER EL PRECIO Y LA GAMA DEL PRODUCTO
    SELECT precio_venta, gama INTO precio_base, gama_producto
    FROM producto
    WHERE codigo_producto = cod_producto;

    -- CALCULAR EL PRECIO CON DESCUENTO SEGÚN LA GAMA
    IF gama_producto = 'Herramientas' THEN 
        SET precio_final = precio_base * 0.80; -- Descuento del 20%
    ELSEIF gama_producto = 'Frutales' THEN
        SET precio_final = precio_base * 0.75; -- Descuento del 25%
    ELSEIF gama_producto = 'Ornamentales' THEN
        SET precio_final = precio_base * 0.90; -- Descuento del 10%
    ELSE
        SET precio_final = precio_base; -- NO HAY DESCUENTO
    END IF;

    RETURN precio_final;
END //
DELIMITER ;
SELECT calcular_descuento_gama('FR-105');

--

DELIMITER //
DROP FUNCTION IF EXISTS calcular_descuento_gama2//
CREATE FUNCTION calcular_descuento_gama2(
    cod_producto VARCHAR(15)
)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN 
    DECLARE precio_base DECIMAL(15,2);
    DECLARE gama_producto VARCHAR(50);
    DECLARE precio_final DECIMAL(15,2);

    -- OBTENER EL PRECIO Y LA GAMA DEL PRODUCTO
    SELECT precio_venta, gama INTO precio_base, gama_producto
    FROM producto
    WHERE codigo_producto = cod_producto;

    -- CALCULAR EL PRECIO CON DESCUENTO SEGÚN LA GAMA
    CASE gama_producto 
		WHEN 'Herramientas' THEN 
			SET precio_final = precio_base * 0.80; -- Descuento del 20%
		WHEN gama_producto = 'Frutales' THEN
			SET precio_final = precio_base * 0.75; -- Descuento del 25%
		WHEN gama_producto = 'Ornamentales' THEN
			SET precio_final = precio_base * 0.90; -- Descuento del 10%
		ELSE
			SET precio_final = precio_base; -- NO HAY DESCUENTO FOR YU
		END CASE;

    RETURN precio_final;
END //
DELIMITER ;
SELECT calcular_descuento_gama2('FR-105');

-- EJERCICIOS
-- FUNCION XRA OBTENER LA CANTIDAD DE PRODUCTOS EN STOCK POR CODIGO DE PRODUCTO
DELIMITER //

DROP FUNCTION IF EXISTS cantidad_productos_stock//
CREATE FUNCTION cantidad_productos_stock(
    cod_producto VARCHAR(15)
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE stock INT;

    SET stock=(SELECT SUM(cantidad_en_stock)
    FROM producto
    WHERE codigo_producto = cod_producto);

    RETURN stock;
END //

DELIMITER ;

SELECT cantidad_productos_stock('FR-105');
-- nombre completo cliente segun su codigo

DELIMITER //

DROP FUNCTION IF EXISTS nombre_segun_codigo//
CREATE FUNCTION nombre_segun_codigo(
    cod INT
)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
    DECLARE nombre_completo VARCHAR(50);

    SET nombre_completo=
    (SELECT CONCAT(nombre_contacto, " ",apellido_contacto) 
    FROM cliente 
    WHERE codigo_cliente=cod);

    RETURN nombre_completo;
END //

DELIMITER ;

SELECT nombre_segun_codigo(3);
-- 
DELIMITER //

DROP FUNCTION IF EXISTS total_pedido_codigo//
CREATE FUNCTION total_pedido_codigo(
    cod INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10,2);

    SELECT SUM(precio_unidad * cantidad)
    INTO total
    FROM detalle_pedido
    WHERE codigo_pedido = cod;

    RETURN IFNULL(total, 0.00);
END //

DELIMITER ;

-- Llamada a la función
SELECT total_pedido_codigo(3);

-- 


