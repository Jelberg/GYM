src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/webServices_gym/instructor";
//var url="http://localhost:8080/ServiciosGimnasio/Instruct";
var correo_busqueda= document.getElementById("text_correo");
var boton= document.getElementById("boton_consulta");
var variable;
boton.addEventListener("click",buscarInstructor);

window.onload = function mostrartabla()
{
    variable=localStorage.getItem("id2");
    if (variable){
    alert(variable)
    localStorage.clear();    
    }
    var url_comple="/getListInstructores";
    //var url_comple="/getListInstruct";
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
           if (i!=5)
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
                console.log(fila);
                contenido += "<tr>";
                for (var j = 0; j < ncampos; j++)
                {
                    if (j!=5)
                    {
                    contenido += "<td>";
                    if (j!=2)
                    contenido += fila[campos[j]];
                    else
                    {
                        contenido +=cambiarFormato( fila[campos[j]] );
                    }
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

function cambiarFormato(dates){
    
        var opera1 = dates.split(' ');
        switch(opera1[0]){
        case "ene":
        opera1[0]="jan"
        break;
        case "ago":
        opera1[0]="aug"
        break;
        case "dic":
        opera1[0]="dec"
        break;
        case "ene":
        opera1[0]="jan"
        break;
        case "abr":
        opera1[0]="apr"
        break;
        }
        dates= opera1[0]+" "+ opera1[1]+" "+ opera1[2]
        var date = new Date(dates);
        
        return((date.toLocaleDateString()));
    }

function buscarInstructor()
{
    
    if (correo_busqueda.value!="")
    {
        var prueba = ValidateEmail(correo_busqueda.value);
        if (prueba==true) 
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
        console.log(fila)
        if (fila)
        {
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
                                if (j!=3)
                                contenido += fila[campos[j]];
                                else
                                {
                                    contenido +=cambiarFormato( fila[campos[j]] );
                                }
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
            alert("No se encontro el correo solicitado");

        })
        }}else
        alert("ERROR: No puede dejar el campo del correo vacio para una busqueda.")
    }




  

  function ValidateEmail(mail)   
  {  
   if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))  
    {  
      return (true)  
    } 
    alert("Formato de correo invalido."); 
      return (false);  
      
  }  

function crud( guardar ){
    var id = guardar.parentNode.parentNode.parentNode.childNodes[4];
    console.log(id.innerHTML);
    localStorage.setItem("id",id.innerHTML);
    document.location.href="./gest_Instructores2.html";
}
    


