src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/popper.min.js";
var url="http://localhost:8080/ServiciosGimnasio/Instruct/getInstruct?correo=marica@gmail.com";
var correo_busqueda= document.getElementById("text_lineas");
var boton= document.getElementById("boton");

boton.addEventListener("click", devolverInstructor);
alert("jeje");
function devolverInstructor()
{
    alert("jeje");
    fetch(url)
    .then((respuesta) => 
    {
        
        return respuesta.json();
    } ).then((respuesta) => 
    {
        console.log(respuesta);
        /*document.getElementById('id').value = respuesta.id;
        document.getElementById('nombre').value = respuesta.nombre;
        document.getElementById('apellido').value = respuesta.apellido;
        document.getElementById('fecha_nac').value = respuesta.fecha_nac;
        document.getElementById('sexo').value = respuesta.sexo;
        document.getElementById('correo').value = respuesta.correo;*/
        alert(respuesta.id +" " +respuesta.nombre +" "+respuesta.correo)
    })
    


}   