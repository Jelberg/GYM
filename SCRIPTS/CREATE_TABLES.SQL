CREATE USER gymucab PASSWORD 'gymucab';
ALTER ROLE gymucab WITH SUPERUSER;
CREATE DATABASE GIMNASIOBD WITH OWNER gymucab;

create table usuario( 
usu_id  		serial ,
usu_cedula  		integer not null,
usu_nombre  		varchar(10) not null,
usu_apellido 		varchar(10) not null,
usu_sexo 		char not null,
usu_fecha_nac 		Date not null,
CONSTRAINT pk_usu_id PRIMARY KEY (usu_id)
);

-- TABLAS FOM05
CREATE TABLE instructor
(
  ins_id 		serial NOT NULL,
  ins_nombre 		character varying(10) NOT NULL,
  ins_apellido 		character varying(10) NOT NULL,
  ins_fecha_nac 	date NOT NULL,
  ins_sexo 		character(1) NOT NULL,
  ins_correo 		character varying(20) NOT NULL,
  ins_foto 		bytea,
  CONSTRAINT instructor_pkey PRIMARY KEY (ins_id) 
);

CREATE TABLE clase
(
  cla_id 		serial NOT NULL,
  cla_nombre 		character varying(10) NOT NULL,
  cla_descripcion 	character varying(300) NOT NULL,
  CONSTRAINT clase_pkey PRIMARY KEY (cla_id) 
);


CREATE TABLE horario_clase(
hc_id  			serial not null,
hc_fecha 		date not null,
hc_capacidad 		integer  not null,
hc_hora_inicio 	time not null,
hc_hora_fin 		time not null,
hc_duracion		integer,
fk_usuario		integer,
pk_instructor		integer,
pk_clase		integer,
CONSTRAINT fk_usuario  FOREIGN KEY(fk_usuario) REFERENCES usuario(usu_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT pk_instructor  FOREIGN KEY(pk_instructor) REFERENCES instructor(ins_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT pk_clase_usuario  FOREIGN KEY(pk_clase) REFERENCES clase(cla_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT pk_hc_id PRIMARY KEY (hc_id,pk_instructor,pk_clase) 
);

-- FIN TABLAS FOM05


-- TABLAS DE FO_M04

CREATE TABLE MEDIDA(
	med_id		serial  not null,
	med_tipo	varchar(20) unique not null
CONSTRAINT pk_med_id PRIMARY KEY (med_id)

);

CREATE TABLE PROGRESO_MEDIDA(
	pm_id		serial not null,
	pm_medida	integer,
	pm_fecha	date not null,
	pk_usuario	integer,
	pk_medida	integer,
CONSTRAINT pk_pm_id PRIMARY KEY (pm_id),
CONSTRAINT fk_usuario  FOREIGN KEY(fk_usuario) REFERENCES usuario(usu_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_medida  FOREIGN KEY(fk_medida REFERENCES medida(med_id) ON DELETE CASCADE ON UPDATE CASCADE,	

);

CREATE TABLE PROGRESO_PESO(
	pp_id		serial not null,
	pp_peso		integer,	
	pp_fecha	date not null,
CONSTRAINT pk_pp_id PRIMARY KEY (pp_id),
CONSTRAINT fk_usuario  FOREIGN KEY(fk_usuario) REFERENCES usuario(usu_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE COMENTARIO(
	com_id		serial not null;
	com_mensaje	varchar(80),
CONSTRAINT pk_com_id PRIMARY KEY (com_id),
CONSTRAINT fk_usuario  FOREIGN KEY(fk_usuario) REFERENCES usuario(usu_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_pro_peso  FOREIGN KEY(fk_pro_peso) REFERENCES progreso_peso(pp_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_pro_medida FOREIGN KEY(fk_pro_medida) REFERENCES progreso_medida(pm_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- FIN DE F0_M04





