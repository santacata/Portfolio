package FechasYHOras;

import java.util.Calendar;

public class Calendario {
    //Uso de la clase calendar en java
    public static void main(String[] args) {
        Calendar cal =Calendar.getInstance(); //Crea el objeto con la fecha y hora actual
        System.out.println("Ahora cal es: "+cal.getTime());
        //Asignamos la hora
        cal.set(2025, 2, 19);
        System.out.println(cal.getTime());
        //Fecha la misma pero ahora la hora paso a paso
        cal.set(Calendar.HOUR, 16);
        cal.set(Calendar.MINUTE, 16);
        cal.set(Calendar.SECOND, 16);

        //pARA OBTENER UN VALOR DE UN CMAPO DE LA FECHA

        System.out.println("El mes es "+cal.get(Calendar.MONTH)); //Por defecto es 0

        //Operacion senzilla con fechas
        Calendar hoy= Calendar.getInstance();
        hoy.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println("Resto tres dias: "+hoy.getTime());

        //Metodos After Y Before Comparar tipos Calendar entre si
        System.out.println();
        Calendar dia = Calendar.getInstance();

        System.out.println(dia.getTime());
        System.out.println(cal.getTime());
        if (dia.after(cal)) {
            System.out.println("es posterior");
        }
        if (dia.before(hoy)) {
            System.out.println("Es Anterior");
        }
    }
}
