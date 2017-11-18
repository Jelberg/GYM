var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";
var url2 = "http://localhost:8080/ServiciosGimnasio/Ejercicio";

var url_comple = "/getListEquipo";
var url_comple2 = "/getListMaquina";
var insertaEjercicioMaquina = "/insertaEjercicioMaquina";
var insertaEjercicioEquipo = "/insertaEjercicioEquipo";
var editaEjercicioMaquina = "/editaEjercicioMaquina";
var editaEjercicioEquipo = "/editaEjercicioEquipo";
var getEjercicio = "/getEjercicio";
var eliminarEme = "/eliminarEme";

var editing = localStorage.getItem('edit');
var id = localStorage.getItem('id');
var nombre = localStorage.getItem('nombre_eme');
var grupo = localStorage.getItem('grupo_eme');
var maquina = null
var equipo = null

isMaq = true
$(".forMaq").addClass('selected');
$(".forEqu").removeClass('selected')
$(".equipos").hide()
$(".maquinas").show()

$(document).ready(function () {

    $.get(url + url_comple, function (data) {
        for (i in data) {
            $("#equipos").append("<option value='" + data[i].id + "'>" + data[i].nombre + "</option>");
        }

    });

    $.get(url + url_comple2, function (data) {
        for (i in data) {
            $("#maquinas").append("<option value='" + data[i].id + "'>" + data[i].nombre + "</option>");
        }
    });

    if (editing == 'true') {
        document.getElementById("nombreEjercicio").value = nombre;
        document.getElementById("grupoEjercicio").value = grupo;
        $.get(url2 + getEjercicio + '?id=' + id, function (data) {
            console.log(data[0].equipo)
            console.log(data[0].maquina)
            if (data[0].equipo == 0) {
                equipo = null
                document.getElementById("equipos").value = null;
            } else {
                $(".forMaq").removeClass('selected');
                $(".forEqu").addClass('selected')
                $(".equipos").show()
                $(".maquinas").hide() 
                equipo = data[0].equipo
                document.getElementById("equipos").value = equipo;
            }
            if (data[0].maquina == 0) {
                maquina = null
                document.getElementById("maquinas").value = maquina;
            } else {
                $(".forMaq").addClass('selected');
                $(".forEqu").removeClass('selected')
                $(".equipos").hide()
                $(".maquinas").show() 
                document.getElementById("maquinas").value = maquina;
                maquina = data[0].maquina
            }

        });
    }
});

function toggle(val) {
    isMaq = true
    if (val == 1) {
        isMaq = true
        $(".forMaq").addClass('selected');
        $(".forEqu").removeClass('selected')
        $(".equipos").hide()
        $(".maquinas").show()
    } else {
        isMaq = false
        $(".forMaq").removeClass('selected');
        $(".forEqu").addClass('selected');
        $(".equipos").show()
        $(".maquinas").hide()
    }
}

function guardar() {

    var nombre = document.getElementById("nombreEjercicio").value;
    var grupo = document.getElementById("grupoEjercicio").value;
    if (isMaq == true) {
        equipo = null
        maquina = document.getElementById("maquinas").value;
    } else {
        maquina = null
        equipo = document.getElementById("equipos").value;
    }

    if (nombre == '' || grupo == '') return

    if (editing == 'true') {
        if (equipo == null) {
            if (maquina == '') return
            console.log(nombre, grupo, maquina, equipo)
            $.post(url2 + editaEjercicioMaquina + '?id=' + id + '?nombre=' + nombre + '&grupo=' + grupo + '&maquina=' + maquina)
                .done(function (data) {
                    console.log(data)
                    // window.location.href = './ejercicios.html'
                });
        } else {
            if (equipo == '') return
            $.post(url2 + editaEjercicioEquipo + '?id=' + id + '?nombre=' + nombre + '&grupo=' + grupo + '&equipo=' + equipo)
                .done(function (data) {
                    window.location.href = './ejercicios.html'
                });
        }

    } else {
        if (equipo == null) {
            if (maquina == '') return
            console.log(nombre, grupo, maquina, equipo)
            $.post(url2 + insertaEjercicioMaquina + '?nombre=' + nombre + '&grupo=' + grupo + '&maquina=' + maquina)
                .done(function (data) {
                    window.location.href = './ejercicios.html'
                });
        } else {
            if (equipo == '') return
            $.post(url2 + insertaEjercicioEquipo + '?nombre=' + nombre + '&grupo=' + grupo + '&equipo=' + equipo)
                .done(function (data) {
                    window.location.href = './ejercicios.html'
                });
        }
    }



} 