src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/BOM02_Clase";
var correo_busqueda= document.getElementById("correo");

window.onload = function busquedainstructor()
{
    variable=localStorage.getItem("id");
    console.log(variable);
    if (variable)
        {

            var url_comple="/getClase?nombre="+variable;
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
                                document.getElementById('nombre').value = fila[campos[j]];
                                break;
                                case 2:
                                document.getElementById('descripcio').value = fila[campos[j]];
                                break;                          
                            }
                        }
                    }
                        
                }
            
            })  
        }
    localStorage.clear();
}



function async(params){
    setTimeout(function correrAsync(){
        params.fn.call(undefined, params.max)
    }, params.tiempo);
}

function llevaratabla()
{
    document.location.href="./Clases.html"
    
}

function buscarclase(nombre)
{
    var url_comple="/getClase?nombre="+nombre;
    fetch(url+url_comple)
    .then((respuesta) => 
    {            
        return respuesta.json();
    } ).then((respuesta) => 
    {
        
        var fila= respuesta[0];
        console.log(fila)
        if (fila)
        {
        alert("Eliminado Correctamente")
        }
        else
        alert("No se encontro la clase")
    })
}

function buscarclasemodi(nombre)
{
    var url_comple="/getClase?nombre="+nombre;
    fetch(url+url_comple)
    .then((respuesta) => 
    {            
        return respuesta.json();
    } ).then((respuesta) => 
    {
        
        var fila= respuesta[0];
        console.log(fila)
        if (fila)
        {
        alert("Modificado correctamente")
        
        }else
        alert("No se encontro la clase")
    })
}
function insertarClase()
{
    {
        if ((document.getElementById("nombre").value) &&  (document.getElementById("descripcio").value))
                {
                    var intento=0
                    var res = document.getElementById("nombre").value.split(" ");
                    console.log(res[0]+res[1])
                    var url_comple="/insertaClase?nombre="+document.getElementById("nombre").value+"&descripcion="+document.getElementById("descripcio").value
                    fetch(url+url_comple, {
                        method: 'POST'
                    })
                    .then(response =>{
                        
                        return response.json()
                    }).then(response =>{
                        var fila= response;
                        console.log(fila)
                        if(fila.error)
                        alert("Ya existe una clase con ese nombre")
                        else
                        alert("ingresado correctamente")
                        

                    })
                }

        else
        alert("Debe Llenar todas las casillas")
    }
    
    
}


function actualizarClase()
{
    buscarclasemodi(document.getElementById("nombre").value)
    {
        if ((document.getElementById("nombre").value) &&  (document.getElementById("descripcio").value))
                {
                    var intento=0
                    var res = document.getElementById("nombre").value.split(" ");
                    console.log(res[0]+res[1])
                    var url_comple="/modificaClase?nombre="+document.getElementById("nombre").value+"&descripcion="+document.getElementById("descripcio").value
                    fetch(url+url_comple, {
                        method: 'POST'
                    })
                    .then(response =>{
                        
                        return response.json()
                    }).then(response =>{
                        var fila= response;
                        console.log(fila)
                        
                        

                    })
                }

        else
        alert("Debe Llenar todas las casillas")
    }
    
}

function borrarClase()
{
    buscarclase(document.getElementById("nombre").value)
    {
   var intento;
    var url_comple="/eliminaClase?nombre="+document.getElementById("nombre").value;
    fetch(url+url_comple, {
        method: 'DELETE'
    })
    .then(response => {
        var fila= response;
        console.log(fila)
        
        
    })
}
  
    
}



