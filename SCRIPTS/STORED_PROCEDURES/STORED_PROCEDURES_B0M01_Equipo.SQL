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
   FOR var_r IN(SELECT EQU_NOMBRE
        FROM EQUIPO
        WHERE EQU_ID = _id)
   LOOP
    id = var_r.EQU_ID;
    nombre = var_r.EQU_NOMBRE;
    RETURN NEXT;
   END LOOP;
END; $$
  LANGUAGE plpgsql;
