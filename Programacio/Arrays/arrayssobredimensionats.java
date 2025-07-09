import java.util.Scanner;
public class arrayssobredimensionats {
    public static void main(String[] args) {
        //Elementos del array sobredimensionado
        final int CAPACIDAD = 5; //inmutables i no modificables perque es final
        Scanner sc=new Scanner(System.in);

        int cantidad=0;
        int posicionaborrar;

        String nombreUsuario;

        //Llenar el array
        System.out.println("Estribe "+CAPACIDAD+" nombres");

        //Usar un bucle para pedir los nombres
            String [] nombreS=new String [CAPACIDAD];
        for (int i = 0; i < CAPACIDAD; i++) {
            System.out.println("introduce un nombre");
            nombreUsuario=sc.nextLine();

            //verificamos que aun hay espacio disponible en el array

        if (cantidad<CAPACIDAD) {
            nombreS[cantidad]=nombreUsuario;
            cantidad++;
        }
        //Mostramos los nombres almacenados
        System.out.println("\n Nombres almacenados");
        for (int j = 0; j < cantidad; j++) {
            System.out.println(j+1+". "+nombreS[j]);
            
        }
        //Borrar una posicion

        System.out.println("Elige una posicion a borrar (1- )"+cantidad+ ")");

        //Validamos que el usuario introsuzca un numero

        while (!sc.hasNextInt())  {
            System.out.println("Por favor introduce un numeri valido");
            sc.next(); //Limpiamos
            
        }
        }

        
    }
}
