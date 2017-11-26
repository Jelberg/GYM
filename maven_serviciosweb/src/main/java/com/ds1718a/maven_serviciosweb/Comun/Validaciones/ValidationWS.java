package com.ds1718a.maven_serviciosweb.Comun.Validaciones;



import Excepciones.ParameterNullException;

import java.util.Map;

public class ValidationWS {

    public static void validarParametrosNotNull(Map<String, Object> parametros) throws ParameterNullException{
        for (Map.Entry<String, Object> entry : parametros.entrySet()){
            if (entry.getValue() == null){
                throw new ParameterNullException(entry.getKey());
            }
        }

    }
}
