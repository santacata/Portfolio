/* 2. 
Crear una clase Matriz para manipular matrices cuadradas. 
Estructura el código en métodos y pasa como parámetros la dimensión n y 
el array bidimensional de números reales. Incluye también los siguientes 
métodos. 
a. 
b. 
c. 
Método para llenar una matriz de datos aleatorios 
Método para visualizar una matriz. 
Método que suma dos matrices dadas como parámetros y 
devuelve la matriz suma. 
d. 
Método que crea la matriz identidad, que es aquella que tiene 
1 en la diagonal y 0 el resto de celdas. 
e. 
Método que permite comprobar si una matriz cuadrada,  es o 
no simétrica con respecto a su diagonal principal. 
f. 
Método que dada una matriz que recibe como parámetro 
devuelva otra matriz invertida horizontalmente. 
g. 
Método que dada una matriz, calcule su matriz traspuesta. Se 
llama matriz traspuesta de una matriz, a la matriz que se obtiene al 
cambiar en a las filas por columnas o las columnas por filas. */
import java.util.Scanner;
public class ejercicio2 {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [][] matriz= crearmatrizaleatoria(sc);
        visualizarmatriz(matriz);
        int [][] matriz2=crearmatrizaleatoria(sc);
        visualizarmatriz(matriz2);
        int [][] sumadosmatrices=sumadosmatrices(matriz,matriz2);
        if (sumadosmatrices!=null) {
            visualizarmatriz(sumadosmatrices);
        }
        int[][] matrizIdentidad=crearmatrizidentidad(sc);
        visualizarmatriz(matrizIdentidad);
        if(comprobarsimetriamatriz(matrizIdentidad)==true){
        System.out.println("Es simetrica");
        }else{
            System.out.println("No es simetrica");
        }
        invertirhorizontalmentelamatriz(sumadosmatrices);
        transponerlamatriz(sumadosmatrices);
    } //fin main
    public static int[][] crearmatrizaleatoria(Scanner sc){
        
        System.out.println("Dime las la longitud");
        int longitud=sc.nextInt();
        int[][]matriz=new int[longitud][longitud];
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
                matriz[filas][columnas]=(int)(Math.random()*10); //Valores entre el 0 y el 9
            }
            
        }
        
        return matriz;
        

    }
    public static void visualizarmatriz(int matriz[][]){
        System.out.println("La matriz es:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|"+matriz[i][j]+"|");
            }
            System.out.println();
        }

    }
    public static int[][] sumadosmatrices(int matriz[][],int matriz2[][]){
        int[][]matrizsuma=matriz;
        if (matriz[0].length!=matriz2[0].length) {
            System.out.println("Las matrices tienen que ser iguales para sumarlas");
            return null;
            }
            
            
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizsuma[i][j]+=matriz2[i][j];
            }
        }
        return matrizsuma;
    }
    public static int[][]crearmatrizidentidad(Scanner sc){
        System.out.println("Dime las dimensiones de largo de la matriz identidad");
        int numeroidentidad=sc.nextInt();
        int[][]matrizidentidad=new int[numeroidentidad][numeroidentidad];
        for (int i = 0; i < matrizidentidad.length; i++) {
            for (int j = 0; j < matrizidentidad[i].length; j++) {
                if (i==j) {
                    matrizidentidad[i][j]=1;
                }else{
                    matrizidentidad[i][j]=0;
                }
            }
        }
        return matrizidentidad;
    }
    public static boolean comprobarsimetriamatriz(int[][]matrizIdentidad){
        boolean bandera=true;
        System.out.println("--Método para comprobar la simetría de la matriz respecto a su diagonal--");
        for (int i = 0; i < matrizIdentidad.length; i++) {
            for (int j = 0; j < matrizIdentidad.length; j++) {
                if (matrizIdentidad[i][j]!=matrizIdentidad[j][i]) {
                    bandera=false;
                }
            }
        }
        return bandera;

    }
    public static void invertirhorizontalmentelamatriz(int[][]matriz){
        System.out.println("--Invertir y mostrar horizontalmente una matriz--");
        for (int i = matriz.length-1; i >= 0; i--) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|"+matriz[i][j]+"|");
            }
            System.out.println();
        }
    }
    public static void transponerlamatriz(int[][]matriz){
        System.out.println("--Transponer y mostrar horizontalmente una matriz--");
        for (int i = matriz.length-1; i >= 0; i--) {
            for (int j = matriz[i].length-1; j >= 0; j--) {
                System.out.print("|"+matriz[i][j]+"|");
            }
            System.out.println();
        }
    }
}