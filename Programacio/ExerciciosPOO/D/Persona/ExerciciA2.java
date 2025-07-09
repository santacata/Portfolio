package Persona;

import java.util.Scanner;

public class ExerciciA2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingresa los datos de la primera persona:");
        System.out.print("ID: ");
        String id1 = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre1 = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido1 = entrada.nextLine();
        System.out.print("Edad: ");
        int edad1 = entrada.nextInt();
        entrada.nextLine();

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
        Persona persona3 = new Persona(); // Por defecto

        
        System.out.println(persona1.getterNom() + " " + persona1.getterApellidos() + " con ID " + persona1.getterDNI() + (persona1.getterEdad() >= 18 ? " es adulto." : " es menor de edad."));
        System.out.println(persona2.getterNom() + " " + persona2.getterApellidos() + " con ID " + persona2.getterDNI() + (persona2.getterEdad() >= 18 ? " es adulto." : " es menor de edad."));
        System.out.println(persona3.getterNom() + " " + persona3.getterApellidos() + " con ID " + persona3.getterDNI() + (persona3.getterEdad() >= 18 ? " es adulto." : " es menor de edad."));

        entrada.close();
    }
}