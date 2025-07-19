import java.util.Scanner;

public class hundirlaflota { //Class

    public static void main(String[] args) { //Main
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Vamos a hacer la cuadrícula inicial------");
        String[][] cuadricula = crearcuadriculainicial();
        System.out.println("Selecciona 1 o 2 para si quieres que los barcos se asignen automáticamente o manualmente");
        int opcion = verificarqueseaunoudos(scanner);
        int barcosTotales = 1 * 3 + 2 * 2 + 3 * 1; // Total de celdas con barcos;

        if (opcion == 1) {
            colocarBarcosEnTablero(cuadricula);
        } else {
            colocarbarcosmanualmente(scanner, cuadricula);
        }

        System.out.println("Cuadrícula con barcos colocados (oculta para jugador real):");
        mostrarcuadricula(cuadricula, false);

        jugarPartida(scanner, cuadricula, barcosTotales);
    } //Fin main

    public static void jugarPartida(Scanner scanner, String[][] cuadricula, int barcosRestantes) {
        int intentosMaximos = (cuadricula.length * cuadricula.length) / 2;
        int intentosRealizados = 0;

        while (barcosRestantes > 0 && intentosRealizados < intentosMaximos) {
            System.out.println("\nIntroduce coordenadas para disparar:");
            int[] coordenadas = pedirCoordenadasAlfanumericas(scanner, cuadricula.length);
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            if (cuadricula[fila][columna].equals("B")) {
                System.out.println("Tocado y hundido!");
                cuadricula[fila][columna] = "X";
                barcosRestantes--;
                // No se restan intentos por acierto
            } else if (cuadricula[fila][columna].equals("~")) {
                System.out.println("Agua.");
                cuadricula[fila][columna] = "*";
                intentosRealizados++; // Solo fallar resta intentos
            } else {
                System.out.println("Ya has disparado ahí.");
                // No se restan intentos por repetir
            }

            System.out.println("Intentos restantes: " + (intentosMaximos - intentosRealizados));


            mostrarcuadricula(cuadricula, false);
            System.out.println("Barcos restantes: " + barcosRestantes);
        }

        if (barcosRestantes == 0) {
        System.out.println("¡Has hundido todos los barcos! Felicidades, has ganado.");
        } else {
        System.out.println("Te has quedado sin intentos. Los barcos sobreviven... por ahora.");
        }
        System.out.println("\nAsí quedó el tablero con los barcos revelados:");
        mostrarcuadricula(cuadricula, true);

    }

    public static String[][] crearcuadriculainicial() {
        String[][] matriz = new String[10][10]; // Cuadrícula de 10x10
        for (int i = 0; i < matriz.length; i++) { //Rellenar la cuadrícula con agua
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "~"; // Agua
            }
        }
        return matriz;
    } //Fin crearcuadriculainicial

    public static int verificarqueseaunoudos(Scanner scanner) {
        int numero;
        while (true) {
            System.out.print("Introduce un número entero (1 o 2):\n");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero == 1 || numero == 2) {
                    return numero;
                }
            } else {
                scanner.next(); // Consumir entrada inválida
            }
            System.out.println("Introduce solo un uno o un dos.");
        }
    }

    public static void colocarBarcosEnTablero(String[][] cuadricula) {
    int[][] barcos = { {3, 1}, {2, 2}, {1, 3} }; // {tamaño, cantidad}

    for (int[] tipo : barcos) {
        int tam = tipo[0];
        int cantidad = tipo[1];

        for (int i = 0; i < cantidad; i++) {
            boolean colocado = false;
            while (!colocado) {
                boolean horizontal = Math.random() < 0.5; // 50% de probabilidad de ser horizontal
                int fila = (int)(Math.random() * cuadricula.length);
                int columna = (int)(Math.random() * cuadricula.length);

                if (puedeColocar(cuadricula, fila, columna, tam, horizontal)) {
                    colocar(cuadricula, fila, columna, tam, horizontal);
                    colocado = true;
                }
            }
        }
    }
}


    public static void colocarbarcosenlacudricula(String[] barcos, String[][] cuadricula) {
        for (String barco : barcos) {
            String[] partes = barco.split(",");
            int fila = Integer.parseInt(partes[0]);
            int columna = Integer.parseInt(partes[1]);
            cuadricula[fila][columna] = "B";
        }
    }

    public static void colocarbarcosmanualmente(Scanner scanner, String[][] cuadricula) {
        for (int i = 0; i < cuadricula.length; i++) {
            int fila, columna;
            while (true) {
                System.out.println("Introduce la fila y columna para el barco " + (i + 1));
                System.out.print("Fila (0 a " + (cuadricula.length - 1) + "): ");
                if (!scanner.hasNextInt()) {
                    scanner.next(); continue;
                }
                fila = scanner.nextInt();

                System.out.print("Columna (0 a " + (cuadricula.length - 1) + "): ");
                if (!scanner.hasNextInt()) {
                    scanner.next(); continue;
                }
                columna = scanner.nextInt();

                if (fila >= 0 && fila < cuadricula.length && columna >= 0 && columna < cuadricula.length) {
                    if (!cuadricula[fila][columna].equals("B")) {
                        cuadricula[fila][columna] = "B";
                        break;
                    } else {
                        System.out.println("Ya hay un barco ahí.");
                    }
                } else {
                    System.out.println("Coordenadas fuera de rango.");
                }
            }
        }
    }

public static void mostrarcuadricula(String[][] cuadricula, boolean mostrarBarcos) {
    // Cabecera con letras A-J
    System.out.print("  ");
    for (int i = 0; i < cuadricula[0].length; i++) {
        System.out.print(" " + (char)('A' + i) + " ");
    }
    System.out.println();
    // Fila de números
    for (int i = 0; i < cuadricula.length; i++) {
        System.out.print(i + " "); // Imprime el número de fila
        for (int j = 0; j < cuadricula[i].length; j++) {
            String celda = cuadricula[i][j];
            if (celda.equals("B") && !mostrarBarcos) {
                System.out.print("|~|"); // Oculta el barco como si fuera agua
            } else {
                System.out.print("|" + celda + "|");
            }
        }
        System.out.println();
    }
}
public static boolean puedeColocar(String[][] tablero, int fila, int columna, int tam, boolean horizontal) {
    if (horizontal) {
        if (columna + tam > tablero.length) return false;
        for (int j = 0; j < tam; j++) {
            if (!tablero[fila][columna + j].equals("~")) return false;
        }
    } else {
        if (fila + tam > tablero.length) return false;
        for (int i = 0; i < tam; i++) {
            if (!tablero[fila + i][columna].equals("~")) return false;
        }
    }
    return true;
}

public static void colocar(String[][] tablero, int fila, int columna, int tam, boolean horizontal) {
    for (int k = 0; k < tam; k++) {
        if (horizontal) {
            tablero[fila][columna + k] = "B";
        } else {
            tablero[fila + k][columna] = "B";
        }
    }
}

public static int[] pedirCoordenadasAlfanumericas(Scanner scanner, int limite) {
    while (true) {
        System.out.print("Introduce coordenadas (ej. 5c): ");
        String entrada = scanner.next().toLowerCase().trim();

        if (entrada.matches("\\d+[a-j]")) {
            int fila = Integer.parseInt(entrada.replaceAll("[^\\d]", ""));
            char letra = entrada.charAt(entrada.length() - 1);
            int columna = letra - 'a';

            if (fila >= 0 && fila < limite) {
                return new int[] { fila, columna };
            }
        }

        System.out.println("Coordenadas inválidas. Usa el formato número + letra (ej. 3b), con letras de la 'a' a la 'j'.");
    }
}


}//Fin class
