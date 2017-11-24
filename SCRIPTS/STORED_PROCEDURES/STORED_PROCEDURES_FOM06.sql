--********************Funciones del Web Service***************
--------Esta funcion devuelve todas las reservas de entrenadores que ha hecho un usuario-------
CREATE OR REPLACE FUNCTION fo_m06_get_reserva(id int)
	Returns Table (id_usuario int, nombre_ent character varying,fecha_ini date, fecha_fin date)
	AS $$
DECLARE
	_reservas record;
	BEGIN
	FOR _reservas IN (SELECT usu_id,ent_nombre,res_fecha_ini,res_fecha_fin from Entrenador,Reserva, Usuario where ent_id=fk_entrenador and usu_id=fk_usuario)

	loop
		id_usuario=_reservas.usu_id;
		nombre_ent=_reservas.ent_nombre;
		fecha_ini=_reservas.ent_fecha_ini;
		fecha_fin=_reservas.ent_fecha_fin;
		return next;
	end loop;
	end $$
	LANGUAGE PLPGSQL;
---************Esta funcion permitira agregar una reserva******-------
CREATE OR REPLACE fo_m06_agregar_reserva (res_id integer,res_fecha_ini date,res_fecha_fin date,id_usuario int,id_entrenador int)
RETURNS VOID AS $$
DECLARE
BEGIN
	INSERT INTO reserva(res_id integer,res_fecha_ini date,res_fecha_fin date,id_usuario int,id_entrenador int) 
			values (res_id integer,res_fecha_ini date,res_fecha_fin date,id_usuario int,id_entrenador int);
	END $$;
	LANGUAGE PLPGSQL;


----******************Esta funcion permite eliminar una reserva******-------------
CREATE OR REPLACE FUNCTION fo_m06_eliminar_reserva (reserva_id int)
RETURNS VOID AS $$
DECLARE
BEGIN
	DELETE FROM _reserva
	where reserva_id=res_id;
	end $$
	LANGUAGE PLPGSQL; 


---------------Esta funcion devuelve todos los entrenadores en lista-----------------------
CREATE OR REPLACE FUNCTION fo_m06_get_entrenador (ent_id int)
RETURNS refcursor AS $$
DECLARE ref refcursor;
	BEGIN
		OPEN ref FOR 
			SELECT ent_nombre, ent_correo
			FROM ENTRENADOR;
		RETURN ref;
	END
	$$ LANGUAGE PLPGSQL;


-----------Esta funcion asigna una relacion usuario entrenador------------------

CREATE OR REPLACE FUNCTION f0_mo6_set_rutina (usu_id int, ent_id int)
RETURNS VOID AS $$
DECLARE
BEGIN
	INSERT INTO reserva(fk_usuario,fk_entrenador) 
			values (usu_id,end_id);
	END $$
	LANGUAGE PLPGSQL;


---------------Esta funcion devuelve todas las rutinas de un usuario---------
CREATE OR REPLACE FUNCTION fo_m06_get_rutina_usuario (rut_id int)
RETURNS refcursor AS $$
DECLARE ref refcursor;
	BEGIN
		OPEN ref FOR 
			SELECT R.rut_nombre, R.rut_dia
			FROM RUTINA R, ENTRENADOR E, USUARIO U
			WHERE E.ent_id = R.fk_entrenador AND U.usu_id = r.fk_usuario;
		RETURN ref;
	END
	$$ LANGUAGE PLPGSQL;


-----------Esta funcion muestra el progreso del usuario------------
CREATE OR REPLACE FUNCTION fo_m06_get_progreso_usuario (rut_id int)
RETURNS refcursor AS $$
DECLARE ref refcursor;
	BEGIN
		OPEN ref FOR 
			SELECT PR.progreso, PR.evaluacion
			FROM RUTINA R, ENTRENADOR E, USUARIO U, PROGRESO_RUTINA PR
			WHERE (E.ent_id = R.fk_entrenador AND U.usu_id = r.fk_usuario) AND PR.fk_rutina = R.rut_id;
		RETURN ref;
	END
	$$ LANGUAGE PLPGSQL;