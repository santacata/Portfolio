import java.util.Scanner;

public class arrayssobredimensionats {

    public static void main(String[] args) {
        final int CAPACIDAD = 5;
        Scanner sc = new Scanner(System.in);

        int cantidad = 0;
        String[] nombreS = new String[CAPACIDAD];

        // Pedir los nombres
        System.out.println("Escribe " + CAPACIDAD + " nombres:");

        for (int i = 0; i < CAPACIDAD; i++) {
            System.out.print("Introduce un nombre: ");
            String nombreUsuario = sc.nextLine();

            if (cantidad < CAPACIDAD) {
                nombreS[cantidad] = nombreUsuario;
                cantidad++;
            }
        }

        // Mostrar los nombres
        System.out.println("\nNombres almacenados:");
        for (int j = 0; j < cantidad; j++) {
            System.out.println((j + 1) + ". " + nombreS[j]);
        }

        // Pedir posición a borrar
        int posicionABorrar = -1;
        while (true) {
            System.out.print("\nElige una posición a borrar (1 - " + cantidad + "): ");
            if (sc.hasNextInt()) {
                posicionABorrar = sc.nextInt();
                sc.nextLine(); // Limpiar el salto de línea
                if (posicionABorrar >= 1 && posicionABorrar <= cantidad) {
                    break;
                } else {
                    System.out.println("Número fuera de rango.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                sc.next(); // Limpiar entrada inválida
            }
        }

        // Eliminar el elemento (creando un nuevo array)
        String[] nuevoArray = new String[cantidad - 1];
        int j = 0;
        for (int i = 0; i < cantidad; i++) {
            if (i != posicionABorrar - 1) {
                nuevoArray[j++] = nombreS[i];
            }
        }

        // Mostrar el nuevo array
        System.out.println("\nNombres después de borrar:");
        for (int i = 0; i < nuevoArray.length; i++) {
            System.out.println((i + 1) + ". " + nuevoArray[i]);
        }
    }
}
