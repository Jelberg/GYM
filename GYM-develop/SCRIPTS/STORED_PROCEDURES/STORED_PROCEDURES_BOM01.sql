--- BACKOFFICE M01----
----------------------


--- Eliminar EQUIPO

CREATE OR REPLACE FUNCTION public.bo_m01_eliminar_equipo(
	id integer)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

    DECLARE
    BEGIN
        DELETE FROM EQUIPO
        WHERE EQU_ID = id;
    END; 
$BODY$;

ALTER FUNCTION public.bo_m01_eliminar_equipo(integer)
    OWNER TO gymucab;


--- ELIMINAR MAQUINA 

CREATE OR REPLACE FUNCTION public.bo_m01_eliminar_maquina(
	id integer)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

    DECLARE
    BEGIN
        DELETE FROM MAQUINA
        WHERE MAQ_ID = id;
    END; 
$BODY$;

ALTER FUNCTION public.bo_m01_eliminar_maquina(integer)
    OWNER TO gymucab;


--- OBTENER EJERCICIO POR ID

CREATE OR REPLACE FUNCTION public.bo_m01_get_ejercicio_maquina(
	_id integer)
    RETURNS TABLE(fk_eje integer, nombre character varying, grupo character varying, fk_maq integer, fk_equ integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
   var_r    record;
   var_i    record;
BEGIN
    FOR var_i IN(SELECT FK_MAQUINA, FK_EJERCICIO, FK_EQUIPO 
    FROM EJERCICIO_MAQUINA_EQUIPO 
    WHERE EME_ID = _id)
    LOOP 
    fk_maq = var_i.FK_MAQUINA;
    fk_eje = var_i.FK_EJERCICIO;
    fk_equ = var_i.FK_EQUIPO;
    RETURN NEXT;
    END LOOP;

    FOR var_r IN(SELECT EJE_NOMBRE,EJE_GRUPO_MUSCULAR 
    FROM EJERCICIO 
    WHERE EJE_ID = fk_eje)
    LOOP
    nombre = var_r.EJE_NOMBRE;
    grupo = var_r.EJE_GRUPO_MUSCULAR;
    RETURN NEXT;
    END LOOP;
END; 
$BODY$;

ALTER FUNCTION public.bo_m01_get_ejercicio_maquina(integer)
    OWNER TO gymucab;


---- OBTENER EQUIPO POR ID

CREATE OR REPLACE FUNCTION public.bo_m01_get_equipo(
	_id integer)
    RETURNS TABLE(id integer, nombre character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT EQU_ID,EQU_NOMBRE
        FROM EQUIPO
        WHERE EQU_ID = _id)
   LOOP
    id = var_r.EQU_ID;
    nombre = var_r.EQU_NOMBRE;
    RETURN NEXT;
   END LOOP;
END; 
$BODY$;

ALTER FUNCTION public.bo_m01_get_equipo(integer)
    OWNER TO postgres;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_equipo(integer) TO gymucab WITH GRANT OPTION;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_equipo(integer) TO PUBLIC;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_equipo(integer) TO postgres;


--- OBTENER MAQUINA POR ID

CREATE OR REPLACE FUNCTION public.bo_m01_get_maquina(
	_id integer)
    RETURNS TABLE(id integer, nombre character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
   var_r    record;
BEGIN
   FOR var_r IN(SELECT MAQ_ID,MAQ_NOMBRE
        FROM MAQUINA
        WHERE MAQ_ID = _id)
   LOOP
    id = var_r.MAQ_ID;
    nombre = var_r.MAQ_NOMBRE;
    RETURN NEXT;
   END LOOP;
END; 
$BODY$;

ALTER FUNCTION public.bo_m01_get_maquina(integer)
    OWNER TO postgres;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_maquina(integer) TO gymucab WITH GRANT OPTION;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_maquina(integer) TO PUBLIC;

GRANT EXECUTE ON FUNCTION public.bo_m01_get_maquina(integer) TO postgres;


---- OBTENER TODOS LOS EJERCICIOS

CREATE OR REPLACE FUNCTION public.bo_m01_getallexercices(
	)
    RETURNS TABLE(id integer, ejercicio character varying, equipamiento character varying, grupo_muscular character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
   var_r    record;
BEGIN 
    FOR var_r IN(select eme_id, maq_nombre as nombre, eje_nombre, eje_grupo_muscular
from 
	ejercicio_maquina_equipo as eme,
    maquina as maq,
    ejercicio as eje
where
	maq.maq_id = eme.fk_maquina and
    eme.fk_ejercicio = eje.eje_id

UNION ALL

select 
    eme_id,	equ_nombre as nombre,eje_nombre,eje_grupo_muscular
from 
	ejercicio_maquina_equipo as eme,
    equipo as equ,
    ejercicio as eje
where
	equ.equ_id = eme.fk_equipo and
    eme.fk_ejercicio = eje.eje_id)
   LOOP
    id = var_r.eme_id;
    Ejercicio = var_r.eje_nombre;
    Equipamiento = var_r.nombre;
    Grupo_muscular = var_r.eje_grupo_muscular;
    RETURN NEXT;
   END LOOP;        
END; 

$BODY$;

ALTER FUNCTION public.bo_m01_getallexercices()
    OWNER TO gymucab;


---- INSERTA EJERCICIO


CREATE OR REPLACE FUNCTION public.bo_m01_insertar_ejercicio(
	nombre character varying,
	grupo character varying,
	maquina integer,
	equipo integer)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE 
BEGIN 
  INSERT INTO EJERCICIO(EJE_NOMBRE,EJE_GRUPO_MUSCULAR) VALUES (nombre,grupo);

  SELECT EJE_ID as ejeId, EJE_NOMBRE as ejeNombre, EJE_GRUPO_MUSCULAR as ejeGrupo FROM EJERCICIO 
  WHERE ejeNombre = nombre and
        ejeGrupo  = grupo; 

INSERT INTO EJERCICIO_MAQUINA_EQUIPO(FK_MAQUINA,FK_EJERCICIO,FK_EQUIPO,FK_RUTINA,EME_TIPO) VALUES(maquina,ejeId,equipo,null,false); 

END 

$BODY$;

ALTER FUNCTION public.bo_m01_insertar_ejercicio(character varying, character varying, integer, integer)
    OWNER TO gymucab;



---- INSERTA EJERCICIO CON EQUIPO

CREATE OR REPLACE FUNCTION public.bo_m01_insertar_ejercicio_equipo(
	nombre character varying,
	grupo character varying,
	equipo integer)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE
  var_r    record;
  ejeId    integer; 
BEGIN 
  INSERT INTO EJERCICIO(EJE_NOMBRE,EJE_GRUPO_MUSCULAR) VALUES (nombre,grupo);

  FOR var_r in (SELECT EJE_ID FROM EJERCICIO 
  WHERE EJE_NOMBRE = nombre and
        EJE_GRUPO_MUSCULAR  = grupo)
   LOOP
    ejeId = var_r.EJE_ID;
   END LOOP;  

INSERT INTO EJERCICIO_MAQUINA_EQUIPO(FK_MAQUINA,FK_EJERCICIO,FK_EQUIPO,FK_RUTINA,EME_TIPO) VALUES(null,ejeId,equipo,null,false); 

END 
$BODY$;

ALTER FUNCTION public.bo_m01_insertar_ejercicio_equipo(character varying, character varying, integer)
    OWNER TO postgres;

GRANT EXECUTE ON FUNCTION public.bo_m01_insertar_ejercicio_equipo(character varying, character varying, integer) TO gymucab WITH GRANT OPTION;

GRANT EXECUTE ON FUNCTION public.bo_m01_insertar_ejercicio_equipo(character varying, character varying, integer) TO PUBLIC;

GRANT EXECUTE ON FUNCTION public.bo_m01_insertar_ejercicio_equipo(character varying, character varying, integer) TO postgres;


---- INSERTA EJERCICIO CON MAQUINA
CREATE OR REPLACE FUNCTION public.bo_m01_insertar_ejercicio_maquina(
	nombre character varying,
	grupo character varying,
	maquina integer)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE
  var_r    record; 
  ejeId    integer;
BEGIN 
  INSERT INTO EJERCICIO(EJE_NOMBRE,EJE_GRUPO_MUSCULAR) VALUES (nombre,grupo);

  FOR var_r in (SELECT EJE_ID FROM EJERCICIO 
  WHERE EJE_NOMBRE = nombre and
        EJE_GRUPO_MUSCULAR  = grupo)
   LOOP
    ejeId = var_r.EJE_ID;
   END LOOP;  

INSERT INTO EJERCICIO_MAQUINA_EQUIPO(FK_MAQUINA,FK_EJERCICIO,FK_EQUIPO,FK_RUTINA,EME_TIPO) VALUES(maquina,ejeId,null,null,false); 

END 
$BODY$;

ALTER FUNCTION public.bo_m01_insertar_ejercicio_maquina(character varying, character varying, integer)
    OWNER TO gymucab;


---- INSERTA EQUIPO

CREATE OR REPLACE FUNCTION public.bo_m01_insertar_equipo(
	nombre character varying)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE 
BEGIN 
	
  INSERT INTO EQUIPO(EQU_NOMBRE) VALUES (nombre) ;
END 
$BODY$;

ALTER FUNCTION public.bo_m01_insertar_equipo(character varying)
    OWNER TO gymucab;



--- INSERTA MAQUINA

CREATE OR REPLACE FUNCTION public.bo_m01_insertar_maquina(
	nombre character varying)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE 
BEGIN 
	
  INSERT INTO MAQUINA(MAQ_NOMBRE) VALUES (nombre) ;
END 
$BODY$;

ALTER FUNCTION public.bo_m01_insertar_maquina(character varying)
    OWNER TO gymucab;


---- MODIFICAR EQUIPO
CREATE OR REPLACE FUNCTION public.bo_m01_modificar_equipo(
	id integer,
	nombre character varying)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

    DECLARE
    BEGIN
        UPDATE EQUIPO SET EQU_NOMBRE = nombre WHERE EQU_ID = id;
    END; 
$BODY$;

ALTER FUNCTION public.bo_m01_modificar_equipo(integer, character varying)
    OWNER TO gymucab;


---- MODIFICAR MAQUINA

CREATE OR REPLACE FUNCTION public.bo_m01_modificar_maquina(
	id integer,
	nombre character varying)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

    DECLARE
    BEGIN
        UPDATE MAQUINA SET MAQ_NOMBRE = nombre WHERE MAQ_ID = id;
    END; 
$BODY$;

ALTER FUNCTION public.bo_m01_modificar_maquina(integer, character varying)
    OWNER TO gymucab;
	

---- OBTENER TODOS LOS EQUIPOS

CREATE OR REPLACE FUNCTION public.bo_m01_getallequipments()
    RETURNS TABLE(id integer, nombre character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
   var_r    record;
BEGIN 
    FOR var_r IN(select equ_id, equ_nombre
from 
	equipo)
   LOOP
    id = var_r.equ_id;
    nombre = var_r.equ_nombre;
    RETURN NEXT;
   END LOOP;        
END; 

$BODY$;

ALTER FUNCTION public.bo_m01_getallequipments()
    OWNER TO gymucab;	