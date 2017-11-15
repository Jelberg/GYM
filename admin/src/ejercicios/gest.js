$(document).ready(function () {
    var editing = localStorage.getItem('edit');
    var id = localStorage.getItem('id');
    if (editing == 'true') {
        console.log('Editando ID: ', id)
    }
});