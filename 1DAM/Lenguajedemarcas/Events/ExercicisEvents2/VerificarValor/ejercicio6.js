window.onload = function() {
    const verificarBtn = document.getElementById('verificarBtn');
    const inputTexto = document.getElementById('inputTexto');
    const errorDiv = document.getElementById('error');

    // Función para manejar el clic del botón
    function verificarValor() {
        try {
            // Verificar si el campo está vacío
            if (inputTexto.value.trim() === "") {
                // Lanzamos un error si el campo está vacío
                throw new Error("El campo no puede estar vacío.");
            }

            // Si no hay error, mostramos un mensaje válido
            errorDiv.style.display = 'none'; // Ocultar el mensaje de error
            alert("El valor es válido.");

        } catch (error) {
            // Capturar el error y mostrar el mensaje en el div
            errorDiv.style.display = 'block'; // Mostrar el div con el error
            errorDiv.textContent = error.message; // Mostrar el mensaje de error
        }
    }

    // Asociamos la función al clic del botón
    verificarBtn.addEventListener('click', verificarValor);
}