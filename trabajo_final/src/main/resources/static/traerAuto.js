
$(document).ready(function () {
    function traerAutos() {
        $.ajax({
            type: "GET",
            url: "/autos",
            dataType: "json",
            success: function (data) {
                $.each(data, function (index, Auto) {
                    var row = $("<tr>").appendTo($("#gridAuto tbody"));
                    $("<td>").text(Auto.id).appendTo(row);
                    $("<td>").text(Auto.patente).appendTo(row);
                    $("<td>").text(Auto.modelo).appendTo(row);
                    $("<td>").text(Auto.color).appendTo(row);
                    var botonModificar = $("<button>").text("Modificar");
                    botonModificar.click(function () {
                        window.location.href = "modificarAuto.html" + "?id=" + Auto.id;
                    });
                    $("<td>").append(botonModificar).appendTo(row);
                    var botonEliminar = $("<button>").text("Eliminar");
                    botonEliminar.click(function () {
                        fetch('/autos/borrar/' + Auto.id, {
                            method: 'DELETE',
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("Auto fue eliminado con exito.");
                                    window.location.href = "htmlAuto.html"
                                } else {
                                    alert("Auto fallo al intentar ser eliminado.");
                                    window.location.href = "htmlAuto.html"
                                }
                            })
                            .catch(error => {
                                console.error('Error:', error);
                                alert("Un error ocurrio al eliminar Auto.");
                            });
                    });
                    $("<td>").append(botonEliminar).appendTo(row);
                });
            },
            error: function () {
                alert("Falla al traer Autos.");
            }
        });
    }
    traerAutos();
});
