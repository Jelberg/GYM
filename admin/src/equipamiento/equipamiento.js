var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";
var url_comple = "/getListEquipo";
var url_comple2 = "/getListMaquina";
var url_delete_equipo = "/eliminarEquipo";
var url_delete_maquina = "/eliminarMaquina";

window.onload = function mostrartabla() {
    var machines = []
    $.get(url + url_comple, function (data) {
        for (var i = 0; i < data.length; i++) {
            data[i].type = 'Equipo'
            machines.push(data[i]);
        }
        $.get(url + url_comple2, function (data2) {
            for (var j = 0; j < data2.length; j++) {
                data2[j].type = 'Máquina'
                machines.push(data2[j]);
            }
            if (machines.length > 0) {
                var contenido = "<table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>"
                var fila = machines[0]
                var campos = Object.keys(fila);
                var ncampos = campos.length;
                for (var i = 0; i < ncampos; i++) { 
                    if (campos[i] == 'id') {
                        contenido += "<th style='display:none'>";
                        contenido += campos[i];
                        contenido += "</th>";
                    } else {
                        var titulo
                        if (campos[i] == 'nombre') titulo = 'Nombre'
                        if (campos[i] == 'type') titulo = 'Tipo'
                        contenido += "<th style='color:white'>";
                        contenido += titulo;
                        contenido += "</th>";
                    }
                }
                contenido += "<th style='color:white;text-align:center'>Acciones</th></tr></thead><tbody>"
                var nregistros = machines.length;
                for (var i = 0; i < nregistros; i++) {

                    fila = machines[i];
                    contenido += "<tr>";
                    var maquina = false
                    for (var j = 0; j < ncampos; j++) {
                        if (campos[j] == 'id') {
                            contenido += "<td class='id' style='display:none'>";
                            contenido += fila[campos[j]];
                            contenido += "</td>";
                        } else {
                            if (campos[j] == 'type') {
                                if (fila[campos[j]] == 'Máquina') {
                                    maquina = true

                                }
                            }

                            contenido += "<td>";
                            contenido += fila[campos[j]];
                            contenido += "</td>";
                        }

                    }
                    if (maquina == true) {
                        contenido += "<td class='tcenter'><i class='fa fa-pencil-square-o' onclick='editar(this,1,1)' aria-hidden='true'></i><i class='fa fa-trash' onclick='eliminar(this,1)' aria-hidden='true'></i></td>";
                    } else {
                        contenido += "<td class='tcenter'><i class='fa fa-pencil-square-o' onclick='editar(this,0,1)' aria-hidden='true'></i><i class='fa fa-trash' onclick='eliminar(this,0)' aria-hidden='true'></i></td>";
                    }

                    contenido += "</tr>";

                }
                contenido += "</tbody></table></div></div></div>"
                document.getElementById("tabla").innerHTML = contenido;
            }
        });
    });
}


function editar(e, esMaquina, type) {
    if (type == 1) {
        var id = e.parentNode.parentNode.childNodes
        for (var i = 0; i < id.length; i++) {
            var element = id[i];
            if (element.classList) {
                if (element.classList.value == 'id') {
                    localStorage.setItem('id', Number(element.innerHTML));
                    localStorage.setItem('edit', 'true');
                    localStorage.setItem('Maquina', esMaquina);
                    window.location.href = './gest_equipamiento.html'
                }
            }
        }
    } else {
        localStorage.setItem('id', null);
        localStorage.setItem('edit', 'false');
        window.location.href = './gest_equipamiento.html'
    }
}

function eliminar(e, esMaquina) {
    var id = e.parentNode.parentNode.childNodes
    for (var i = 0; i < id.length; i++) {
        var element = id[i];
        if (element.classList) {
            if (element.classList.value == 'id') {
                if (esMaquina == 0) {
                    $.post(url + url_delete_equipo + '?id=' + Number(element.innerHTML))
                        .done(function (data) {
                            location.reload();
                        });
                } else {
                    $.post(url + url_delete_maquina + '?id=' + Number(element.innerHTML))
                        .done(function (data) {
                            location.reload();
                        });
                }
            }
        }
    }
}