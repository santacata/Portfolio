/* 1. Programa que realiza la carga de datos de una matriz de 4 filas y 5
columnas con valores numéricos introducidos por el usuario y utiliza un
método para obtener la media aritmética de una determinada columna que
seleccione el usuario. */
import java.util.Scanner;
public class ejercicio1 {
  public static void main(String[] args) {
    int[][]matriz=new int[4][5];
    int total=0;
    double media=0;
    int numeroelegido;
    int contador=0;
        Scanner sc=new Scanner(System.in);
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz.length; columnas++) {
                System.out.println("Dime un numero para ["+filas+"]["+columnas+"]");
                matriz[filas][columnas]=sc.nextInt();
                media+=matriz[filas][columnas];
            }
            
        }
        System.out.println("Introduce el numero de la columna que quieres seleccionar");
        numeroelegido=sc.nextInt();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (j-1==numeroelegido) {
                    total+=matriz[i][j];
                    contador++;
                }
            }
        }
        media=total/contador;
        System.out.println("La media es "+media);
        sc.close();
    }
}