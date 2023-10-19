$(document).ready(function () {
    function traerAutoEmpleado() {
        $.ajax({
            type: "GET",
            url: "/autoempleados",
            dataType: "json",
            success: function (data) {

                $.each(data, function (index, AutoEmpleado) {
                    var row = $("<tr>").appendTo($("#gridAutoEmpleado tbody"));
                    $("<td>").text(AutoEmpleado.id).appendTo(row);
                    $("<td>").text(AutoEmpleado.autoId).appendTo(row);
                    $("<td>").text(AutoEmpleado.empleadoId).appendTo(row);
                    $("<td>").text(AutoEmpleado.reparacionId).appendTo(row);
                    var botonModificar = $("<button>").text("Modificar");
                    botonModificar.click(function () {
                        window.location.href = "modificarAutoEmpleado.html" + "?id=" + AutoEmpleado.id;
                    });
                    $("<td>").append(botonModificar).appendTo(row);
                    var botonEliminar = $("<button>").text("Eliminar");
                    botonEliminar.click(function () {
                        fetch('/autoempleados/borrar' + AutoEmpleado.id, {
                            method: 'DELETE',
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("AutoEmpleado fue eliminado con exito.");
                                    window.location.href = "htmlAutoEmpleado.html"
                                } else {
                                    alert("AutoEmpleado fallo al intentar ser eliminado.");
                                    window.location.href = "htmlAutoEmpleado.html"
                                }
                            })
                            .catch(error => {
                                console.error('Error:', error);
                                alert("Un error ocurrio al eliminar AutoEmpleado.");
                            });
                    });
                    $("<td>").append(botonEliminar).appendTo(row);
                });
            },
            error: function () {
                alert("Falla al traer AutoEmpleado.");
            }
        });
    }
    traerAutoEmpleado();
});