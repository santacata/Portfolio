let banderas = {
    "España": "rojo, amarillo",
    "Francia": "azul, blanco, rojo",
    "Italia": "verde, blanco, rojo",
    "Alemania": "negro, rojo, amarillo",
    "Brasil": "verde, amarillo, azul",
    "Argentina": "azul, blanco, amarillo"
  };

  let puntos = 0;
  let paisActual = "";

  function generarPregunta() {
    const paises = Object.keys(banderas);
    const indice = Math.floor(Math.random() * paises.length);
    paisActual = paises[indice];
    document.getElementById("pais").textContent = paisActual;
    document.getElementById("respuesta").value = "";
    document.getElementById("mensaje").textContent = "";
  }

  function normalizar(texto) {
    return texto
      .toLowerCase()
      .split(",")
      .map(c => c.trim())
      .filter(c => c !== "")
      .sort()
      .join(",");
  }

  function comprobarRespuesta() {
    let respuestaUsuario = normalizar(document.getElementById("respuesta").value);
    let respuestaCorrecta = normalizar(banderas[paisActual]);
    let mensaje= document.getElementById("mensaje");

    if (respuestaUsuario === respuestaCorrecta) {
      puntos++;
      mensaje=document.getElementById("mensaje").innerHTML = "<strong>¡Correcto! 🎉</strong>";
    } else {
      puntos--;
      mensaje=document.getElementById("mensaje").innerHTML = `❌ <strong>Incorrecto</strong>. La respuesta correcta es: <em>${banderas[paisActual]}</em>`;
    }

    document.getElementById("puntos").textContent = puntos;
    setTimeout(() => {
        generarPregunta();
      }, 4000);
  }

  function finalizarJuego() {
    alert("Puntuación final: " + puntos);
  }

  generarPregunta();