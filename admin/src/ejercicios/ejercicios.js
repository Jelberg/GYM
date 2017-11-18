var url_ej = "http://localhost:8080/ServiciosGimnasio/Ejercicio";
var eliminarEme = "/eliminarEme";
var getAll = "/getAll";
var items = []
$.get(url_ej + getAll, function (data) {
    for (var j = 0; j < data.length; j++) {
        items.push(data[j]);
    }
    if (items.length > 0) {
        var contenido = "<table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>"
        var fila = items[0]
        var campos = Object.keys(fila);
        var ncampos = campos.length;
        for (var i = 0; i < ncampos; i++) {
            if (campos[i] == 'id' || campos[i] == 'maquina' || campos[i] == 'equipo') {
                contenido += "<th style='display:none'>";
                contenido += campos[i];
                contenido += "</th>";
            } else {
                var titulo
                if (campos[i] == 'nombre') titulo = 'Nombre'
                if (campos[i] == 'grupomuscular') titulo = 'Grupo muscular'
                if (campos[i] == 'equipamiento') titulo = 'Equipamiento'
                contenido += "<th style='color:white'>";
                contenido += titulo;
                contenido += "</th>";
            }
        }
        contenido += "<th style='color:white;text-align:center'>Acciones</th></tr></thead><tbody>"
        var nregistros = items.length;
        for (var i = 0; i < nregistros; i++) {

            fila = items[i];
            contenido += "<tr>";
            var maquina = false
            for (var j = 0; j < ncampos; j++) {
                if (campos[j] == 'id') {
                    contenido += "<td class='id' style='display:none'>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                } else if (campos[j] == 'maquina' || campos[j] == 'equipo') {
                    contenido += "<td class='' style='display:none'>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                } else if (campos[j] == 'grupomuscular') {
                    contenido += "<td class='grupomuscular'>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                } else if (campos[j] == 'nombre') {
                    contenido += "<td class='nombre'>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                } else {
                    contenido += "<td>";
                    contenido += fila[campos[j]];
                    contenido += "</td>";
                }

            }
            contenido += "<td class='tcenter'> <i class='fa fa-trash' onclick='eliminar(this)' aria-hidden='true'></i></td>";
            contenido += "</tr>";

        }
        contenido += "</tbody></table></div></div></div>"
        document.getElementById("tabla").innerHTML = contenido;
    }
});

function editar(e, type) {
    if (type == 1) {
        var id = e.parentNode.parentNode.childNodes
        for (var i = 0; i < id.length; i++) {
            var element = id[i];
            if (element.classList) {
                console.log(element.classList.value)
                if (element.classList.value == 'id') {
                    localStorage.setItem('id', Number(element.innerHTML));
                }
                if (element.classList.value == 'nombre') {
                    localStorage.setItem('nombre_eme', element.innerHTML);
                }
                if (element.classList.value == 'grupomuscular') {
                    localStorage.setItem('grupo_eme', element.innerHTML);
                }


            }
        }
        localStorage.setItem('edit', 'true');
        window.location.href = './gest_ejercicios.html'

    } else {
        localStorage.setItem('id', null);
        localStorage.setItem('edit', 'false');
        window.location.href = './gest_ejercicios.html'
    }
}

function eliminar(e) {
    var id = e.parentNode.parentNode.childNodes
    for (var i = 0; i < id.length; i++) {
        var element = id[i];
        if (element.classList) {
            if (element.classList.value == 'id') {
                $.post(url_ej + eliminarEme + '?id=' + Number(element.innerHTML))
                    .done(function (data) {
                        location.reload();
                    });

            }
        }
    }
}