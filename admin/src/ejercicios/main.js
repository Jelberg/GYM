function editar(e, type) {
    if (type == 1) {
        var id = e.parentNode.parentNode.childNodes
        for (var i = 0; i < id.length; i++) {
            var element = id[i];
            if (element.classList) {
                if (element.classList.value == 'id') {
                    localStorage.setItem('id', Number(element.innerHTML));
                    localStorage.setItem('edit', 'true');
                    window.location.href = './gest_ejercicios.html'
                }
            }
        }
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
                console.log('Elimino ID: ', element.innerHTML)
            }
        }
    }
}
var url = "http://localhost:8080/ServiciosGimnasio/Equipamiento";
window.onload = function mostrartabla() {
    var url_comple = "/getListEquipo";
    var url_comple2 = "/getListMaquina";
    fetch(url + url_comple)
        .then((respuesta) => {           
            return respuesta.json();
        }).then((respuesta) => {
            var contenido = "<link rel='stylesheet' href='../css/styles.css'><link rel='stylesheet' href='./style.css'><link rel='stylesheet' href='../css/font-awesome/css/font-awesome.min.css'><div class='row'><div class='content'><div class='w3-row' ><table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>";
            var fila = respuesta
            console.log(fila)

        })

    fetch(url + url_comple2)
        .then((respuesta) => {
            return respuesta.json();
        }).then((respuesta) => {
            var contenido = "<link rel='stylesheet' href='../css/styles.css'><link rel='stylesheet' href='./style.css'><link rel='stylesheet' href='../css/font-awesome/css/font-awesome.min.css'><div class='row'><div class='content'><div class='w3-row' ><table class='table table-bordered table-striped'><thead ><tr style='border: 1px solid black; background-color: #008080;'>";
            var fila = respuesta
            console.log(fila)

        })
}