
$(document).ready(function () {
        const queryString = window.location.search;
        const urlParametro = new URLSearchParams(queryString);
        var autoId = urlParametro.get('id');

        function mostrarSeleccionado() {
            $.ajax({
                type: "GET",
                url: "/autos/" + autoId,
                dataType: "json",
                success: function (auto) {
                    $("#autoId").val(auto.id);
                    $("#patente").val(auto.patente);
                    $("#modelo").val(auto.modelo);
                    $("#color").val(auto.color);
                    $("#btnModificar").on("click",function() {
                        const Auto = {
                            id: $("#autoId").val(),
                            patente: $("#patente").val(),
                            modelo: $("#modelo").val(),
                            color: $("#color").val()
                        };

                        fetch('/autos/modificar/' + autoId, {
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(Auto)
                        })
                            .then(response => {
                                if (response.ok) {
                                    alert("Auto fue modificado con exito.");
                                    window.location.href = "htmlAuto.html"
                                } else {
                                    alert("Auto fallo al intentar modificarse.");
                                    window.location.href = "htmlAuto.html"
                                }
                            })
                            .catch(error => {
                                console.error('Error:', error);
                                alert("Un error ocurrio al modificar Auto.");
                                window.location.href = "htmlAuto.html"
                            });
                    });
                },
                error: function () {
                    alert("Fallo al traer auto.");
                }
                });
        }
        mostrarSeleccionado();
});