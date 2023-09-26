
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
                },
                error: function () {
                    alert("Failed to fetch Car data.");
                }
            });
        }
    mostrarSeleccionado();
});