$(document).ready(function () {
    var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";

    var url_comple = "/getListEquipo";
    var url_comple2 = "/getListMaquina";

    var editing = localStorage.getItem('edit');
    var id = localStorage.getItem('id');

    $(".forMaq").addClass('selected');
    $(".forEqu").removeClass('selected')
    $(".equipos").hide()
    $(".maquinas").show()
    

    $.get(url + url_comple, function (data) {
        console.log('data', data)
        for (i in data) {
            $("#equipos").append("<option value='" + data[i].id + "'>" + data[i].nombre + "</option>");
        }

    });

    $.get(url + url_comple2, function (data) {
        console.log('data', data)
        for (i in data) {
            $("#maquinas").append("<option value='" + data[i].id + "'>" + data[i].nombre + "</option>");
        }
    });

    if (editing == 'true') {
        console.log('Editando ID: ', id)
    }
});

function toggle(val) {
    if (val == 0) {
        $(".forMaq").addClass('selected');
        $(".forEqu").removeClass('selected')
        $(".equipos").hide()
        $(".maquinas").show()
        console.log(0)
    } else {
        $(".forMaq").removeClass('selected');
        $(".forEqu").addClass('selected');
        $(".equipos").show()
        $(".maquinas").hide()
        console.log(1)
    }

}