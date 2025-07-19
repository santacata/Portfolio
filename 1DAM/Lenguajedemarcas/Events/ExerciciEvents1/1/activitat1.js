function cambiarEstilo() {
    var hojaEstilo = document.getElementById('stylesheet');
    
    // Verifica qué hoja de estilo está activa y cambia
    if (hojaEstilo.getAttribute('href') === 'estilo1.css') {
        hojaEstilo.setAttribute('href', 'estilo2.css');
    } else {
        hojaEstilo.setAttribute('href', 'estilo1.css');
    }
}
let textarea = document.getElementById("textarea");
function agregarletra(letra) {
    textarea.value += letra;
}