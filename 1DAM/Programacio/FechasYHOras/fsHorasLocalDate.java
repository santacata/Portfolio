package fsYHOras;

import java.time.LocalDateTime;

public class fsHorasLocalDate {
    public static void main(String[] args) {
        //Esta clase podemos trabajar con fHoraActual y hora a la vez
        //Mismos metodos que localdate y localtime

        LocalDateTime fHoraActual = LocalDateTime.now();
        System.out.println(fHoraActual);
        //fHoraActual y hora 
        //metodos para obtener partes de la fHoraActual
        System.out.println(fHoraActual.getYear());
        System.out.println(fHoraActual.getMonthValue());
        System.out.println(fHoraActual.getMonth());
        System.out.println(fHoraActual.getDayOfMonth());
        System.out.println(fHoraActual.getDayOfWeek());

        //Crear hora
        LocalDateTime fechaHora=LocalDateTime.of(2025,4,19,16,15,1);

    }
}
