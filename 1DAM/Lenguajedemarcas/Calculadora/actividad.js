function cambiarEstilo() {
    var hojaEstilo = document.getElementById('stylesheet');
    
    // Verifica qué hoja de estilo está activa y cambia
    if (hojaEstilo.getAttribute('href') === 'estilo1.css') {
        hojaEstilo.setAttribute('href', 'estilo2.css');
    } else {
        hojaEstilo.setAttribute('href', 'estilo1.css');
    }
}
// Espera a que el DOM esté completamente cargado antes de ejecutar el código, DOMContentLoader es porque sí
document.addEventListener("DOMContentLoaded", function() {
    // Asigna el elemento de la pantalla de la calculadora a la variable 'pantalla'
    let pantalla = document.getElementById("pantalla");

    // Inicializa variables para manejar la operación actual, anterior y la operación en curso
    let operacionActual = "";    // Contendrá el número o resultado actual que se está introduciendo
    let operacionAnterior = "";  // Contendrá el número de la operación anterior
    let operacionEnCurso = "";   // Contendrá el operador actual (+, -, *, /)


    // Función para agregar un número a la operación actual
    function agregarNumero(numero) {
        operacionActual += numero;  // Añade el número al final de la cadena de la operación actual
        if (pantalla) { // Verifica si el elemento pantalla está disponible
            pantalla.value = operacionActual;  // Muestra el número en la pantalla
        }
    }

    // Función para agregar un operador (+, -, *, /) a la operación
    function agregarOperacion(operacion) {
        if (operacionActual !== "") {  // Solo si hay un número en la operación actual
            operacionAnterior = operacionActual;  // Guarda el número actual como el anterior
            operacionActual = "";  // Borra la operación actual para ingresar el siguiente número
            operacionEnCurso = operacion;  // Establece el operador en curso
        }
    }

    // Función para agregar un punto decimal a la operación actual
    function agregarDecimal() {
        if (!operacionActual.includes(".")) {  // Solo si no hay un punto decimal en la operación actual
            operacionActual += ".";  // Añade un punto decimal
            if (pantalla) {
                pantalla.value = operacionActual;  // Muestra el número con el punto decimal en la pantalla
            }
        }
    }

    // Función para realizar el cálculo de la operación
    function calcular() {
        if (operacionAnterior !== "" && operacionActual !== "") {  // Asegura que haya tanto una operación anterior como una actual
            let resultado;  // Variable para almacenar el resultado del cálculo

            // Dependiendo del operador en curso, realiza la operación correspondiente
            switch (operacionEnCurso) {
                case "+":
                    resultado = parseFloat(operacionAnterior) + parseFloat(operacionActual);
                    break;
                case "-":
                    resultado = parseFloat(operacionAnterior) - parseFloat(operacionActual);
                    break;
                case "*":
                    resultado = parseFloat(operacionAnterior) * parseFloat(operacionActual);
                    break;
                case "/":
                    if (parseFloat(operacionActual) === 0) {  // Si se intenta dividir por cero
                        resultado = "Error";  // Muestra "Error" si la división es por cero
                    } else {
                        resultado = parseFloat(operacionAnterior) / parseFloat(operacionActual);
                    }
                    break;
            }

            if (pantalla) {
                pantalla.value = resultado;  // Muestra el resultado en la pantalla si había algo
            }

            // Resetea las variables para preparar la calculadora para una nueva operación
            operacionActual = resultado.toString();
            operacionAnterior = "";
            operacionEnCurso = "";
        }
    }

    // Función para limpiar la pantalla y las operaciones
    function limpiar() {
        operacionActual = "";  // Resetea la operación actual
        operacionAnterior = "";  // Resetea la operación anterior
        operacionEnCurso = "";  // Resetea el operador en curso
        if (pantalla) {
            pantalla.value = "";  // Borra el contenido de la pantalla si hay algo
        }
    }

    // Asigna las funciones de la calculadora a los botones de la interfaz
    window.agregarNumero = agregarNumero;
    window.agregarOperacion = agregarOperacion;
    window.agregarDecimal = agregarDecimal;
    window.calcular = calcular;
    window.limpiar = limpiar;
});
