$(document).ready(function () {

    $(function () {

        getRegistros(false, "ASC");

        getUsuarios(false, "ASC");
    });

    $("#consultar-usuario").submit(function (event) {

        event.preventDefault();
        consultarUsuario();
    });
});

function getRegistros(ordenar, orden) {

    $.ajax({

        type: "GET",
        dataType: "html",
        url: "./ServletListarRegistros",
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

function getUsuarios(ordenar, orden) {

    $.ajax({

        type: "GET",
        dataType: "html",
        url: "./ServletListarUsuarios",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {

            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarUsuarios(parsedResult);

            } else {

                console.log("Error recuperando los datos de los usuarios");
            }
        }
    });
}

function mostrarUsuarios(usuarios) {

    let contenido = "";
    $.each(usuarios, function (index, usuario) {

        usuario = JSON.parse(usuario);

        contenido += '<tr><th scope="row">' + usuario.cedula + '</th>' +
                '<td>' + usuario.nombre + '</td>' +
                '<td>' + usuario.apellido + '</td>' +
                '<td>' + usuario.email + '</td>' +
                '<td>' + usuario.telefono + '</td>' +
                '<td>' + usuario.nacionalidad + '</td></tr>';
    });
    $("#usuarios-tbody").html(contenido);
}

function consultarUsuario() {

    let cedula = $("#input-cedula").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletConsultarUsuario",
        data: $.param({
            cedula: cedula
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                mostrarUsuario(parsedResult);
            }
        }
    });
}

function mostrarUsuario(usuario) {

    usuario = JSON.parse(usuario);
    
    document.getElementById("input-nombre").value = usuario.nombre;
    document.getElementById("input-apellido").value = usuario.apellido;
    document.getElementById("input-email").value = usuario.email;
    document.getElementById("input-telefono").value = usuario.telefono;
    document.getElementById("input-nacionalidad").value = usuario.nacionalidad;
}