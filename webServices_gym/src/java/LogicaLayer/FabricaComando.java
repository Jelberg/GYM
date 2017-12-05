/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.Progreso_Medida;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.FOM04.AgregarComentarioComando;
import LogicaLayer.FOM04.AgregarMedidaComando;
import LogicaLayer.FOM04.AgregarPesoComando;
import LogicaLayer.FOM04.CompartirProgresoComando;
import LogicaLayer.FOM04.ConsultarProgresoMedidasComando;
import LogicaLayer.FOM04.ModificarMedidasComando;
import LogicaLayer.FOM04.ModificarPesoComando;

/**
 *
 * @author Elberg
 */
public abstract class FabricaComando {
    
    public abstract AgregarComentarioComando instanciaCmdAgregarComentario(Comentario comentario);
    public abstract AgregarMedidaComando instanciaCmdAgregarMedida(Progreso_Medida progresoMedida);
    public abstract AgregarPesoComando instanciaCmdAgregarPeso(Progreso_Peso progresoPeso);
    public abstract CompartirProgresoComando instanciaCmdCompartirProgreso();
    public abstract ConsultarProgresoMedidasComando instanciaCmdConsultarProgresoMedidas(Progreso_Medida progresoMedida);
    public abstract ModificarMedidasComando instanciaCmdModificarMedidas(Progreso_Medida progresoMedida);
    public abstract ModificarPesoComando instanciaCmdModificarPeso(Progreso_Peso progresoPeso);
    
}
