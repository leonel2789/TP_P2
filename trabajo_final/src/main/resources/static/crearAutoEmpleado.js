function crearAutoEmpleado() {
    const autoId = document.getElementById("autoId").value;
    const empleadoId = document.getElementById("empleadoId").value;
    const reparacionId = document.getElementById("reparacionId").value;

    const data = {
        autoId: autoId,
        empleadoId: empleadoId,
        reparacionId: reparacionId
    };

    fetch('/autoempleados/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert("AutoEmpleado fue creado con exito.");
                window.location.href = "htmlAutoEmpleado.html"
            } else {
                alert("AutoEmpleado fallo al intentar crearse." + autoId);
                window.location.href = "htmlAutoEmpleado.html"
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Un error ocurrio al crear AutoEmpleado.");
        });
}