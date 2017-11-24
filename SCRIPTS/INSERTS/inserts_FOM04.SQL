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