function cambiarPosicion() {
    //Esto aplica un css que cambia la posición de los elementos
    let nuevoLink = document.createElement("link"); // Crear el elemento <link>
    nuevoLink.rel = "stylesheet"; // Establecer el atributo rel
    nuevoLink.href = "styles.css"; // Establecer el atributo href
    document.head.appendChild(nuevoLink); // Agregarlo al <head> en lugar de <body>
}