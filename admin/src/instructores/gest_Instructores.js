src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/Instruct";
var correo_busqueda= document.getElementById("text_correo");
var boton= document.getElementById("boton_consulta");
var variable;

window.onload = function busquedainstructor()
{
    variable=localStorage.getItem("id");
    console.log("llego esto="+variable);
    if (variable!="")
    {
        var url_comple="/getInstruct?correo="+variable;
        fetch(url+url_comple)
        .then((respuesta) => 
        {            
            return respuesta.json();
        } ).then((respuesta) => 
        {
               
            var fila= respuesta[0];
            var campos = Object.keys(fila);
            var ncampos =campos.length;
            var nregistros = respuesta.length;
            for(var i = 0; i< nregistros; i++)
            {
                fila =respuesta[i];
                for (var j = 0; j < ncampos; j++)
                {
                    if (j!=0)
                    {
                        console.log(fila[campos[j]]);
                        switch(j) {
                            case 1:
                            document.getElementById('nombre').value = fila[campos[j]] +" "+fila[campos[j+1]];
                            break;
                            case 3:
                            document.getElementById('fecha').value = fila[campos[j]];
                            break;
                            case 4:
                            if(fila[campos[j]]=="m")
                            document.getElementById('masculino').checked = true
                            else
                            document.getElementById('femenino').checked = true;
                            break;
                            case 5:
                            document.getElementById('correo').value = fila[campos[j]];
                            break;                           
                        }
                    }
                }
                     
            }
         
        })  
    }
    localStorage.clear();
}