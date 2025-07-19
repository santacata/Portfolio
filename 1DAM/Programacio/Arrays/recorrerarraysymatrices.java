import java.util.Arrays;

public class recorrerarraysymatrices {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        recorrerArrayForEach(arrays);

        System.out.println(Arrays.toString(arrays));

        int[][] matrizUno = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        recorrerMatrices(matrizUno);
    }

    static void recorrerArrayForEach(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(); // para salto de línea
    }

    static void recorrerMatrices(int[][] matriz) {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // salto de línea tras cada fila
        }
    }
}
