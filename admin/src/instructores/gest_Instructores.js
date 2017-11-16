src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/Instruct";
var correo_busqueda= document.getElementById("text_correo");


window.onload = function busquedainstructor()
{
    variable=localStorage.getItem("id");
    console.log(variable);
    if (variable)
        {
            alert="jeje"
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

function ValidateEmail(mail)   
{  
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))  
  {  
    return (true)  
  }  
    return (false)  
}  


function llevaratabla()
{
    document.location.href="./Instructores.html"
    
}


function insertarInstructor(){

    var res = document.getElementById("nombre").value.split(" ");
    var url_comple="/insertaInstruct?nombre="+res[0]+"&apellido="+res[1]+"&fechanac="+document.getElementById('fecha').value+"&sexo="+document.getElementById('sexo').value+"&correo="+document.getElementById('correo').value;
    fetch(url+url_comple, {
        method: 'POST'
    })
    .then(response => intento=1)
}

function borrarInstructor()
{
   var intento;
    var url_comple="/eliminaInstruct?correo="+document.getElementById('correo').value;
    fetch(url+url_comple, {
        method: 'DELETE'
    })
    .then(response => intento=1)
    if(intento==1){
        console.log(intento)
    window.alert("Se elimino correctamente");
    }
    else
    {
    window.alert("Correo no encontrado");
    }
    
}