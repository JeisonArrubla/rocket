$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
        
        getRegistros(false, "ASC");
    });
});

function getRegistros(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRegistrosListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarRegistros(parsedResult);
            } else {
                console.log("Error recuperando los datos de los registros");
            }
        }
    });
}
function mostrarRegistros(registros) {

    let contenido = "";
    $.each(registros, function (index, registro) {

        registro = JSON.parse(registro);
        contenido += '<tr><th scope="row">' + registro.idRegistro + '</th>' +
                '<td>' + registro.cedula + '</td>' +
                '<td>' + registro.fechaLlegada + '</td>' +
                '<td>' + registro.fechaSalida + '</td>' +
                '<td>' + registro.ciudadOrigen + '</td>' +
                '<td>' + registro.idHabitacion + '</td></tr>';
    });
    $("#registros-tbody").html(contenido);
}
/*
function ordenarRegistros() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getRegistros(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getRegistros(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getRegistros(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
 * 
 */