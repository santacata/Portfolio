document.addEventListener('click', function(event) {
    // Obtener las coordenadas respecto a la ventana
    const clientX = event.clientX;
    const clientY = event.clientY;

    // Obtener las coordenadas respecto a la pantalla
    const screenX = event.screenX;
    const screenY = event.screenY;

    // Obtener las coordenadas respecto a la página
    const pageX = event.pageX;
    const pageY = event.pageY;

    // Mostrar un alert con las coordenadas
    alert(`
        Coordenadas del ratón:
        - Respecto a la ventana (clientX/Y): ${clientX}, ${clientY}
        - Respecto a la pantalla (screenX/Y): ${screenX}, ${screenY}
        - Respecto a la página (pageX/Y): ${pageX}, ${pageY}
    `);
});