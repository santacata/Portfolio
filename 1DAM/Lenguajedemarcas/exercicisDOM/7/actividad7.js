function ocultarElemento() {
    document.getElementById("ocultar").remove();
}
function mostrarElemento() {
    let nuevoParrafo = document.createElement("p"); // Crear el párrafo
    nuevoParrafo.textContent = "Este texto se puede ocultar o mostrar"; // Añadir texto
    nuevoParrafo.id = "ocultar";
    document.body.appendChild(nuevoParrafo); // Agregarlo al cuerpo del documento
}
