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
        int[][] matriu=new int [3][7];
        System.out.println("Recirrer matriu 2");
        for (int fila = 0; fila < matriu.length; fila++) {
            for (int columna = 0; columna < matriu.length; columna++) {
                // System.out.print(matriu[fila][columna]);
                matriu[fila][columna]=columna;

                
                //Mas facil
                System.out.println("Recorrer v2");
                System.out.println("\n"+Arrays.deepToString(matriu));
            }
            System.out.println("Matriuz3 Generar palabe¡ras");
            String[][] matriz3= new  String[3][7];
            System.out.println("Matriz3");
            for (int fila3 = 0; fila3 < matriz3.length; fila3++) {
                for (int columna3 = 0; columna3 < matriz3.length; columna3++) {
                    matriz3[fila3][columna3]= palabraAleatoria(4);

                    
                }
                
            }

        }
        
    }
    public static String palabraAleatoria(int longitud){
            String caracteres="qwertyuiopasdfghjklñzxcvbnm";
            Random rand= new Random();
            String palabraGenerada="";
            //Generar los caracteres
            for (int i = 0; i < longitud; i++) {
                int indiceAleatorio= rand.nextInt(caracteres.length());
            }
            return palabraGenerada;
    }
}
