$(document).ready(function () {
    const queryString = window.location.search;
    const urlParametro = new URLSearchParams(queryString);
    var reparacionId = urlParametro.get('id');

    function mostrarSeleccionado() {
        $.ajax({
            type: "GET",
            url: "/reparacion/" + reparacionId,
            dataType: "json",
            success: function (reparacion) {
                $("#reparacionId").val(reparacion.id);
                $("#nombre").val(reparacion.descripcion);
                $("#btnModificar").on("click",function() {
                    const Reparacion = {
                        id: $("#reparacionId").val(),
                        descripcion: $("#descripcion").val()
                    };

                    fetch('/reparacion/modificar/' + reparacionId, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(Reparacion)
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("Reparacion fue modificado con exito.");
                                window.location.href = "htmlReparacion.html"
                            } else {
                                alert("Reparacion fallo al intentar modificarse.");
                                window.location.href = "htmlReparacion.html"
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                            alert("Un error ocurrio al modificar Reparacion.");
                            window.location.href = "htmlReparacion.html"
                        });
                });
            },
            error: function () {
                alert("Fallo al traer reparacion.");
            }
        });
    }
    mostrarSeleccionado();
});