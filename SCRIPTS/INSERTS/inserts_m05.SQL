
--USUARIO
insert into usuario (usu_id,usu_cedula,usu_nombre,usu_apellido,usu_sexo,usu_fecha_nac,USU_TELEFONO,USU_ESTATURA, USU_FOTO, USU_CORREO) 
values (1,25530426,'jessica', 'elberg', 'F','19/08/1996','123',12,null,'mm@gmail.com');

--INSTRUCTOR
INSERT INTO INSTRUCTOR(INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO) VALUES('Pedro','Alvares','13-12-94','M','fitpedro@gmail.com',null);
INSERT INTO INSTRUCTOR(INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO) VALUES 
('Maria','Cardenas','13-12-94','F','marica@gmail.com',null);

--CLASE
INSERT INTO CLASE(CLA_NOMBRE,CLA_DESCRIPCION) VALUES ('Yoga','yoga master class') ;
INSERT INTO CLASE(CLA_NOMBRE,CLA_DESCRIPCION) VALUES ('TRX','TRX master class') ;
INSERT INTO CLASE(CLA_NOMBRE,CLA_DESCRIPCION) VALUES ('Pilates','Pilates master class') ;

--HORARIO_CLASE
INSERT INTO HORARIO_CLASE(HC_FECHA,HC_DIA
,HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS
,HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES ('12-11-17','LUNES',20,'12:00:00','14:00:00','A',null,null,
(SELECT INS_ID FROM INSTRUCTOR WHERE INS_NOMBRE='Pedro' LIMIT 1),
(SELECT CLA_ID FROM CLASE WHERE CLA_NOMBRE='TRX'LIMIT 1) );

INSERT INTO HORARIO_CLASE(HC_FECHA,HC_DIA
,HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS
,HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES ('12-11-17','LUNES',20,'14:00:00','16:00:00','A',null,(SELECT USU_ID FROM USUARIO LIMIT 1),
(SELECT INS_ID FROM INSTRUCTOR WHERE INS_NOMBRE='Pedro' LIMIT 1),
(SELECT CLA_ID FROM CLASE WHERE CLA_NOMBRE='Pilates'LIMIT 1) );

INSERT INTO HORARIO_CLASE(HC_FECHA,HC_DIA
,HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS
,HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES ('12-11-17','LUNES',20,'16:00:00','18:00:00','A',null,(SELECT USU_ID FROM USUARIO where usu_id= 1 ),
(SELECT INS_ID FROM INSTRUCTOR WHERE INS_NOMBRE='Maria' LIMIT 1),
(SELECT CLA_ID FROM CLASE WHERE CLA_NOMBRE='TRX' LIMIT 1));


--CRITICA       
INSERT INTO CRITICA (CRI_FECHA,CRI_COMENTARIO,CRI_VALORACION,fk_hc_id,cri_id_usuario)VALUES('12-12-12','ESTO ES UNA CRITICA',5,(SELECT HC_ID FROM HORARIO_CLASE LIMIT 1),1);