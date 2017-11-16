---Ejercicio_Maquina_Equipo---

---Ejercicio_Maquina_Equipo---
CREATE OR REPLACE FUNCTION bo_m01_insertar_ejercicio(nombre character varying, grupo character varying, maquina int, equipo int)
RETURNS VOID AS $$
DECLARE 
BEGIN 
  INSERT INTO EJERCICIO(EJE_NOMBRE,EJE_GRUPO_MUSCULAR) VALUES (nombre,grupo);

  SELECT EJE_ID as ejeId, EJE_NOMBRE as ejeNombre, EJE_GRUPO_MUSCULAR as ejeGrupo FROM EJERCICIO 
  WHERE ejeNombre = nombre and
        ejeGrupo  = gurpo; 

INSERT INTO EJERCICIO_MAQUINA_EQUIPO(FK_MAQUINA,FK_EJERCICIO,FK_EQUIPO,FK_RUTINA,EME_TIPO) VALUES(maquina,ejeId,equipo,null,false); 

END $$
  LANGUAGE plpgsql;