import java.util.Scanner;

public class hundirlaflota { //Class

    public static void main(String[] args) { //Main
        Scanner scanner=new Scanner(System.in);
        System.out.println("-----Vamos a hacer la cuadrícula inicial------");
        int numero=verificarqueseaentero(scanner);
        String[][]cuadricula=crearcuadriculainicial(numero);
        System.out.println("Selecciona 1 o 2 para si quieres que los barcos se asignen automáticamente o manualmente");
        int opcion=verificarqueseaunoudos(scanner);
         if (opcion==1) {
            String[]arrayconbarcos=colocarbarcosaleatoriamente(cuadricula);
        }/*else{
            colocarbarcosmanualmente(cuadricula);
        } */

        
    } //Fin main
    public static int verificarqueseaentero(Scanner scanner){
        int numero;
        while (true) {
            System.out.print("Introduce un numero entero:\n");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero>0) {
                    return numero;
                }
            } else {
                scanner.next(); // Consumir entrada inválida
                System.out.println("Introduce solo números enteros y mayor que 0.");
            }
           System.out.println("Prueba otra vez.");
        }
    }//Fin verificarqueseaentero
    public static String[][] crearcuadriculainicial(int n) {
    String[][] matriz = new String[n][n];
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            matriz[i][j] = "~"; // Asigna el texto (no admite emojis en un array)
            System.out.print("|" + matriz[i][j] + "|"); // Imprime directamente
        }
        System.out.println();
    }
    return matriz;
    } //Fin crearcuadriculainicial
    public static int verificarqueseaunoudos(Scanner scanner){
        int numero;
        while (true) {
            System.out.print("Introduce un numero entero:\n");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero==1|numero==2) { //Envia el resultado sólo si se cumple el primer y el segundo if
                    return numero;
                }
                
            } else {
                scanner.next(); // Consumir entrada inválida
            }
           System.out.println("Introduce solo un uno o un dos.");
        }
    }
    public static String[]colocarbarcosaleatoriamente(String[][]cuadricula){ //Asignamos los barcos a la cuadricula
    String[] barcos=new String[cuadricula.length]; //Hacemos un array para guardar las posiciones de los barcos en la cuadrícula
    String letras="ABCDEFGHIJ"; //Pedimos que selecccione una letra al azar de esta String mediante substring, y genera un numero aleatorio mediante (int)Math.random*10
    for (int i = 0; i < barcos.length; i++) {
        barcos[i]=letras.substring(i, i+1)+(int)(Math.random()*10);
        
    }
    
    return barcos;

    }//Fin colocarbarcosaleatoriamente
}//Fin class