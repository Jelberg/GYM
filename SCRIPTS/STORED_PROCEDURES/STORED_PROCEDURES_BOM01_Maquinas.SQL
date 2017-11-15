---Maquina---

---Insert Maquina---
CREATE OR REPLACE FUNCTION bo_m01_insertar_maquina(nombre character varying)
RETURNS VOID AS $$
DECLARE 
BEGIN 
	
  INSERT INTO MAQUINA(MAQ_NOMBRE) VALUES (nombre) ;
END $$
  LANGUAGE plpgsql;

---Update Maquina---
CREATE OR REPLACE FUNCTION bo_m01_modificar_maquina(id int,nombre character varying)
	RETURNS void AS $$
    DECLARE
    BEGIN
        UPDATE MAQUINA SET MAQ_NOMBRE = nombre WHERE MAQ_ID = id;
    END; $$
LANGUAGE plpgsql;

---Delete Equipo---
CREATE OR REPLACE FUNCTION bo_m01_eliminar_maquina(id int)
	RETURNS void AS $$
    DECLARE
    BEGIN
        DELETE FROM MAQUINA
        WHERE MAQ_ID = id;
    END; $$
LANGUAGE plpgsql;