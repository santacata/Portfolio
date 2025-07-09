    /* 6.- Escribir un programa que lea por teclado una hora cualquiera y un número n
que representa una cantidad en segundos. El programa mostrará la hora
introducida y las n siguientes, que se diferencian en un segundo. Para ello
hemos de diseñar previamente la clase Hora que dispone de los atributos hora,
minuto y segundo. Los valores de los atributos se controlarán mediante
métodos set/get. */

import java.time.LocalTime;
import java.util.Scanner;

public class Ejercicio6 {

public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    LocalTime horaActual=LocalTime.now();
    System.out.println("Esta es la hora"+horaActual);
    System.out.println("Dime cuántos segundos más quieres");
    int segundosDeMas=sc.nextInt();
    System.out.println("Esta es la hora + los segundos"+horaActual.plusSeconds((long)segundosDeMas));

}
}
