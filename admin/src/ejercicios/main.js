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