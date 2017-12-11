---Equipo---

---Insert Equipo---
CREATE OR REPLACE FUNCTION bo_m01_insertar_equipo(nombre character varying)
RETURNS VOID AS $$
DECLARE 
BEGIN 
	
  INSERT INTO EQUIPO(EQU_NOMBRE) VALUES (nombre) ;
END $$
  LANGUAGE plpgsql;

---Update Equipo---
CREATE OR REPLACE FUNCTION bo_m01_modificar_equipo(id int,nombre character varying)
	RETURNS void AS $$
    DECLARE
    BEGIN
        UPDATE EQUIPO SET EQU_NOMBRE = nombre WHERE EQU_ID = id;
    END; $$
LANGUAGE plpgsql;

---Delete Equipo---
CREATE OR REPLACE FUNCTION bo_m01_eliminar_equipo(id int)
	RETURNS void AS $$
    DECLARE
    BEGIN
        DELETE FROM EQUIPO
        WHERE EQU_ID = id;
    END; $$
LANGUAGE plpgsql;

---Retornar Equipo---
  CREATE OR REPLACE FUNCTION bo_m01_get_equipo(_id int)
  RETURNS TABLE(id int,nombre character varying)
   AS $$
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
END; $$
  LANGUAGE plpgsql;

---Consulta compleja---
CREATE OR REPLACE FUNCTION bo_m01_getAllExercices()
RETURNS TABLE(Id int, maquina_id int, equipo_id int, Ejercicio character varying, Equipamiento character varying, Grupo_muscular character varying)
AS $$
DECLARE
   var_r    record;
BEGIN 
    FOR var_r IN(select 
        maq_nombre as nombre,eje_nombre,eje_grupo_muscular,eme_id, eme.fk_equipo, eme.fk_maquina
    from 
        ejercicio_maquina_equipo as eme,
        maquina as maq,
        ejercicio as eje
    where
        maq.maq_id = eme.fk_maquina and
        eme.fk_ejercicio = eje.eje_id

    UNION ALL

    select 
        equ_nombre as nombre,eje_nombre,eje_grupo_muscular,eme_id, eme.fk_equipo, eme.fk_maquina
    from 
        ejercicio_maquina_equipo as eme,
        equipo as equ,
        ejercicio as eje
    where
        equ.equ_id = eme.fk_equipo and
        eme.fk_ejercicio = eje.eje_id)
   LOOP
    id = var_r.eme_id;
    maquina_id = var_r.eme.fk_maquina;
    equipo_id = var_r.eme.fk_equipo;
    Ejercicio = var_r.eje_nombre;
    Equipamiento = var_r.nombre;
    Grupo_muscular = var_r.eje_grupo_muscular;
    RETURN NEXT;
   END LOOP;        
END; $$
  LANGUAGE plpgsql;
