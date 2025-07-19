import java.util.Scanner;

public class EjemploEnum {
    //Definicion para los dias de la semana
    public enum DiasDeLaSemana{
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    }

    //ACCEDER A UN VALOR ENUM
    public static void main(String[] args) {
        System.out.println("Ejemplo de uso de enum");
         DiasDeLaSemana diaDeHoy= DiasDeLaSemana.VIERNES;
         //Asignamos un valor al enum

         System.out.println("El dia de hoy es "+diaDeHoy+"y su posicion es"+diaDeHoy.ordinal());

         //Valueof
         System.out.println("Introduce el dia de la semana");
         Scanner sc= new Scanner(System.in);
         String texto=sc.nextLine().toUpperCase();
         DiasDeLaSemana diaDeHoy2=DiasDeLaSemana.valueOf(texto);
         //Convierte el valor a enum
         System.out.println("El dia de hoy es "+diaDeHoy2+" y su posicion es"+diaDeHoy2.ordinal());

         System.out.println("\n Dias de la semana disponibles");
         DiasDeLaSemana[]dias=DiasDeLaSemana.values();
         //Almacenamos en un array los valores con values
    for (DiasDeLaSemana d : DiasDeLaSemana.values()) {
        System.out.println(d);
    }
    //Obtener un valor de enum a partir de los valores introducidos por el usuario
    System.out.println("introduce el dia de la semana");
    String inputDia=sc.nextLine().toUpperCase();
    boolean encontrado=false;
    for (DiasDeLaSemana d : DiasDeLaSemana.values()) {
        if (d.name().equals(inputDia)) {
            System.out.println("Has encontrado "+ d);
            encontrado=true;
            break;
        }
    }
    //Obtener un valor de enum a partir de su posicion ordinal
    System.out.println("Introduce un numero del 1 al 7 para saber el dia");
    int indice=sc.nextInt();
    if (indice<8&&indice>0) {
        DiasDeLaSemana diaPorNumero= DiasDeLaSemana.values()[indice-1];
        System.out.println("El dia seleccionado es "+diaPorNumero);
        
    }
    //uso de switch con enum
    System.out.println("¿Qué día es hoy?");
    sc.nextLine(); //para borrar el intro de antes
    String diaNuevo=sc.nextLine().toUpperCase();

    boolean esValido=false;
    for (DiasDeLaSemana d : DiasDeLaSemana.values()) {
        if (d.name().equals(diaNuevo)){
            esValido=true;
            switch (d) {
                case LUNES:
                    
                    break;
                    case VIERNES:
                        System.out.println("Es viernes");
                    break;
            
                    case SABADO:
                    case DOMINGO:
                    System.out.println("Es finde");
                    break;
            
            
                default:
                System.out.println("Un dia cualquiera");
                    break;
            }
            
        }
    }
    if (!esValido) {
        System.out.println("Dia no valido");
        
    }
        System.out.println();
    

    
    
    
    
    }
    
}