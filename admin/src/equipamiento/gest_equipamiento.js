var editing
var id
var maquina
var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";
var url_comple = "/insertaEquipo";
var url_comple2 = "/insertaMaquina";
var getEquipo = "/getEquipo";
var editEquipo = "/editEquipo";
var getMaquina = "/getMaquina";
var editMaquina = "/editMaquina";


$(document).ready(function () {
    editing = localStorage.getItem('edit');
    id = localStorage.getItem('id');
    maquina = localStorage.getItem('Maquina');

    if (editing == 'true') {
        $('#select').prop('disabled', 'disabled');
        if (maquina == 0) {
            $.get(url + getEquipo + '?id=' + id)
                .done(function (data) {
                    document.getElementById("nombre").value = data[0].nombre;
                    document.getElementById("select").value = data[0] = 0;
                });
        } else {
            $.get(url + getMaquina + '?id=' + id)
                .done(function (data) {
                    document.getElementById("nombre").value = data[0].nombre;
                    document.getElementById("select").value = data[0] = 1;
                });
        }
    }
});

function guardar() {
    var nombre = document.getElementById("nombre").value;
    var e = document.getElementById("select");
    var selValue = e.options[e.selectedIndex].value;
    if (nombre == '') return
    if (editing == 'true') {
        if (selValue == 0) {
            $.post(url + editEquipo+ '?id=' + id + '&nombre=' + nombre)
                .done(function (data) { 
                    window.location.href = './equipamiento.html'
                });
        } else {
            $.post(url + editMaquina + '?id=' + id + '&nombre=' + nombre)
                .done(function (data) {
                    window.location.href = './equipamiento.html'
                });
        }
    } else {
        if (selValue == 0) {
            $.post(url + url_comple + '?nombre=' + nombre)
                .done(function (data) {
                    window.location.href = './equipamiento.html'
                });
        } else {
            $.post(url + url_comple2 + '?nombre=' + nombre)
                .done(function (data) {
                    window.location.href = './equipamiento.html'
                });
        }
    }
}