import java.util.Scanner;
public class arraysbidimensionales {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //DECLARACION DE MATRICES
        int datos[][]= new int [3][4]; 
        //Declarar una matriz con filas predefinidas y columnas variables
        int[][]peras=new int [4][];
        peras[0]= new int[3];
        peras[1]= new int[3];
        peras[2]= new int[4];
        peras[3]= new int[5];

        int[][] matriz4 = new int [][] {{1,2,3},{4,5,6},{7,8,9},{}};
        int filas =matriz4.length;
        int elementosFila0=matriz4[0].length;

        //Acceso a un elemento
        int []tercerarray=matriz4[2];
    }
}
