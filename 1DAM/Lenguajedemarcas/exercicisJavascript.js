<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo JS</title>
</head>
<body>

<script>
    //1
    /* Crea una función llamada sumar que tome dos números como argumentos y devuelva su
suma. Luego, llama a la función con diferentes valores. */
    function sumar(n1, n2){
    return (n1+n2);};
    console.log(sumar(8,9));
    //2
    /* Crea un objeto coche con una propiedad velocidad y un método acelerar que incremente la
velocidad en 10. Usa this para acceder a la propiedad velocidad. */
    let velocidad=0;
    function acelerar(){
    this.velocidad+=10;
    return this.velocidad;
    };
    //3
    /* Convierte la función sumar del ejercicio 1 en una arrow function. */
    //sumar(n1, n2)=>(n1+n2);
    console.log(sumar(8,9));
    //4
    /* Dada la cadena "JavaScript es genial", usa métodos de cadenas para:4.
Convertirla a mayúsculas.
Obtener la longitud de la cadena.
Extraer la palabra "es".
Reemplazar "genial" por "increíble". */
    let cadena="Javascript és genial";
    console.log(cadena.toUpperCase());
    console.log(cadena.length());
    console.log(cadena.substring(11,13));
    console.log(cadena.replace("genial","increible"));
    //5
    /* Ejercicio: Dado el array [1, 2, 3, 4, 5], realiza las siguientes operaciones:1.
Añade el número 6 al final.
Elimina el primer elemento.
Invierte el array.
Une los elementos en una cadena separada por comas */
    let array = [1,2,3,4,5];
    array.push(6); //Introduce el 6
    array.shift(); //Elimina el primer elemento
    array.reverse(); //Invierte el orden
    array.join(", "); //Une los elementos del array separados con lo que le indicamos

    console.log(array); // Llamamos a la función
    //6
    /* Crea una función presentar que tome dos argumentos (nombre y edad) y muestre un
mensaje como "Hola, soy [nombre] y tengo [edad] años". Usa apply para llamar a la función
con un contexto específico */
    function presentar(nombre, edad){
        let frase={};
        frase.apply(nombre,edad);
    }
    //7
    /* Escribe una función que tome dos números y devuelva true si la división de ambos es un
    número finito, y false si es Infinity o NaN. */
    function divisible(n1,n2){
        if (n1%n2==0) {
            return true;
        }else{
            return false;
        }
    }
    //8
    /* Usa una arrow function para filtrar los números pares de un array. */

    //9
    /* Crea una función calcular que tome un array de números y devuelva un objeto con las
siguientes propiedades:
suma: La suma de todos los números.
promedio: El promedio de los números.
max: El número más grande.
min: El número más pequeño. */
let array2= [1,2,3,4,5,6,7,8,9,10];
    function sumarArray(array){
      let suma=0;
      for(let i=0; i<array.length; i++){
        suma+=array[i];
      }
      return suma;
    }
    function promedioArray(array){
      let suma=0;
      for(let i=0; i<array.length; i++){
        suma+=array[i];
      }
      return suma/array.length;
    }
    function maxArray(array){
      let max=array[0];
      for(let i=1; i<array.length; i++){
        if(array[i]>max){
          max=array[i];
        }
      }
      return max;
    }
    function minArray(array){
      let min=array[0];
      for(let i=1; i<array.length; i++){
        if(array[i]<min){
          min=array[i];
        }
      }
      return min;
    }
</script>

</body>
</html>