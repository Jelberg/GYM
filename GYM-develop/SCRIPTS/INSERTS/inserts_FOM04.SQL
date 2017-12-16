-- TRES USUARIO PARA REALIZAR LAS PRUEBAS
insert into usuario (usu_cedula,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac) values (12312312,'Simon', 'Esperanza', 'M','01/01/2000');
insert into usuario (usu_cedula,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac) values (45645645,'Marvian', 'Montoya', 'F','01/01/2000');
insert into usuario (usu_cedula,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac) values (78978978,'Gilbert', 'Gomez', 'M','01/01/2000');

-- INSERTS DE PROGRESOS COMPARTIDOS
insert into comentario (com_mensaje, com_fecha, fk_usuario) values ('¡Rebajo 3 Kg este mes!','14/11/2017',1);
insert into comentario (com_mensaje, com_fecha, fk_usuario) values ('¡Aumento 1 Kg este mes!','14/11/2017',1);
insert into comentario (com_mensaje, com_fecha, fk_usuario) values ('¡Ahora realiza series de 50 flexiones!','14/11/2017',1);

-- INSERTS DE COMENTARIOS SOBRE PROGRESOS COMPARTIDOS
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('Excelente avance', 2, 1);
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('¡Muy bien!', 3, 1);
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('¡Uy! ¡la siguiente semana mas cardio!', 2, 2);
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('Mucha torta el fin de semana jajaja! xD', 3, 2);
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('¡¡Vas mejorando!!', 2, 3);
insert into interaccion_comentario (mensaje, fk_usuario, fk_progreso) values ('¡¡Excelente!!', 3, 3);

insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Simon','123','Simon', 'Esperanza', 'M','01/01/2000','123456789',120,null,'prueba1@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Marvian','123','Marvian', 'Montoya', 'F','01/01/2000','123456789',120,null,'prueba2@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Gilbert','123','Gilbert', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Alejandro','123','Alejandro', 'Esperanza', 'M','01/01/2000','123456789',120,null,'prueba1@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Pedro','123','Pedro', 'Montoya', 'F','01/01/2000','123456789',120,null,'prueba2@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Jorge','123'   ,'Jorge', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Maria','123','Maria', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Alexander','123','Alexander', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Azucena','123','Azucena', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Julia','123','Julia', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Pablo','123','Pablo', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Ana','123','Ana', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');
insert into usuario (usu_usuario,usu_password,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,usu_telefono,usu_estatura,usu_foto,usu_correo) values ('Alejandra','123','Alejandra', 'Gomez', 'M','01/01/2000','123456789',120,null,'prueba3@correo.com');