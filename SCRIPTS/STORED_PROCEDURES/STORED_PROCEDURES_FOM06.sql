--********************Funciones del Web Service***************
--------Esta funcion devuelve todas las reservas de entrenadores que ha hecho un usuario-------
CREATE OR REPLACE FUNCTION fo_m06_get_reserva (usu_id int)
	Returns Table (nombre_ent character varying,fecha_ini date, fecha_fin date)
	AS $$
DECLARE
	_reservas record;
	BEGIN
	FOR _reservas IN (SELECT ent_nombre,res_fecha_ini,ent_fecha_fin from Entrenador,Reserva
			where ent_id=fk_entrenador and usu_id=fk_usuario)

	loop
		nombre_ent:=_reserva.ent_nombre;
		fecha_ini:=_reserva.ent_fecha_ini;
		fecha_fin:=_reserva.ent_fecha_fin;
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
	end$$
	LANGUAGE PLPGSQL; 



---------------Esta funcion devuelve todos los entrenadores en lista-----------------------
CREATE OR REPLACE FUNCTION fo_m06_get_entrenador (ent_id int)
RETURNS refcursor AS $$
DECLARE ref refcursor;
BEGIN
	OPEN ref FOR 
			SELECT ent_nombre AS Nombre, ent_correo AS Email
			FROM ENTRENADOR 
	RETURN ref;
END;
$$ LANGUAGE PLPGSQL;