let mensaje = document.getElementById('mensaje');

    // Función para detectar las teclas presionadas
    function pulsarTecla(event) {
        let mensajeTexto = 'Tecla presionada: ' + event.key + '\n';

        // Detectamos si las teclas modificadoras están presionadas
        if (event.altKey) {
            mensajeTexto += 'Se está presionando la tecla Alt.\n';
        }
        if (event.ctrlKey) {
            mensajeTexto += 'Se está presionando la tecla Ctrl.\n';
        }
        if (event.shiftKey) {
            mensajeTexto += 'Se está presionando la tecla Shift.\n';
        }

        // Si se presiona Alt + A, mostramos un mensaje especial
        if (event.altKey && event.key === 'a') {
            mensajeTexto = '¡Has presionado Alt + A! Mensaje especial.';
        }

        // Mostramos el mensaje
        mensaje.textContent = mensajeTexto;
        mensaje.style.display = 'block'; // Mostramos el mensaje en la página
    }

    // Escuchar el evento de keydown para detectar la tecla presionada
    document.addEventListener('keydown', pulsarTecla);