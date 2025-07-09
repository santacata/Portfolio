import java.util.Arrays;

public class recorrerarraysymatrices {
    public static void main(String[] args) {
        int[]arrays={1,2,3,4,5,6,7,8,9};
        recorrerArrayForEach(arrays);

        System.out.println(Arrays.toString(arrays));

        int[][] matrizUno={{1,2,3},{4,5,6},{7,8,9}};
        recorrerMatrices(matrizUno);
        
    }
    static void recorrerMatrices(int[][]matriz){
        for (int i = 0; i < matriz[i].length; i++) {
            Arrays.toString(matriz);
            System.out.println();
        }
        
    }
    static void recorrerArrayForEach(int[]a){
        for (int i : a) {
            System.out.println(i+" ");
        }
        System.out.println(" ");
    }
}
