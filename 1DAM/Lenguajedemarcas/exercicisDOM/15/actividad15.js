function mostrarTexto() {
    // Obtener el valor del campo de texto
    var texto = document.getElementById('textoUsuario').value;
    
    // Crear un nuevo párrafo
    var parrafo = document.createElement('p');
    
    // Asignar el texto ingresado al párrafo
    parrafo.textContent = "Texto ingresado: " + texto;
    
    // Insertar el párrafo en el div con id "resultado"
    document.getElementById('resultado').appendChild(parrafo);
    
}