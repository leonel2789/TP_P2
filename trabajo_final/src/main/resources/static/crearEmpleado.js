function crearEmpleado() {
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const dni = document.getElementById("dni").value;

    const data = {
        nombre: nombre,
        apellido: apellido,
        dni: dni
    };

    fetch('/empleados/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert("Empleado fue creado con exito.");
                window.location.href = "htmlEmpleado.html"
            } else {
                alert("Empleado fallo al intentar crearse.");
                window.location.href = "htmlEmpleado.html"
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Un error ocurrio al crear Empleado.");
        });
}