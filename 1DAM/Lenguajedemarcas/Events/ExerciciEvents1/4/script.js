document.addEventListener("DOMContentLoaded", function () {
  const formulario = document.getElementById("formulario");
  const inputs = formulario.querySelectorAll("input");

  inputs.forEach(input => {
    input.addEventListener("focus", function () {
      this.style.borderColor = "blue";
    });

    input.addEventListener("blur", function () {
      if (this.id === "email" && !this.value.includes("@")) {
        this.style.borderColor = "red";
      } else {
        this.style.borderColor = "gray";
      }
    });

    input.addEventListener("keyup", function () {
      if (this.value.trim() !== "") {
        this.style.borderColor = "green";
      } else {
        this.style.borderColor = "gray";
      }
    });
  });

  formulario.addEventListener("submit", function (e) {
    const nombre = document.getElementById("nombre").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    let valido = true;
    let mensaje = "";

    if (nombre === "") {
      mensaje += "- El nombre no puede estar vacío.\n";
      valido = false;
    }

    if (!email.includes("@") || email.startsWith("@") || email.endsWith("@")) {
      mensaje += "- El email debe contener un '@' válido.\n";
      valido = false;
    }

    if (password === "") {
      mensaje += "- La contraseña no puede estar vacía.\n";
      valido = false;
    }

    if (!valido) {
      alert("Corrige los siguientes errores:\n\n" + mensaje);
      e.preventDefault(); // Bloquea el envío
    }
  });
});


