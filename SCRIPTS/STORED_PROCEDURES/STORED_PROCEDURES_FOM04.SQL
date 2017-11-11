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


