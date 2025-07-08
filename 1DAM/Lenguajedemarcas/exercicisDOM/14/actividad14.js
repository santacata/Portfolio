function conTemporizador() {
    setTimeout(function() {
        document.getElementById('mensaje').textContent = 'Texto cambiado después de 3 segundos';
    }, 3000);
}