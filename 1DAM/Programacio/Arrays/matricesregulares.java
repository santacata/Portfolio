public class matricesregulares {
    public static void main(String[] args) {
        int[][]matrizA={{1,2,3},{4,5,6},{7,8,9}};
        int[][]matrizB={{1,2,3},{6,5,6},{7,8,9}};
       
        System.out.println(matricesIguales(matrizA, matrizB));
        System.out.println(matrizmaxima(matrizA, matrizB));
    }
    public static boolean matricesIguales(int matrizA[][], int matrizB[][]){
    for (int filas = 0; filas < matrizA.length; filas++) {
        for (int columnas = 0; columnas < matrizB.length; columnas++) {
             if (matrizA[filas][columnas]!=matrizB[filas][columnas]) {
            return false;
        }
        }
       
    }
        return true;
        
    }
    static String matrizmaxima(int[][]matrizA, int[][]matrizB){
        int a=0;
        int b=0;
        for (int filas = 0; filas < matrizA.length; filas++) {
            for (int columnas = 0; columnas < matrizB.length; columnas++) {
                a+=matrizA[filas][columnas];
                b+=matrizB[filas][columnas];
            }
        }
        if (a<b){
            return "La cadena más grande es la segunda";
        }else
            return "La cadena más grande es la primera";
    }
    
}
