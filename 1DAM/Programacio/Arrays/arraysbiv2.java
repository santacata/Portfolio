import java.util.Arrays;
import java.util.Random;

public class arraysbiv2 {
    public static void main(String[] args) {
        int[][]matriz={{1,2,3},{4,5,6},{7,8,7}};
        System.out.println("recorrer matriz 1");

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.print(matriz[fila][columna]);
            }
            
        }
            System.out.println();
            System.out.println("Generar palabras");
System.out.println("Generar palabras");
        String[][] matriz3 = new String[3][7];
        System.out.println("Matriz 3:");

        for (int fila3 = 0; fila3 < matriz3.length; fila3++) {
            for (int columna3 = 0; columna3 < matriz3[fila3].length; columna3++) {
                matriz3[fila3][columna3] = palabraAleatoria(4);
            }
        }

        // Mostrar la matriz generada
        for (int fila3 = 0; fila3 < matriz3.length; fila3++) {
            for (int columna3 = 0; columna3 < matriz3[fila3].length; columna3++) {
                System.out.print(matriz3[fila3][columna3] + " ");
            }
            System.out.println();
        }
    }

    public static String palabraAleatoria(int longitud) {
        String caracteres = "qwertyuiopasdfghjklñzxcvbnm";
        Random rand = new Random();
        String palabraGenerada = "";

        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = rand.nextInt(caracteres.length());
            char letraAleatoria = caracteres.charAt(indiceAleatorio);
            palabraGenerada += letraAleatoria;
        }

        return palabraGenerada;
    }
}
