function moverElemento() {
    let elemento = document.getElementById("elemento");
    let contenedor1 = document.getElementById("contenedor1");
    let contenedor2 = document.getElementById("contenedor2");

    // Mueve el elemento al otro contenedor según su ubicación actual
    if (elemento.parentElement === contenedor1) {
        contenedor2.appendChild(elemento);
    } else if (elemento.parentElement === contenedor2){
        contenedor1.appendChild(elemento);
    }
}