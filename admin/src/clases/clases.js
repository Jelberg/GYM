src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/BOM02_Clase";
var busqueda= document.getElementById("clase_nombre");
var boton= document.getElementById("consulta");
var variable;
boton.addEventListener("click",buscarClase);

window.onload = function mostrartabla()
{
    variable=localStorage.getItem("id2");
    if (variable){
    alert(variable)
    localStorage.clear();    
    }
    var url_comple="/getListClase";
    fetch(url+url_comple)
    .then((respuesta) => 
    {
        
        return respuesta.json();
    } ).then((respuesta) => 
    {
       var contenido= "<link rel='stylesheet' href='../css/styles.css'><link rel='stylesheet' href='./style.css'><link rel='stylesheet' href='../css/font-awesome/css/font-awesome.min.css'><div class='row'><div class='content'><div class='w3-row' ><table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>";
       var fila= respuesta[0];
       var campos = Object.keys(fila);
       var ncampos =campos.length;
       for (var i = 0; i < ncampos; i++)
       {
           if ((i!=3) &&(i!=0))
           {
            contenido += "<th><font color ='white'>";
            contenido += campos[i];
            contenido += "</font></th>";
           }
       }
       contenido += "<th><font color ='white'>Acciones</font></th></tr></thead><tbody>"
       var nregistros = respuesta.length;
       for(var i = 0; i< nregistros; i++)
        {
            if ((i!=3) &&(i!=0))
            {
                fila =respuesta[i];
                contenido += "<tr>";
                for (var j = 0; j < ncampos; j++)
                {
                    if ((j!=3) &&(j!=0))
                    {
                    contenido += "<td>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                    }
                }
                contenido += "<td class='tcenter'><a><i class='fa fa-pencil-square-o' onClick='crud(this)' aria-hidden='true'></i></a></td>";
            
                contenido += "</tr>";
            }
        }
        contenido += "</tbody></table></div></div></div>"
        document.getElementById("tabla").innerHTML = contenido;

    })
}


function buscarClase()
{
    
    if (busqueda.value!="")
    {
        {
            var url_comple="/getClase?nombre="+busqueda.value;
            fetch(url+url_comple)
            .then((respuesta) => 
            {
                
            return respuesta.json();
        } ).then((respuesta) => 
        {
        var contenido= "<link rel='stylesheet' href='../css/styles.css'><link rel='stylesheet' href='./style.css'><link rel='stylesheet' href='../css/font-awesome/css/font-awesome.min.css'><div class='row'><div class='content'><div class='w3-row' ><table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>";
        var fila= respuesta[0];
        console.log(fila)
        if (fila)
        {
                var campos = Object.keys(fila);
                var ncampos =campos.length;
                for (var i = 0; i < ncampos; i++)
                {
                    if ((i!=3) &&(i!=0))
                    {
                        contenido += "<th><font color ='white'>";
                        contenido += campos[i];
                        contenido += "</font></th>";
                    }
                }
                contenido += "<th><font color ='white'>Acciones</font></th></tr></thead><tbody>"
                var nregistros = respuesta.length;
                for(var i = 0; i< nregistros; i++)
                    {
                        if ((i!=3) &&(i!=0))
                        {
                            fila =respuesta[i];
                            contenido += "<tr>";
                            for (var j = 0; j < ncampos; j++)
                            {
                                if ((j!=3) &&(j!=0))
                                {
                                contenido += "<td>";
                                contenido += fila[campos[j]];
                                contenido += "</td>";
                                }
                            }
                            contenido += "<td class='tcenter'><a><i class='fa fa-pencil-square-o' onClick='crud(this)' aria-hidden='true' ></i></a></td>";
                        
                            contenido += "</tr>";
                        }
                    }
                    contenido += "</tbody></table></div></div></div>"
                    document.getElementById("tabla").innerHTML = contenido;
            }
            else
            alert("No se encontro la clase solicitada");

        })
        }}else
        alert("ERROR: No puede dejar el campo del nombre vacio para una busqueda.")
    }




   

function crud( guardar ){
    var id = guardar.parentNode.parentNode.parentNode.childNodes[0];
    console.log(id.innerHTML);
    localStorage.setItem("id",id.innerHTML);
    document.location.href="./gest_Clases.html";
}
    

