
$(document).ready(function () {
    function traerAutos() {
        $.ajax({
            type: "GET",
            url: "/autos",
            dataType: "json",
            success: function (data) {
                $("#gridAuto tbody").empty();
                $.each(data, function (index, Auto) {
                    var row = $("<tr>").appendTo($("#gridAuto tbody"));
                    $("<td>").text(Auto.id).appendTo(row);
                    $("<td>").text(Auto.patente).appendTo(row);
                    $("<td>").text(Auto.modelo).appendTo(row);
                    $("<td>").text(Auto.color).appendTo(row);
                    var botonModificar = $("<button>").text("Modificar");
                    botonModificar.click(function () {
                        window.location.href = "modificarAuto.html";
                    });
                    $("<td>").append(botonModificar).appendTo(row);
                });
            },
            error: function () {
                alert("Falla al traer Autos.");
            }
        });
    }
    traerAutos();
});
