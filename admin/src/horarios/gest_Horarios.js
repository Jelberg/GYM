src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
type="text/javascript"; 
var url="http://localhost:8080/ServiciosGimnasio/BOM02_Horario_Clase";
var correo_busqueda= document.getElementById("correo");
var x=0
window.onload = function busquedainstructor()
{
    var a,b,c,d,e,f,g,h
    a=0
    b=0
    c=0
    d=0
    e=0
    f=0
    g=0
    h=0
    variable=localStorage.getItem("id");
    console.log(variable);
    if (variable)
        {

            var url_comple="/getHorario_Clase_?id="+variable;
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
                                document.getElementById('fecha').value=cambiarFormato(fila[campos[j]]) ;
                                break;
                                case 2:
                                switch(fila[campos[j]]) 
                                {
                                    case "lunes":
                                    document.getElementById('dia').selectedIndex="0";
                                    break;
                                    case "martes":
                                    document.getElementById('dia').selectedIndex="1";
                                    break;
                                    case "miercoles":
                                    document.getElementById('dia').selectedIndex="2";
                                    break;
                                    case "jueves":
                                    document.getElementById('dia').selectedIndex="3";
                                    break;
                                    case "viernes":
                                    document.getElementById('dia').selectedIndex="4";
                                    break;
                                    case "sabado":
                                    document.getElementById('dia').selectedIndex="5";
                                    break;
                                    case "domingo":
                                    document.getElementById('dia').selectedIndex="6";
                                    break;

                                }
                                
                                break;
                                case 3:
                                document.getElementById('capacidad').value = (fila[campos[j]]);
                                break;
                                case 4:
                                document.getElementById('horaini').value =(fila[campos[j]]);
                                break;
                                case 5:
                                document.getElementById('horafin').value =(fila[campos[j]]);
                                break;  
                                case 6:
                                document.getElementById('duracion').value = 2;
                                break;
                                case 7:
                                llenarcombobox(a,document.getElementById('clase'),fila[campos[j]]) ;
                                a++;
                                break;
                                case 8:
                                llenarcombobox(b,document.getElementById('instructor'),fila[campos[j]]) 
                                b++;
                                break;                         
                            }
                        }
                    }
                        
                }
            
            })  
        }
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

function llenarcombobox(limite , box ,valor){

        box.options[limite+1]=new option('text',valor)
        limite++;
    
}

function async(params){
    setTimeout(function correrAsync(){
        params.fn.call(undefined, params.max)
    }, params.tiempo);
}

function llevaratabla()
{
    document.location.href="./Instructores.html"
    
}


function insertarInstructor()
{
    {
        var sex;
        if(document.getElementById('femenino').checked)
        sex="f"
        else
        if(document.getElementById('masculino').checked)
        sex="m"
        if ((document.getElementById("correo").value) &&  (document.getElementById("nombre").value) && (document.getElementById("fecha").value))
            if(validatedate(document.getElementById("fecha"))==true)
                if(ValidateEmail(document.getElementById("correo").value)==true)
                {
                    var intento=0
                    var res = document.getElementById("nombre").value.split(" ");
                    console.log(res[0]+res[1])
                    var url_comple="/insertaInstruct?nombre="+res[0]+"&apellido="+res[1]+"&fechanac="+document.getElementById('fecha').value+"&sexo="+sex+"&correo="+document.getElementById('correo').value;
                    fetch(url+url_comple, {
                        method: 'POST'
                    })
                    .then(response =>{
                        
                        return response.json()
                    }).then(response =>{
                        var fila= response;
                        console.log(fila)
                        if(fila.error)
                        alert("Ya existe ese correo")
                        else
                        alert("ingresado correctamente")
                        

                    })
                }
                else 
                alert("Correo invalido")   
            else
            alert("Fecha invalida")
        else
        alert("Debe Llenar todas las casillas")
    }

    
    
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
function validarbusqueda()
{
    var url_comple="/getInstructor?correo="+x;
    return fetch(url+url_comple)
    .then((respuesta) => 
    {            
        return respuesta.json();
    } ).then((respuesta) => 
    {    
        var fila= respuesta[0];
        if (fila)
        alert("Ya existe ese correo en la base de datos")
    })
}

function actualizarInstructor()
{
    var sex;
    if(document.getElementById('femenino').checked)
    sex="f"
    else
    if(document.getElementById('masculino').checked)
    sex="m"
    if ((document.getElementById("correo").value) &&  (document.getElementById("nombre").value) && (document.getElementById("fecha").value))
        if(validatedate(document.getElementById("fecha"))==true)
            if(ValidateEmail(document.getElementById("correo").value)==true)
            {
                var intento=0
                var res = document.getElementById("nombre").value.split(" ");
                console.log(res[0]+res[1])
                var url_comple="/actualizaInstruct?nombre="+res[0]+"&apellido="+res[1]+"&fechanac="+document.getElementById('fecha').value+"&sexo="+sex+"&correo="+document.getElementById('correo').value;
                fetch(url+url_comple, {
                    method: 'POST'
                })
                .then(response => {
                    
                    return response.json()
                }).then(response =>{
                    var fila= response;
                    console.log(fila)
                    if(fila.error)
                    alert("No se ha podido modificar")
                    else
                    alert("Actualizado correctamente")
                    

                })
            }
            else 
            alert("Correo invalido")   
        else
        alert("Fecha invalida")
    else
    alert("Debe Llenar todas las casillas")
    
    
}
var p = 1
function borrarInstruct()
{
    {
   var intento;
    var url_comple="/eliminaInstruct?correo="+correo_busqueda.value;
    fetch(url+url_comple, {
        method: 'DELETE'
    })
    .then(response => {
        var fila= response;
        console.log(fila)
        if(fila.error)
        alert("Correo Incorrecto")
        else
        {
        alert("Eliminado correctamente")
        document.location.href="./Instructores.html";
        }
    })
}
  
    
}



function validatedate(inputText)  
{  
var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
// Match the date format through regular expression  
if(inputText.value.match(dateformat))  
{    
//Test which seperator is used '/' or '-'  
var opera1 = inputText.value.split('/');  
var opera2 = inputText.value.split('-');  
lopera1 = opera1.length;  
lopera2 = opera2.length;  
// Extract the string into month, date and year  
if (lopera1>1)  
{  
var pdate = inputText.value.split('/');  
}  
else if (lopera2>1)  
{  
var pdate = inputText.value.split('-');  
}  
var dd = parseInt(pdate[0]);  
var mm  = parseInt(pdate[1]);  
var yy = parseInt(pdate[2]);  
// Create list of days of a month [assume there is no leap year by default]  
var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
if (mm==1 || mm>2)  
{  
if (dd>ListofDays[mm-1])  
{   
return false;  
}  
}  
if (mm==2)  
{  
var lyear = false;  
if ( (!(yy % 4) && yy % 100) || !(yy % 400))   
{  
lyear = true;  
}  
if ((lyear==false) && (dd>=29))  
{  
return false;  
}  
if ((lyear==true) && (dd>29))  
{    
return false;  
}  
}
return true;  
}  
else  
{      
return false;  
}  
}