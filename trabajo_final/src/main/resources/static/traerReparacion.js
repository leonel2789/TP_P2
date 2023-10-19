$(document).ready(function () {
    function traerReparacion() {
        $.ajax({
            type: "GET",
            url: "/reparacion",
            dataType: "json",
            success: function (data) {

                $.each(data, function (index, Reparacion) {
                    var row = $("<tr>").appendTo($("#gridReparacion tbody"));
                    $("<td>").text(Reparacion.id).appendTo(row);
                    $("<td>").text(Reparacion.descripcion).appendTo(row);
                    var botonModificar = $("<button>").text("Modificar");
                    botonModificar.click(function () {
                        window.location.href = "modificarReparacion.html" + "?id=" + Reparacion.id;
                    });
                    $("<td>").append(botonModificar).appendTo(row);
                    var botonEliminar = $("<button>").text("Eliminar");
                    botonEliminar.click(function () {
                        fetch('/reparacion/borrar/' + Reparacion.id, {
                            method: 'DELETE',
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("Reparacion fue eliminado con exito.");
                                    window.location.href = "htmlReparacion.html"
                                } else {
                                    alert("Reparacion fallo al intentar ser eliminado.");
                                    window.location.href = "htmlReparacion.html"
                                }
                            })
                            .catch(error => {
                                console.error('Error:', error);
                                alert("Un error ocurrio al eliminar Reparacion.");
                            });
                    });
                    $("<td>").append(botonEliminar).appendTo(row);
                });
            },
            error: function () {
                alert("Falla al traer Reparacion.");
            }
        });
    }
    traerReparacion();
});