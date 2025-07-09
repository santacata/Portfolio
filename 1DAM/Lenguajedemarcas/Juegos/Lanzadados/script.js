var imagenesDado=[
    "imgs/1.png",
    "imgs/2.png",
    "imgs/3.png",
    "imgs/4.png",
    "imgs/5.png",
    "imgs/6.png"
];
var dado=document.getElementById("dado");
var btnlanzar=document.getElementById("buttonLanzar");
var contenedor=document.getElementById("estadisticas");

function numeroAleatorio() {
    return Math.floor(Math.random()*6)+1;
}
function lanzarDado() {
    dado.src="imgs/roll.gif";
    btnlanzar.style.display="none"; //Desactiva el boton lanzar

    setTimeout (function() {
        var resultado = numeroAleatorio();
        dado.src=imagenesDado[resultado-1];
        btnlanzar.style.display="block";
    }, 2000);
}

function iniciar() {
    btnlanzar.addEventListener("click", lanzarDado);
    btnEstadisticas.addEventListener("click", mostrarEstadisticas);
    reiniciar.addEventListener("click", reiniciarEstadisticas);
}
window.onload=function(){
    iniciar();
}