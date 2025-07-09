package FechasYHOras;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FechasLocalDate {
    public static void main(String[] args) {
        java.time.LocalDate fechaActual= java.time.LocalDate.now();
        System.out.println(fechaActual);

        //crear fecha pasando año, mes, dia por parametro
        LocalDate fecha = LocalDate.of(2020, 10, 5);
        System.out.println(fecha);
        //Leer una fecha de teclado o cadena de texzto
        LocalDate fecha2= LocalDate.parse("2020-23-25");
        System.out.println(fecha2);

        //metodos para obtener partes de la fecha
        System.out.println(fecha.getYear());
        System.out.println(fecha.getMonthValue());
        System.out.println(fecha.getMonth());
        System.out.println(fecha.getDayOfMonth());
        System.out.println(fecha.getDayOfWeek());

        //Metodo format para dar formato a las fechas con un patron indicado
        String fechaFormateada= fechaActual.format(DateTimeFormatter.ofPattern("dd/mm/yyy"));
        System.out.println(fechaFormateada);

        //Leer fechas del teclado
        //Metodo parse + DateTimeFormatter que indica el patron
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce una fecha en formato dd/MM/YYYY");
        

        //Formateador fecha introducida

        DateTimeFormatter formatoEntrada= DateTimeFormatter.ofPattern("dd/MM/YYYY");
        Locale.forLanguageTag("es - Es");
        //Leer entrada por el usuario
        LocalDate fechaUsuario= LocalDate.parse(sc.nextLine(), formatoEntrada);
        //fORMATEADOR DE sALIDA
        DateTimeFormatter formatoSalida=DateTimeFormatter.ofPattern("dd/mm/YYYY");

        //Mostrar fechas en el formato deseado
        System.out.println(fechaUsuario.format(formatoSalida));





        System.out.println("Escribe tu fecha de nacimiento");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYY");
        LocalDate nacimiento = LocalDate.parse(sc.nextLine(), formatter);

        int mes = nacimiento.getMonthValue();

        //Aquí va un if si el mes es mayor que x para averiguar la estacion

    }
    
        
}
