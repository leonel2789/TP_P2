
$(document).ready(function () {
    const queryString = window.location.search;
    const urlParametro = new URLSearchParams(queryString);
    var autoempleadoId = urlParametro.get('id');

    function mostrarSeleccionado() {
        $.ajax({
            type: "GET",
            url: "/autoempleados/" + autoempleadoId,
            dataType: "json",
            success: function (autoempleado) {
                $("#autoempleadoId").val(autoempleado.id);
                $("#autoId").val(autoempleado.autoId);
                $("#empleadoId").val(autoempleado.empleadoId);
                $("#reparacionId").val(autoempleado.reparacionId);
                $("#btnModificar").on("click",function() {
                    const AutoEmpleado = {
                        id: $("#autoempleadoId").val(),
                        autoId: $("#autoId").val(),
                        empleadoId: $("#empleadoId").val(),
                        reparacionId: $("#reparacionId").val()
                    };

                    fetch('/autoempleados/modificar/' + autoempleadoId, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(AutoEmpleado)
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("AutoEmpleado fue modificado con exito.");
                                window.location.href = "htmlAutoEmpleado.html"
                            } else {
                                alert("AutoEmpleado fallo al intentar modificarse.");
                                window.location.href = "htmlAutoEmpleado.html"
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                            alert("Un error ocurrio al modificar AutoEmpleado.");
                            window.location.href = "htmlAutoEmpleado.html"
                        });
                });
            },
            error: function () {
                alert("Fallo al traer autoempleado.");
            }
        });
    }
    mostrarSeleccionado();
});