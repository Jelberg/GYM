

---USUARIO
insert into usuario (usu_cedula,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac) values (25530426,'Minerva', 'Morales', 'F','19/08/1996');

---PLAN
insert into plan (pla_nombre,pla_descripcion,fk_usuario) values ('Plan A','Adelgazar 6kg, Dificultad: Media',1);

---RUTINAS
insert into rutina (rut_nombre,rut_dia,fk_usuario,fk_plan) values ('Piernas','Lunes',1,1);  ---Rutina 1
insert into rutina (rut_nombre,rut_dia,fk_usuario,fk_plan) values ('Biceps','Martes',1,1);  ---Rutina 2

---EQUIPO
insert into equipo (equ_nombre) values ('Disco'); 
insert into equipo (equ_nombre) values ('Barra'); 

---MAQUINA
insert into maquina (maq_nombre) values ('Prensa');

---EJERCICIO
insert into ejercicio (eje_nombre, eje_grupo_muscular) values ('Prensa','cuadriceps');
insert into ejercicio (eje_nombre, eje_grupo_muscular) values ('Curl de Biceps','biceps');

---EJERCICIO_MAQUINA_EQUIPO
insert into ejercicio_maquina_equipo (fk_maquina, fk_ejercicio, fk_equipo, fk_rutina) values(1,1,1,1);--para la rutina 1 usando un disco y la maquina prensa
insert into ejercicio_maquina_equipo (fk_maquina, fk_ejercicio, fk_equipo, fk_rutina) values(null,2,2,2);--para la rutina 2 usando una barra

---TRABAJO_RUTINA
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('06/11/2017',1.5,1,1);--Prensa
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('13/12/2017',3.5,1,1);--Prensa
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('23/10/2018',3.5,1,1);--Prensa
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('14/04/2017',3.5,1,1);--Prensa
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('07/11/2017',1.5,2,2);--Curl de biceps
insert  into trabajo_rutina (tr_fecha,tr_descanso, fk_eje_maq_equ1, fk_eje_maq_equ2) values('16/11/2017',1.5,1,1);--Curl de biceps

---SERIES
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (20, 'kg', 15,1);--06/11/2017
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (30, 'kg', 10,1);
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (40, 'kg', 8,1);

insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (61, 'kg', 20,2);--13/12/2017
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (65, 'kg', 20,2);
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (53, 'kg', 20,2);

insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (100, 'kg', 55,3);--23/10/2018
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (100, 'kg', 55,3);
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (100, 'kg', 55,3);

insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (60, 'kg', 12,4);--14/04/2018
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (70, 'kg', 10,4);
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (80, 'kg', 55,4);

insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (120, 'kg', 23,5);--07/11/2017
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (96, 'kg', 50,5);
insert into serie ( ser_peso, ser_unidad, ser_repeticion,fk_trabajo_rutina) values (50, 'kg', 35,5);

---**************************************************************************************************************


