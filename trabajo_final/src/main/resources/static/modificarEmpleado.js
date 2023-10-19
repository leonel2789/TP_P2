
$(document).ready(function () {
    const queryString = window.location.search;
    const urlParametro = new URLSearchParams(queryString);
    var empleadoId = urlParametro.get('id');

    function mostrarSeleccionado() {
        $.ajax({
            type: "GET",
            url: "/empleados/" + empleadoId,
            dataType: "json",
            success: function (empleado) {
                $("#empleadoId").val(empleado.id);
                $("#nombre").val(empleado.nombre);
                $("#apellido").val(empleado.apellido);
                $("#dni").val(empleado.dni);
                $("#btnModificar").on("click",function() {
                    const Empleado = {
                        id: $("#empleadoId").val(),
                        nombre: $("#nombre").val(),
                        apellido: $("#apellido").val(),
                        dni: $("#dni").val()
                    };

                    fetch('/empleados/modificar/' + empleadoId, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(Empleado)
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("Empleado fue modificado con exito.");
                                window.location.href = "htmlEmpleado.html"
                            } else {
                                alert("Empleado fallo al intentar modificarse.");
                                window.location.href = "htmlEmpleado.html"
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                            alert("Un error ocurrio al modificar Empleado.");
                            window.location.href = "htmlEmpleado.html"
                        });
                });
            },
            error: function () {
                alert("Fallo al traer empleado.");
            }
        });
    }
    mostrarSeleccionado();
});