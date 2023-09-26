function modificarAuto(Auto) {
    const patente = Auto.patente.value;
    const modelo = Auto.modelo.value;
    const color = Auto.color.value;

    const data = {
        patente: patente,
        modelo: modelo,
        color: color
    };

    fetch('/autos/crear', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert("Auto fue modificado con exito.");
            } else {
                alert("Auto fallo al intentar modificarse.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Un error ocurrio al modificar Auto.");
        });
}