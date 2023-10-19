$(document).ready(function () {
    function traerEmpleado() {
        $.ajax({
            type: "GET",
            url: "/empleados",
            dataType: "json",
            success: function (data) {

                $.each(data, function (index, Empleado) {
                    var row = $("<tr>").appendTo($("#gridEmpleado tbody"));
                    $("<td>").text(Empleado.id).appendTo(row);
                    $("<td>").text(Empleado.nombre).appendTo(row);
                    $("<td>").text(Empleado.apellido).appendTo(row);
                    $("<td>").text(Empleado.dni).appendTo(row);
                    var botonModificar = $("<button>").text("Modificar");
                    botonModificar.click(function () {
                        window.location.href = "modificarEmpleado.html" + "?id=" + Empleado.id;
                    });
                    $("<td>").append(botonModificar).appendTo(row);
                    var botonEliminar = $("<button>").text("Eliminar");
                    botonEliminar.click(function () {
                        fetch('/empleados/borrar/' + Empleado.id, {
                            method: 'DELETE',
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("Empleado fue eliminado con exito.");
                                    window.location.href = "htmlEmpleado.html"
                                } else {
                                    alert("Empleado fallo al intentar ser eliminado.");
                                    window.location.href = "htmlEmpleado.html"
                                }
                            })
                            .catch(error => {
                                console.error('Error:', error);
                                alert("Un error ocurrio al eliminar Empleado.");
                            });
                    });
                    $("<td>").append(botonEliminar).appendTo(row);
                });
            },
            error: function () {
                alert("Falla al traer Empleado.");
            }
        });
    }
    traerEmpleado();
});