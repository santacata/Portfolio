
import java.util.Scanner;

public class Casa {
    private String direccion;
    private Ventana[] ventanas;
    private Habitacion[] habitaciones;
    private int cantidadHabitaciones;

    public Casa(String direccion, int MaxHabitaciones){
    this.direccion = direccion;
        ventanas = new Ventana[3];
        ventanas[0] = new Ventana("Ventana Salon", 120, 60);
        ventanas[1] = new Ventana("Ventana Cocina", 120, 60);
        ventanas[2] = new Ventana("Ventana Dormitorio", 120, 60);
    
        this.habitaciones = new Habitacion[MaxHabitaciones];
        this.cantidadHabitaciones = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < habitaciones.length; i++) {
            System.out.println("Introduce el tipo de habitacion:");
            String tipo = sc.nextLine();
            agregarHabitacion(tipo);
            
        }

    }

    public void setVentanas(Ventana ventanas[]) {
        this.ventanas = ventanas;
    }

    public String getDireccion(){
        return direccion;
    }

    public void mostrarInformacion(){
        System.out.println("Casa en " + direccion);
        System.out.println("Ventanas: ");

        for (int i = 0; i < ventanas.length; i++) {
            ventanas[i].mostrarInformacion();
        }

        System.out.println("Habitaciones");
        for (int i = 0; i < cantidadHabitaciones; i++) {
            habitaciones[i].mostrarInfo();
        }
    }

    //Metodo para agregar habitaciones despues de crear la casa
    private  void agregarHabitacion(String tipo){
        if (cantidadHabitaciones < habitaciones.length) {
            habitaciones[cantidadHabitaciones] = new Habitacion(tipo);
            //Se crea dentro de la casa.
            cantidadHabitaciones++;
            
        } else{
            System.out.println("No se pueden agregar más habitaciones.");
        }
    }
}
