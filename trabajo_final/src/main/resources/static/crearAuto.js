function crearAuto() {
    const patente = document.getElementById("patente").value;
    const modelo = document.getElementById("modelo").value;
    const color = document.getElementById("color").value;

    const data = {
        patente: patente,
        modelo: modelo,
        color: color
    };

    fetch('/autos/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert("Auto fue creado con exito.");
                window.location.href = "htmlAuto.html"
            } else {
                alert("Auto fallo al intentar crearse.");
                window.location.href = "htmlAuto.html"
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Un error ocurrio al crear Auto.");
        });
}