/* Populate tables */
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Andres', 'roballo',15, 'andres@andres.com', '1111111','todas','2017-08-01', '', true, "123456789a");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('John', 'Doe', 15,'john.doe@gmail.com','1111112','todas','2017-08-02', '', true, "123456789b");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Linus', 'Torvalds', 15,'linus.torvalds@gmail.com','1111113','todas','2017-08-03', '', true, "987654321a");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Jane', 'Doe', 15,'jane.doe@gmail.com', '1111114','todas','2017-08-04', '', true, "123456789d");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Rasmus', 'Lerdorf', 15,'rasmus.lerdorf@gmail.com','1111115','todas', '2017-08-05', '', true,"123456789b");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Erich', 'Gamma',15, 'erich.gamma@gmail.com', '1111116','todas','2017-08-06', '', true, "987654321b");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Richard', 'Helm',15, 'richard.helm@gmail.com', '1111117','todas','2017-08-07', '', true, "987654321c");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Ralph', 'Johnson',15, 'ralph.johnson@gmail.com', '1111118','todas','2017-08-08', '', true, "987654321d");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('John', 'Vlissides', 15,'john.vlissides@gmail.com','1111119','todas', '2017-08-09', '', true, "987654321e");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('James', 'Gosling',15, 'james.gosling@gmail.com', '1111110','todas','2017-08-010', '', true, "987654321f");
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Bruce', 'Lee',15, 'bruce.lee@gmail.com', '0111111','todas','2017-08-11', '', true,  "123456789e");
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Johnny', 'Doe',15, 'johnny.doe@gmail.com', '0011114','todas','2017-08-12', '', true, "123456789f");
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('John', 'Roe',15, 'john.roe@gmail.com', '1111114','todas','2017-08-13', '', true, "123456789g");
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Jane', 'Roe', 15,'jane.roe@gmail.com', '1111114','todas','2017-08-14', '', true, "123456789h");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Richard', 'Doe',15, 'richard.doe@gmail.com','1111114','todas', '2017-08-15', '', true, "123456789i");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Janie', 'Doe',15, 'janie.doe@gmail.com', '1111114','todas','2017-08-16', '', true, "123456789j");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Phillip', 'Webb', 15,'phillip.webb@gmail.com', '1111114','todas','2017-08-17', '', true, "123456789k");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Stephane', 'Nicoll',15, 'stephane.nicoll@gmail.com','1111114','todas', '2017-08-18', '', true, "987654321g");
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Sam', 'Brannen', 15,'sam.brannen@gmail.com', '1111114','todas','2017-08-19', '', true, "987654321h");  
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Juergen', 'Hoeller', 15,'juergen.Hoeller@gmail.com', '1111114','todas','2017-08-20', '', true, "987654321f"); 
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Janie', 'Roe', 15,'janie.roe@gmail.com', '1111114','todas', '2017-08-21', '', true, "987654321i");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('John', 'Smith', 15,'john.smith@gmail.com', '1111114','todas', '2017-08-22', '', true, "987654321z");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Joe', 'Bloggs', 15,'joe.bloggs@gmail.com', '1111114','todas', '2017-08-23', '', true, "987654321w");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('John', 'Stiles', 15,'john.stiles@gmail.com', '1111114','todas', '2017-08-24', '', true, "987654321v");
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto, existe_cliente, dni) VALUES('Richard', 'Roe', 15,'stiles.roe@gmail.com', '1111114','todas','2017-08-25', '', true, "987654321r");

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Panasonic Pantalla LCD', 259990, NOW(), false);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Sony Camara digital DSC-W320B', 123490, NOW(), true);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Apple iPod shuffle', 1499990, NOW(), true);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Sony Notebook Z110', 37990, NOW(), true);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW(), true);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW(), false);
INSERT INTO productos (nombre, precio, create_at, existe) VALUES('Mica Comoda 5 Cajones', 299990, NOW(), true);

insert into facturas (descripcion, observacion, cliente_id, create_at) VALUES("una descripcion de una factura","Observación: una observacion oportuna", 1, now());
insert into facturas (descripcion, observacion, cliente_id, create_at) VALUES("segunda factura","Observación: segunda observacion oportuna",  1, now());
insert into facturas (descripcion, observacion, cliente_id, create_at) VALUES("una descripcion de una factura", "Observación: tercera observacion oportuna", 2, now());
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', "Observación: cuarta observacion oportuna", 1, NOW());

/* Creamos algunas facturas */
--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(4, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(5, 2, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(4, 2, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(4, 2, 2);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(4, 3, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 3, 2);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);
--
--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');


INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Edwin','Villa', 'eledwin@gmail.com', '954777777','masajista', '2017-08-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Fran','Rivera', 'rivera@gmail.com', '954555555', 'practicante','2019-01-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Laura','García garcia', 'laura@gmail.com', '954777777', 'masajista','2018-02-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Vanessa','Pérez', 'vane@gmail.com', '954111111','practicante', '2019-02-20');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Edu','Vi', 'ele@gmail.com', '954777777','masajista', '2017-08-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Frana','Riv', 'riv@gmail.com', '954555555', 'practicante','2019-01-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Lau','Gar', 'lau@gmail.com', '954777777', 'masajista','2018-02-23');
INSERT INTO empleados  (nombre, apellido, email, telefono, tipo_empleado, create_at) VALUES ('Vanessa la mejor de todas','Péresozaaaaaaaalocaaaaaaa', 'vaneeeeeeee@gmail.com', '954111111','practicante', '2019-02-20');
