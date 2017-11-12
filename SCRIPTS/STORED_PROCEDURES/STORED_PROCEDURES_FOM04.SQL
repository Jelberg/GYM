--Este solo devuelve las medidas de ese usuario en esa fecha.
CREATE OR REPLACE FUNCTION fo_m04_get_progresoM(usuario_CI int, fecha DATE)
  RETURNS TABLE(medida INT, tipo character varying)
   AS $$
DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT pm_medida, med_tipo
        FROM usuario inner join  progreso_medida on usu_id = fk_usuario inner join medida on fk_medida = med_id
        WHERE usu_cedula = usuario_CI AND pm_fecha = fecha)
   LOOP
    medida = var_r.pm_medida;
    tipo = var_r.med_tipo;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;


--Este elimina las medidas correspondientes a esa fecha y a ese usuario
CREATE OR REPLACE FUNCTION fo_m04_elimina_medidas (usuario_CI int, fecha DATE)
	RETURNS void AS $$
    DECLARE
    BEGIN
        DELETE FROM progreso_medida
        WHERE pm_fecha = fecha and fk_usuario = usuario_CI;
    END; $$
LANGUAGE plpgsql;

-- INSERTA MEDIDAS PERTENECIENTE A ESE USUARIO EN LA FECHA ACTUAL
CREATE OR REPLACE FUNCTION fo_m04_inserta_medidas(
    fk_usuario INT,
    medida INT,
    tipo INT,
    fecha DATE)
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

--Falta la consulta de las medidas durante un ano

-- Este devuelve los comentarios pertenencientes a ese progreso
--CREATE OR REPLACE FUNCTION fo_m04_get_comentariopromed( pm_id int)

--FUNCION QUE ACTUALZA MEDIDA DADOS: EL ID DEL USUARIO, FECHA DE EL PROGRESO, TIPO DE LA MEDIDA Y LA NUEVA MEDIDA.
CREATE OR REPLACE FUNCTION fo_m04_act_medida(id_usuario INTEGER, fecha DATE, tipo_medida VARCHAR, medida INTEGER)
  RETURNS void
   AS $$
DECLARE
    id_medida int;
BEGIN
    id_medida := ( SELECT MED_ID FROM MEDIDA WHERE MED_TIPO = tipo_medida );
    UPDATE PROGRESO_MEDIDA SET  PM_MEDIDA = medida
    WHERE PM_FECHA = fecha and FK_USUARIO = id_usuario and FK_MEDIDA = id_medida;
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