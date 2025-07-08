let marcador = 0;
let intervalo;
const movible = document.getElementById("movible");
const tablero = document.getElementById("tablero");
const marcadorElemento = document.getElementById("marcador");

function moverDiv() {
    const maxX = tablero.clientWidth - movible.clientWidth;
    const maxY = tablero.clientHeight - movible.clientHeight;
    const nuevoX = Math.floor(Math.random() * maxX);
    const nuevoY = Math.floor(Math.random() * maxY);
    movible.style.left = nuevoX + "px";
    movible.style.top = nuevoY + "px";
}

function reiniciarTemporizador() {
    clearInterval(intervalo);
    moverDiv();
    intervalo = setInterval(moverDiv, 1200);
}

movible.addEventListener("click", () => {
    marcador++;
    marcadorElemento.textContent = "Clics: " + marcador;
    reiniciarTemporizador();
});

reiniciarTemporizador();