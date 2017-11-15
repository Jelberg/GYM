src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/Instruct";
var correo_busqueda= document.getElementById("text_correo");
var boton= document.getElementById("boton_consulta");
var variable;
boton.addEventListener("click",buscarInstructor);

window.onload = function mostrartabla()
{
    var url_comple="/getListInstruct";
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
           if (i!=0)
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
            if (i!=0)
            {
                fila =respuesta[i];
                contenido += "<tr>";
                for (var j = 0; j < ncampos; j++)
                {
                    if (j!=0)
                    {
                    contenido += "<td>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                    }
                }
                contenido += "<td class='tcenter'><a><i class='fa fa-pencil-square-o' onClick='crud(this.id)' aria-hidden='true' value='"+variable+"'></i></a></td>";
            
                contenido += "</tr>";
            }
        }
        contenido += "</tbody></table></div></div></div>"
        document.getElementById("tabla").innerHTML = contenido;

    })
}


function buscarInstructor()
{
    if (correo_busqueda.value!="") 
    {
        var url_comple="/getInstruct?correo="+correo_busqueda.value;
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
           if (i!=0)
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
            
            {
                fila =respuesta[i];
                contenido += "<tr>";
                for (var j = 0; j < ncampos; j++)
                {
                    if (j!=0)
                    {
                    contenido += "<td>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                    }
                }
                contenido += "<td class='tcenter'><a><i class='fa fa-pencil-square-o' onClick='crud(this.id)' aria-hidden='true' value='"+variable+"'></i></a></td>";
            
                contenido += "</tr>";
            }
        }
        contenido += "</tbody></table></div></div></div>"
        document.getElementById("tabla").innerHTML = contenido;

    })
    }else
    alert("ERROR: No puede dejar el campo del correo vacio para una busqueda.")
}

function crud( guardar ){
    var id = guardar.parentNode.parentNode.parentNode.childNodes[4];
    console.log(id.innerHTML);
    localStorage.setItem("id",id.innerHTML);
    document.location.href="./gest_Instructores.html";
}
    


