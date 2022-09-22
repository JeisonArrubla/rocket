$(document).ready(function () {

    $("#registrar-usuarios").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });

    $("#registrar-ingreso").submit(function (event) {

        event.preventDefault();
        registrarIngreso();
    });
});

function registrarUsuario() {

    let cedula = $("#input-cedula").val();
    let nombre = $("#input-nombre").val();
    let apellido = $("#input-apellido").val();
    let email = $("#input-email").val();
    let telefono = $("#input-telefono").val();
    let nacionalidad = $("#input-nacionalidad").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRegistrarUsuarios",
        data: $.param({
            cedula: cedula,
            nombre: nombre,
            apellido: apellido,
            email: email,
            telefono: telefono,
            nacionalidad: nacionalidad
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                $("#register-error").addClass("d-none");
                let cedula = parsedResult['cedula'];
                $("#register-successful").removeClass("d-none");
                $("#register-successful").html("Registro exitoso");
            } else {
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Error en el registro del usuario");
            }
        }
    });
}

function registrarIngreso() {

    let cedula = $("#input-cedula").val();
    let fechaLlegada = $("#input-fechaLlegada").val();
    let fechaSalida = $("#input-fechaSalida").val();
    let ciudadOrigen = $("#input-ciudadOrigen").val();
    let idHabitacion = $("#input-idHabitacion").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRegistrarIngreso",
        data: $.param({
            cedula: cedula,
            fechaLlegada: fechaLlegada,
            fechaSalida: fechaSalida,
            ciudadOrigen: ciudadOrigen,
            idHabitacion: idHabitacion
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                $("#register-error").addClass("d-none");
                let cedula = parsedResult['cedula'];
                $("#register-successful").removeClass("d-none");
                $("#register-successful").html("Registro exitoso");
            } else {
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Error en el registro del ingreso");
            }
        }
    });
}