---Ejercicio---

---Insert Ejercicio---
CREATE OR REPLACE FUNCTION bo_m01_insertar_ejercicio(nombre character varying, grupo character varying[])
RETURNS VOID AS $$
DECLARE 
BEGIN 
	
  INSERT INTO EJERCICIO(EJE_NOMBRE,EJE_GRUPO_MUSCULAR) VALUES (nombre,grupo) ;
END $$
  LANGUAGE plpgsql;

---Update Ejercicio---
CREATE OR REPLACE FUNCTION bo_m01_modificar_ejercicio(id int,nombre character varying,grupo character varying[])
	RETURNS void AS $$
    DECLARE
    BEGIN
        UPDATE EJERCICIO SET EJE_NOMBRE = nombre,EJE_GRUPO_MUSCULAR = grupo WHERE EJE_ID = id;
    END; $$
LANGUAGE plpgsql;

---Delete Ejercicio---
CREATE OR REPLACE FUNCTION bo_m01_eliminar_ejercicio(id int)
	RETURNS void AS $$
    DECLARE
    BEGIN
        DELETE FROM EJERCICIO
        WHERE EJE_ID = id;
    END; $$
LANGUAGE plpgsql;