# Proveedores
Debemos construir un servicio para obtener la información de los proveedores de un cliente.

Problema: Debemos construir un servicio para obtener la información de los proveedores de
un cliente.
Backend - java Spring Boot : Micro de consulta a BBDD para traernos un array de resultados
(usando JPA), que invoquemos desde postman contra el endpoint de dicho micro (incluyendo
test unitario con Junit 5)
Instrucciones técnicas:
Desarrollar un pequeño programa java Spring Boot que consulte a BBDD para traernos un
array de resultados con los datos de proveedor (usando JPA). Dicho programa debe incluir los
test unitarios con Junit5.
El programa debe de recibir un parámetro de entrada el cual será el código del cliente.
El programa debe de recibir el parámetro de entrada (código cliente) y realizar una consulta a
la tabla de proveedores en base de datos, estos datos deben de ser recolectados para devolver
un array con los proveedores y sus datos.
Si el código no tiene registros, el programa debe devolver un array vacío.
Tabla: proveedores
Campos: id_proveedor, nombre, fecha de alta, id_cliente
Proveedores:
1, Coca-cola, dd/mm/yyyy,5
2, Pepsi, dd/mm/yyyy, 5
3, Redbull, dd/mm/yyyy, 6
4, Fanta,dd/mm/yyyy, 7
5, Casera, dd/mm/yyyy, 8
6, Trina, dd/mm/yyyy, 6

- .

Otros: Se puede utilizar control de dependencias como maven para facilidad de pruebas
