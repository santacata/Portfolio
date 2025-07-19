package Dias;

import java.util.Scanner;

public class UsoDay {
 public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);

    System.out.println("Day lunes imprime:"+Day.LUNES);
    System.out.println("Actividad del lunes"+Day.LUNES.getActividad());
    System.out.println("Get numero sabado"+Day.SABADO.getNumeroDia());

    //Mostrar todos los dias de enumeros
    Day.mostrarTodosLosDias();

    sc.close();
 }   
}
