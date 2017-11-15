--Este solo devuelve las medidas de ese usuario en esa fecha.
CREATE OR REPLACE FUNCTION fo_m04_get_progresoM(usuario_id int)
  RETURNS TABLE(medida INT, tipo character varying, fecha date)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT pm_medida, med_tipo, pm_fecha
        FROM usuario inner join  progreso_medida on usu_id = fk_usuario inner join medida on fk_medida = med_id
        WHERE usu_id = usuario_id
	order by pm_fecha DESC limit 6 )
   LOOP
    medida = var_r.pm_medida;
    tipo = var_r.med_tipo;
    fecha = var_r.pm_fecha;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;


--Este elimina las medidas correspondientes a esa fecha y a ese usuario
CREATE OR REPLACE FUNCTION fo_m04_elimina_medidas (usuario_id int, tipo_medida int)
	RETURNS void AS $$
    DECLARE
    id_medida int;
    fecha_actual DATE;
    BEGIN
	id_medida := ( SELECT MED_ID FROM MEDIDA WHERE MED_TIPO = tipo_medida AND EXTRACT(MONTH 	   fecha_actual) = ( SELECT EXTRACT(MONTH PM_FECHA) FROM MEDIDA  WHERE tipo_medida = 			tipo_medida) );
        DELETE FROM progreso_medida
        WHERE med_id = id_medida and fk_usuario = usu_id;
    END; $$
LANGUAGE plpgsql;

-- INSERTA MEDIDAS PERTENECIENTE A ESE USUARIO EN LA FECHA ACTUAL
CREATE OR REPLACE FUNCTION fo_m04_inserta_medidas(
    fk_usuario INT,
    medida INT,
    tipo INT)
  RETURNS void
   AS $$
    DECLARE
	fecha_actual DATE;
    BEGIN
	fecha_actual  := current_date;
        INSERT INTO progreso_medida (pm_medida,pm_fecha, fk_usuario, fk_medida) VALUES
        ( medida , fecha_actual , fk_usuario , tipo );
    END; $$
  LANGUAGE plpgsql;



--FUNCION QUE ACTUALZA MEDIDA DADOS: EL ID DEL USUARIO, FECHA DE EL PROGRESO, TIPO DE LA MEDIDA Y LA NUEVA MEDIDA.
CREATE OR REPLACE FUNCTION fo_m04_act_medida(id_usuario INTEGER, medida INTEGER, tipo_medida VARCHAR)
  RETURNS void
   AS $$
DECLARE
    id_medida int;
    fecha_actual DATE;
BEGIN
    id_medida := ( SELECT MED_ID FROM MEDIDA WHERE MED_TIPO = tipo_medida AND EXTRACT(MONTH fecha_actual) = ( SELECT EXTRACT(MONTH PM_FECHA) FROM MEDIDA  WHERE tipo_medida = tipo_medida) );
    UPDATE PROGRESO_MEDIDA SET  PM_MEDIDA = medida
    WHERE FK_USUARIO = id_usuario and FK_MEDIDA = id_medida)
END; $$
  LANGUAGE plpgsql;

--FUNCION QUE OBTIENE LOS ULTIMOS REGISTROS DEL PROGRESO DE UN USUARIO CON RESPECTO A SU PESO.
CREATE OR REPLACE FUNCTION fo_m04_get_progresop(id_usuario int)
  RETURNS TABLE(peso INT, fecha DATE, id INT)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT pp_peso, pp_fecha, pp_id
        FROM progreso_peso 
        WHERE fk_usuario = id_usuario 
        order by pp_fecha DESC limit 6)
   LOOP
    peso = var_r.pp_peso;
    fecha = var_r.pp_fecha;
    id = var_r.pp_id;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;

--FUNCION QUE INSERTA PROGRESO DE PESO DEL USUARIO, RECIBE EL ID DEL USUARIO Y EL PESO A REGISTRAR.
CREATE OR REPLACE FUNCTION fo_m04_insert_progresop(id_usuario int, peso int)
  RETURNS void	
   AS $$
DECLARE
   fecha_actual	date;
BEGIN
	fecha_actual := current_date;
	INSERT INTO PROGRESO_PESO ( PP_PESO, FK_USUARIO, PP_FECHA ) VALUES
	( peso, id_usuario, fecha_actual );
END; $$
  LANGUAGE plpgsql;
--FUNCION QUE ELIMINA EL REGISTRO DE PESO DE UN USUARIO, RECIBE EL ID DEL USUARIO Y LA FECHA DEL REGISTRO.
CREATE OR REPLACE FUNCTION fo_m04_elimina_progresop(id_usuario int, fecha date)
  RETURNS void	
   AS $$
BEGIN
	DELETE FROM PROGRESO_PESO
	WHERE FK_USUARIO = id_usuario and PP_FECHA = fecha;
END; $$
  LANGUAGE plpgsql;
--FUNCION QUE ACTUALIZA EL REGISTRO DE PESO DE UN USUARIO, RECIBE EL ID DEL USUARIO, LA FECHA DEL REGISTRO Y EL NUEVO PESO.
CREATE OR REPLACE FUNCTION fo_m04_act_progresop(id_usuario int, fecha date, peso int)
  RETURNS void	
   AS $$
BEGIN
	UPDATE PROGRESO_PESO
	SET PP_PESO = peso
	WHERE FK_USUARIO = id_usuario AND PP_FECHA = fecha;
END; $$
  LANGUAGE plpgsql;


--FUNCION QUE INSERTA LOS COMENTARIOS DE UN PROGRESO DEL USUARIO, RECIBE EL ID DEL USUARIO, EL PROGRESO.
CREATE OR REPLACE FUNCTION fo_m04_inserta_comentario(id_usuariopro int, id_usuariocom int, con_mensaje varchar,  pm_id int, pp_id int)
  RETURNS void	
   AS $$
DECLARE
   fecha_actual	date;
BEGIN
	fecha_actual := current_date;
	INSERT INTO COMENTARIO ( com_mensaje, fk_usuariopro, fk_pro_peso, fk_pro_medida, fk_usuariocom, com_fecha  ) VALUES
	( con_mesaje, id_usuariopro, pp_id, pm_id, id_usuariocom, fecha_actual);
END; $$
  LANGUAGE plpgsql;

--Este solo devuelve los comentario de ese pogreso peso.
CREATE OR REPLACE FUNCTION fo_m04_get_comentarioprop(usuario_id int, fk_pro_peso int)
  RETURNS TABLE(com_mensaje varchar, usu_nombre varchar)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT com_mensaje, A.usu_nombre
        FROM usuario inner join  comentario on usu_id = fk_usuariopro inner join A.usuario on A.usu_id = fk_usuariocom

        WHERE usu_id = usuario_id  and fk_pro_peso = fk_pro_peso 
	order by pm_fecha DESC limit 10 )
   LOOP
    com_mensaje = var_r.com_mensaje;
    usu_nombre = var_r.A.usu_nombre;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;

--Este solo devuelve los comentario de ese pogreso medida.
CREATE OR REPLACE FUNCTION fo_m04_get_comentarioprom(usuario_id int, fk_pro_medida int)
  RETURNS TABLE(com_mensaje varchar, usu_nombre varchar)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT com_mensaje, A.usu_nombre
        FROM usuario inner join  comentario on usu_id = fk_usuariopro inner join A.usuario on A.usu_id = fk_usuariocom

        WHERE usu_id = usuario_id and fk_pro_medidas = fk_pro_medida
	order by pm_fecha DESC limit 10 )
   LOOP
    com_mensaje = var_r.com_mensaje;
    usu_nombre = var_r.A.usu_nombre;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;

--Este devuelve todos los progresos compartidos de un usuario.
CREATE OR REPLACE FUNCTION fo_m04_get_progresoscompartidos(usuario_id int)
  RETURNS TABLE(mensaje varchar, nombre_usuario varchar, fecha varchar)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT com.com_mensaje, usu.usu_nombre, com.com_fecha 
   FROM comentario as com inner join usuario as usu on usu.usu_id = usuario_id and
						com.fk_usuariopro = usu.usu_id
	order by com.com_fecha DESC limit 10)
   LOOP
    mensaje = var_r.com_mensaje;
    nombre_usuario = var_r.usu_nombre;
    fecha = var_r.com_fecha;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;
