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


function insertarInstructor()
{

    if (document.getElementById("nombre").value && document.getElementById("fecha").value && document.getElementById("sexo").value && document.getElementById("correo").value )
    {

        var res = document.getElementById("nombre").value.split(" ");
        var url_comple="/insertaInstruct?nombre="+res[0]+"&apellido="+res[1]+"&fechanac="+document.getElementById('fecha').value+"&sexo="+document.getElementById('sexo').value+"&correo="+document.getElementById('correo').value;
        fetch(url+url_comple, {
            method: 'POST'
        })
        .then(response => intento=1)
    }
    else 
    alert("Ningun campo puede estar vacio ")
}

function borrarInstruct()
{
   var intento;
    var url_comple="/eliminaInstruct?correo="+document.getElementById('correo').value;
    fetch(url+url_comple, {
        method: 'DELETE'
    })
    .then(response => intento=1)
    if(intento==1){
    localStorage.setItem("id2","Se ha eliminado correctamente");    
    document.location.href="./Instructores.html";
    }
    else
    {
    localStorage.setItem("id2","No se ha encontrado el correo buscar en la lista a continuacion");
    document.location.href="./Instructores.html";
    }
    
}


function validatedate(inputText)  
{  
var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
// Match the date format through regular expression  
if(inputText.value.match(dateformat))  
{  
document.form1.text1.focus();  
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
alert('Invalid date format!');  
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
alert('Invalid date format!');  
return false;  
}  
if ((lyear==true) && (dd>29))  
{  
alert('Invalid date format!');  
return false;  
}  
}  
}  
else  
{  
alert("Invalid date format!");  
document.form1.text1.focus();  
return false;  
}  
}