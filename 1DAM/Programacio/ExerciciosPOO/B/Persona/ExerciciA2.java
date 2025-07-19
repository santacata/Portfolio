package Persona;

import java.util.Scanner;

public class ExerciciA2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear dos objetos persona
        System.out.println("Ingresa los datos de la primera persona:");
        System.out.print("ID: ");
        String id1 = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre1 = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido1 = entrada.nextLine();
        System.out.print("Edad: ");
        int edad1 = entrada.nextInt();
        entrada.nextLine(); // Consumir salto de línea

        Persona persona1 = new Persona(id1, nombre1, apellido1, edad1);

        System.out.println("Ingresa los datos de la segunda persona:");
        System.out.print("ID: ");
        String id2 = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre2 = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido2 = entrada.nextLine();
        System.out.print("Edad: ");
        int edad2 = entrada.nextInt();

        Persona persona2 = new Persona(id2, nombre2, apellido2, edad2);
        Persona persona3 = new Persona(); //Per deefecte

        // Mostrar mensajes sobre si son mayores de edad
        System.out.println(persona1.nom + " " + persona1.apellidos + " con ID " + persona1.dni + ( persona1.edad >= 18 ? " es adulto." : " es menor de edad."));
        System.out.println(persona2.nom + " " + persona2.apellidos + " con ID " + persona2.dni + (persona2.edad >= 18 ? " es adulto." : " es menor de edad."));
        System.out.println(persona3.nom + " " + persona3.apellidos + " con ID " + persona3.dni + (persona3.edad >= 18 ? " es adulto." : " es menor de edad."));

        entrada.close();
    }
}
