var editing
var id
var maquina
var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";
var url_comple = "/insertaEquipo"; 


$(document).ready(function () {
    editing = localStorage.getItem('edit');
    id = localStorage.getItem('id');
    maquina = localStorage.getItem('Maquina');

    if (editing == 'true') {
        console.log('Editando ID: ', id)
        console.log('Maquina: ', maquina)
    }
});

function guardar() {
    var e = document.getElementById("select");
    var selValue = e.options[e.selectedIndex].value;
    if (editing == 'true') {
        if (selValue != maquina) {
            console.log('tengo que hacer delete e insert')
        } else {
            console.log('edito')
        }
    } else {

        $.post(url + url_comple, {
                nombre: "John" 
            })
            .done(function (data) {
                alert("Data Loaded: " + data);
            });
    }
}