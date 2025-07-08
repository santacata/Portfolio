#1.Procedimiento para obtener clientes de un país específico.
USE jardineria;
DELIMITER $$
DROP PROCEDURE IF EXISTS listar_clientes$$
CREATE PROCEDURE listar_clientes(IN in_pais VARCHAR(50))
BEGIN
    SELECT * FROM cliente c WHERE c.pais = in_pais;
END$$
DELIMITER ;
CALL listar_clientes('Spain');

#2.Procedimiento para obtener el pago máximo para una forma de pago específica.
DELIMITER $$
DROP PROCEDURE IF EXISTS obtener_pago_maximo$$
CREATE PROCEDURE obtener_pago_maximo(OUT maximo INT)
BEGIN
	SET maximo=(SELECT max(total) FROM pago);
END$$
DELIMITER ;
CALL obtener_pago_maximo(@maximo);
SELECT @maximo;
#3.Procedimiento para obtener estadísticas de pagos por forma de pago.
DELIMITER $$
DROP PROCEDURE IF EXISTS obtener_por_pago$$
CREATE PROCEDURE obtener_por_pago(IN in_forma VARCHAR(50))
BEGIN
	SELECT * FROM pago p WHERE p.forma_pago=in_forma;
END$$
DELIMITER ;
CALL obtener_por_pago('PayPal');
#4. Procedimiento para obtener todos los productos de una gama específica.
DELIMITER $$
DROP PROCEDURE IF EXISTS productos_gama$$
CREATE PROCEDURE productos_gama(IN in_gama VARCHAR(50))
BEGIN
	SELECT * FROM producto p WHERE p.gama=in_gama;
END$$
DELIMITER ;
CALL productos_gama('Herramientas');
#5.Procedimiento para obtener un árbol específico por su código.
DELIMITER $$
DROP PROCEDURE IF EXISTS arbol_codigo$$
CREATE PROCEDURE  arbol_codigo (IN  in_codigo VARCHAR(20))
BEGIN
	SELECT * FROM producto p WHERE in_codigo = p.codigo_producto;
END$$
DELIMITER ;
CALL arbol_codigo('FR-80');
#6. Procedimiento para obtener la cantidad disponible de un árbol específico.
DELIMITER $$
DROP PROCEDURE IF EXISTS stock_arbol$$
CREATE PROCEDURE stock_arbol(IN id_arbol VARCHAR(20))
BEGIN
	SELECT cantidad_en_stock FROM producto p WHERE p.codigo_producto=id_arbol;
END$$
DELIMITER ;
CALL stock_arbol('FR-80');
#7.Procedimiento para ver que clientes han comprado algún producto.
DELIMITER $$
DROP PROCEDURE IF EXISTS clients_producte$$
CREATE PROCEDURE clients_producte()
BEGIN
	SELECT DISTINCT c.*
	FROM cliente c
	JOIN pedido pe ON c.codigo_cliente = pe.codigo_cliente
	JOIN detalle_pedido d ON pe.codigo_pedido = d.codigo_pedido
	JOIN producto p ON d.codigo_producto = p.codigo_producto;
END$$
DELIMITER ;
CALL clients_producte();

	


