const infoDiv = document.getElementById("info");

// Función para manejar los eventos de teclado
function mostrarInfo(event) {
    let tipoEvento = event.type; // Tipo de evento (keydown, keypress, keyup)
    let codigoTecla = event.charCode; // Código de la tecla (keyCode o charCode)
    let teclaPulsada = event.key; // Caracter exacto de la tecla pulsada (esto maneja mayúsculas/minúsculas)

    // Mostrar la información en el div
    infoDiv.innerHTML = `
        <strong>Tipo de evento:</strong> ${tipoEvento} <br>
        <strong>Código de la tecla:</strong> ${codigoTecla} <br>
        <strong>Carácter pulsado:</strong> ${teclaPulsada}
    `;
    if (codigoTecla==0) { //Si no presionem res no mostra res per pantalla
        infoDiv.innerHTML='';
    }
}

// Asociar los eventos de teclado a la función mostrarInfo
document.addEventListener("keydown", mostrarInfo);
document.addEventListener("keypress", mostrarInfo);
document.addEventListener("keyup", mostrarInfo);