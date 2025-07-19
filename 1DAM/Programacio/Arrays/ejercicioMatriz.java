public class ejercicioMatriz {
    public static void main(String[] args) {
        int n = 4; // tamaño de la matriz
        int[][] m = new int[n][n];

        crearmatriz(m); // rellenar con valores aleatorios 0 y 1
        imprimirmatriz(m); // imprimir con 'X' para 1 y '-' para 0
    }

    static void crearmatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2); // 0 o 1 aleatorio
            }
        }
    }

    static void imprimirmatriz(int[][] m) {
        for (int[] fila : m) {
            for (int valor : fila) {
                if (valor == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}
