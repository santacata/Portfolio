-- 1. ¿Cuántos discos hay?
SELECT count(*)
FROM disco;
-- 2. Selecciona el nombre de los grupos que no sean de España.
SELECT nombre
FROM grupo
WHERE pais NOT LIKE 'España';
-- 3. Obtener el título de las canciones con más de 5 minutos de duración.
SELECT titulo
FROM cancion
WHERE duracion > 5 ;
 -- 4. Según los datos en la base de datos, obtener la lista de las distintas funciones que se pueden realizar en un grupo.
SELECT DISTINCT funcion
FROM pertenece;
-- 5. Selecciona el nombre y la sede de los clubes de fans con más de 500 socios.
SELECT nombre,sede
FROM club
WHERE num > 500 ;
-- 6. Obtener el nombre y la sede de cada club de fans de grupos de España así como el nombre del grupo al que admiran.
SELECT C.nombre, C.sede, G.nombre
FROM club C, grupo G
WHERE C.cod_gru = G.cod AND G.pais LIKE 'España';
 -- 7. Obtener el nombre de los artistas que pertenezcan a un grupo de España.
SELECT DISTINCT A.nombre
FROM artista A, pertenece P, grupo G
WHERE P.dni = A.dni AND P.cod = G.cod AND G.pais LIKE 'España';
-- 8. Obtener el nombre de los discos que contienen alguna canción que dure más de 5 minutos.
SELECT DISTINCT D.nombre
FROM disco D, cancion C, esta E
WHERE E.can = C.cod AND E.cod = D.cod AND C.duracion > 5.00;
--  9. Obtener los nombres de las canciones que dan nombre al disco en el que aparecen.
SELECT DISTINCT C.titulo
FROM disco D, cancion C, esta E
WHERE D.nombre = C.titulo AND E.can = C.cod AND E.cod = D.cod ;
-- 10. Obtener los nombres de compañías y direcciones postales de aquellas compañías que han grabado algún disco que empiece por ‘A’.
SELECT distinct C.nombre, C.dir
FROM disco D, companyia C
WHERE D.cod_comp = C.cod AND D.nombre LIKE 'A%';
-- 11. Obtener el nombre de los discos del grupo más viejo.
SELECT d.nombre 
FROM disco d, grupo g
WHERE g.cod=d.cod_gru AND g.fecha=( SELECT MIN(fecha) FROM grupo );
-- 12. Obtener el nombre de los discos grabados por grupos con club de fans con más de 5000 personas.
SELECT DISTINCT(d.nombre)
FROM disco d, club cl
WHERE d.cod_gru = cl.cod_gru
AND cl.num > 5000;
-- 13. Obtener el nombre de los clubes con mayor número de fans indicando ese número.
SELECT nombre, num FROM club
WHERE num = (SELECT MAX(C.num) FROM club C);
-- 14. Obtener el título de las canciones de mayor duración indicando la duración.
SELECT C.titulo, C.duracion
FROM cancion C
WHERE C.duracion = (SELECT MAX(D.duracion) FROM cancion D);
-- 15. Obtener el nombre de las compañías discográficas que no han trabajado con grupos españoles.
SELECT C.nombre FROM companyia C
WHERE NOT EXISTS 
(SELECT * 
FROM disco D, grupo G
WHERE D.cod_gru = G.cod AND G.pais LIKE 'España' AND C.cod = D.cod_comp);
-- 16. Obtener el nombre de las compañías discográficas que sólo han trabajado con grupos españoles.
SELECT C.nombre FROM companyia C
WHERE
EXISTS (SELECT *
FROM disco D, grupo G
WHERE D.cod_gru = G.cod AND G.pais LIKE 'España' AND C.cod =
D.cod_comp);
 -- 17. Obtener el nombre y la dirección de aquellas compañías discográficas que han grabado todos los discos de algún grupo.
SELECT DISTINCT C.nombre, C.dir
FROM companyia C, disco D
WHERE D.cod_comp = C.cod AND
NOT EXISTS (SELECT * FROM disco E
WHERE E.cod_gru = D.cod_gru AND E.cod_comp <>
D.cod_comp);
-- 18. Obtener el nombre de los grupos que sean de España y la suma de sus fans.
SELECT g.nombre, sum(cl.num)
FROM grupo g, club cl
WHERE cl.cod_gru=g.cod AND g.pais LIKE 'España'
GROUP BY g.cod, g.nombre;
-- 19. Obtener para cada grupo con más de dos componentes el nombre y el número de componentes del grupo.
SELECT g.nombre, count(d.cod)
FROM grupo g LEFT JOIN disco d ON g.cod=d.cod_gru #Haciendo un left join se mostrariam todos los grupos sin la condicion de on
GROUP BY g.cod, g.nombre;
-- 20. Obtener el número de discos de cada grupo.
SELECT g.nombre, COUNT(*) AS num_discos
FROM disco d
JOIN grupo g ON d.cod_gru = g.cod
GROUP BY g.nombre ORDER BY COUNT(*) DESC;
-- 21. Obtener el número de canciones que ha grabado cada compañía discográfica y su dirección.
SELECT C.nombre, COUNT(DISTINCT E.can) AS num_canciones, C.dir
FROM companyia C
LEFT JOIN disco D ON C.cod = D.cod_comp
LEFT JOIN esta E ON E.cod = D.cod
GROUP BY C.cod, C.nombre, C.dir;
-- 22. Obtener los nombre de los artistas de grupos con clubes de fans de más de 500 personas y que el grupo sea de Inglaterra.
SELECT DISTINCT a.nombre
FROM artista a, grupo g, club cl, pertenece p
WHERE g.pais LIKE 'Inglaterra' AND p.cod=g.cod AND a.dni=p.dni
AND cl.cod_gru=g.cod AND cl.num >500;
-- 23. Obtener el título de las canciones de todos los discos del grupo U2.
SELECT DISTINCT c.titulo
FROM disco d, cancion c, grupo g, esta e
WHERE c.cod=e.can AND e.cod=d.cod AND g.cod=d.cod_gru AND g.nombre LIKE'U2';
-- 24. El dúo dinámico por fin se jubila; para sustituirles se pretende hacer una selección sobre todos los pares de artistas de grupos españoles distintos tales que el primero sea voz y el segundo guitarra. Obtener dicha selección.
SELECT DISTINCT A1.nombre AS Voz, A2.nombre AS Guitarra
FROM artista A1
JOIN pertenece P1 ON A1.dni = P1.dni
JOIN grupo G1 ON P1.cod = G1.cod
JOIN artista A2 ON A1.dni != A2.dni
JOIN pertenece P2 ON A2.dni = P2.dni
JOIN grupo G2 ON P2.cod = G2.cod
WHERE 
  G1.cod != G2.cod
  AND G1.pais = 'España'
  AND G2.pais = 'España'
  AND P1.funcion = 'voz'
  AND P2.funcion = 'guitarra';
  -- 25. Obtener el nombre de los artistas que pertenecen a más de un grupo.
SELECT A.nombre
FROM artista A
JOIN pertenece P ON A.dni = P.dni
GROUP BY A.dni, A.nombre
HAVING COUNT(DISTINCT P.cod) > 1;
 -- 26. Obtener el título de la canción de mayor duración si es única.
SELECT C.titulo, C.duracion
FROM cancion C
WHERE 1 = (SELECT COUNT(*)
FROM cancion D WHERE D.duracion >= C.duracion); #EL WHERE SE ASEGURA QUE SOLO ES 1
-- 27. Obtener el décimo (debe haber sólo 9 por encima de él) club con mayor número de fans indicando ese número.
SELECT C.nombre, C.num
FROM club C
WHERE 9 = (SELECT COUNT(*) FROM club D WHERE D.num > C.num);
-- 28. Obtener el nombre de los artistas que tengan la función de bajo en un único grupo y que además éste tenga más de dos miembros.
SELECT DISTINCT A.nombre 
FROM artista A, pertenece P 
WHERE P.dni = A.dni 
  AND P.funcion = 'bajo' 
  AND NOT EXISTS (
    SELECT 1 
    FROM pertenece Q 
    WHERE Q.dni = P.dni 
      AND Q.funcion = 'bajo' 
      AND Q.cod <> P.cod
  )
  AND (
    SELECT COUNT(*) 
    FROM pertenece R 
    WHERE R.cod = P.cod
  ) > 2;
-- 29. ¿Cuál es la compañía discográfica que más canciones ha grabado?
SELECT C.nombre, COUNT(DISTINCT E.can) AS canciones  
FROM companyia C
JOIN disco D ON D.cod_comp = C.cod
JOIN esta E ON E.cod = D.cod
GROUP BY C.nombre, C.cod
HAVING COUNT(DISTINCT E.can) >= ALL (
    SELECT COUNT(DISTINCT E1.can)
    FROM companyia C1
    JOIN disco D1 ON D1.cod_comp = C1.cod
    JOIN esta E1 ON E1.cod = D1.cod
    GROUP BY C1.nombre, C1.cod
);

