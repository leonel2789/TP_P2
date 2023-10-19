function crearReparacion() {
    const descripcion = document.getElementById("descripcion").value;

    const data = {
        descripcion: descripcion
    };

    fetch('/reparacion/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert("Reparacion fue creado con exito.");
                window.location.href = "htmlReparacion.html"
            } else {
                alert("Reparacion fallo al intentar crearse.");
                window.location.href = "htmlReparacion.html"
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Un error ocurrio al crear Reparacion.");
        });
}