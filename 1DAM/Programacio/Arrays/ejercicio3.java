/* 3. 
Este ejercicio consiste en realizar un programa que haga lo siguiente. 
1. 
En primer lugar se leerá por teclado los datos de la matriz (nº 
de filas m, nº de columnas n). 
2. 
3. 
A continuación se creará la matriz mxn . 
Se generarán los valores de los elementos de la matriz de 
manera aleatoria, con número del 0 al 90. 
4. 
El programa preguntará al usuario qué fila y qué columna 
desea eliminar. 
5. 
El usuario introducirá estos datos por teclado. Se comprobará 
que la fila y la columna especificadas existen realmente (por ejemplo, 
en una matriz 5x3 no se puede eliminar la fila -1, ni la columna 4). 
6. 
Se creará otra matriz de tamaño (m-1)x(n-1). En esta matriz se 
copiarán los elementos de la matriz original, exceptuando los 
elementos de la fila y la columna eliminadas. 
7. 
Finalmente, se escribirán por pantalla las dos matrices, la 
original y el resultado de eliminar la fila y la columna especificadas.  */

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        System.out.println("--Introduce las filas--");
        int filas = pedirNumeroPositivo();
        System.out.println("--Introduce las columnas--");
        int columnas = pedirNumeroPositivo();

        int[][] matriz = rellenarConAleatorios(crearMatriz(filas, columnas));

        System.out.println("Matriz generada:");
        mostrarMatriz(matriz);

        int filaAEliminar = verificarFila(matriz);
        int columnaAEliminar = verificarColumna(matriz);

        int[][] matrizResultante = eliminarFilaYColumna(matriz, filaAEliminar, columnaAEliminar);

        System.out.println("Matriz resultante:");
        mostrarMatriz(matrizResultante);
    }

    public static int pedirNumeroPositivo() {
        Scanner scanner = new Scanner(System.in);
        int numero;
        while (true) {
            System.out.print("Introduce un número entero positivo: ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero > 0) {
                    return numero;
                }
            } else {
                scanner.next(); // Consumir entrada inválida
            }
            System.out.println("Por favor, introduce solo números enteros positivos.");
        }
    }

    public static int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }

    public static int[][] rellenarConAleatorios(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 91); // Números entre 0 y 90
            }
        }
        return matriz;
    }

    public static int verificarFila(int[][] matriz) {
        System.out.println("--Introduce la fila a eliminar--");
        while (true) {
            int fila = pedirNumeroPositivo();
            if (fila <= matriz.length) {
                return fila - 1;
            }
            System.out.println("El valor tiene que estar entre 1 y " + matriz.length);
        }
    }

    public static int verificarColumna(int[][] matriz) {
        System.out.println("--Introduce la columna a eliminar--");
        while (true) {
            int columna = pedirNumeroPositivo();
            if (columna <= matriz[0].length) { //Porque todas las columnas tienen la misma longitud
                return columna - 1;
            }
            System.out.println("Tienes que poner un numero entre 1 y " + matriz[0].length);
        }
    }

public static int[][] eliminarFilaYColumna(int[][] matriz, int filaAEliminar, int columnaAEliminar) {
    int[][] nuevaMatriz = new int[matriz.length - 1][matriz[0].length - 1];

    int nuevaFila = 0;
    for (int i = 0; i < matriz.length; i++) {
        if (i != filaAEliminar) {
            int nuevaColumna = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                if (j != columnaAEliminar) {
                    nuevaMatriz[nuevaFila][nuevaColumna] = matriz[i][j];
                    nuevaColumna++;
                }
            }
            nuevaFila++;
        }
    }

    return nuevaMatriz;
}

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print("["+ elemento+"]");
            }
            System.out.println();
        }
    }
}

