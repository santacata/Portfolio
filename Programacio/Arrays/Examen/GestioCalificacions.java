import java.util.Scanner;

public class GestioCalificacions {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
System.out.println("Anem a solicitar els integrants de la classe");
        String [][] matrizConNombreEstudiantes = obtenerNombre(sc);
        String [][]matrizevaluada=new String[matrizConNombreEstudiantes.length][4]; //"Nom"+ 3 evaluacions
        String[] nombrescodificados=obtenernombreCodificado(matrizConNombreEstudiantes);
        

        
        
       
            while (true) {
                
        String opció=mostrarmenu(sc);
        switch (opció) {
            case "A1":
                System.out.println("Inicializar calificaciones con un valor inicial");
                inicializarCalificaciones(matrizConNombreEstudiantes);
            break;
            case "F":
            System.out.println("Mostrar nota media");
                mostrarNotaMedia(sc);
            break;
            case "F1":
                System.out.println("Media de todos los estudiantes");
            break;
            case "G1":
                System.out.println("Eliminar estudiante");
                eliminarEstudiante(sc);
            break;
            case "E1":
                System.out.println("Saliendo de todo");
            break;
            case "A2":
                System.out.println("Inicializar calificaciones");
                String [][] matrizEvaluada = obtenerCalificacionInicial(matrizConNombreEstudiantes, sc);
            break;
            case "B1":
                System.out.println("Consultar calificaciones por estudiante");
                consultarCalificacionesPorEstudiante(matrizevaluada);
            break;
            case "C1":
                System.out.println("Actualizar calificacion");
                actualizarCalificacion(sc);
            break;
            case "D1":
                System.out.println("Mostrar calificaciones");
                mostrarCalificaciones(null);
            break;
            default:
            System.out.println("Opción no válida");
            break;
                }
            }
        
    }
    public static String [][] obtenerNombre(Scanner sc){
        System.out.println("Cuántos estudiantes quieres?");

        int numeroalumnos=sc.nextInt();
        String [] nombreApellidoAnio= {"nombre","apellido","año"};
        String [][] matrizConEstudiantes= new String[numeroalumnos][3];
        for (int i = 0; i < matrizConEstudiantes.length; i++) {
            for (int j = 0; j < matrizConEstudiantes[i].length; j++) {
                System.out.println("Dime el "+nombreApellidoAnio[j]+ ":");
                matrizConEstudiantes[i][j]=sc.nextLine();
               if (i==0&&j==0) {
                sc.nextLine(); //Limpiamos porque da error de escaner en el primero no se por el motivo si no está y me he vuelto loco
               }
            
            }
        }
        return matrizConEstudiantes;

    }
    public static String[]obtenernombreCodificado(String [][] matrizConNombreEstudiantes){
        String [] matrizCodificada= new String[matrizConNombreEstudiantes.length];
        for (int i = 0; i < matrizConNombreEstudiantes.length; i++) {
            for (int j = 0; j < matrizConNombreEstudiantes.length; j++) {
                //Ací li anyadiria els tres caracters primers de cada element de matrizconestudiantes[i] a matrizcodificada[i]
                
            }
        }
        return null;

    }


public static String mostrarmenu(Scanner sc){
    
        System.out.println("A1. Inicializar Calificaciones con un valor inicial");
        System.out.println("A2. Inicializar Calificaciones");
        System.out.println("B1. Consultar Calificaciones por Estudiante");
        System.out.println("C1. Actualizar Calificación");
        System.out.println("D1. Mostrar Calificaciones");
        System.out.println("F  Nota Media");
        System.out.println(" \t F1. Media de todos los estudiantes");
        System.out.println("G1. Eliminar Estudiante");
        System.out.println("E1. Salir");
        String opcio= sc.nextLine();
        return opcio.toUpperCase();
}
public static String [][] inicializarCalificaciones(String[][]matrizConNombresEstudiantes){
    
    String [][]inicializarCalificaciones=new String [matrizConNombresEstudiantes.length][4]; //Suponemos que queremos el nom + tres evaluaciones

        System.out.println("Calificaciones de Estudiantes Actual:");
        System.out.println("|---------------------------|---------------|---------------|---------------|");
        for (int i = 0; i < inicializarCalificaciones.length; i++) {
            for (int j = 0; j < inicializarCalificaciones.length; j++) {
                if(i==0){
                    inicializarCalificaciones[i][j]=matrizConNombresEstudiantes[i][j];
                }else{
                    inicializarCalificaciones[i][j]="6";
                }
                
            }
        }
        
        System.out.printf("| %-25s | %-13s | %-13s | %-13s |%n", "Estudiante", "Evaluación 1", "Evaluación 2",
                "Evaluación 3");
        System.out.println("|---------------------------|---------------|---------------|---------------|");
        return inicializarCalificaciones;
    }
    public static double mostrarNotaMedia(Scanner sc){
        return 7/2;
    }
    public static String[][] obtenerCalificacionInicial(String [][] matrizConNombresEstudiantes, Scanner sc){
        String [][]inicializarCalificaciones=new String [matrizConNombresEstudiantes.length][4]; //Suponemos que queremos el nom + tres evaluaciones

        System.out.println("Calificaciones de Estudiantes Actual:");
        System.out.println("|---------------------------|---------------|---------------|---------------|");
        for (int i = 0; i < inicializarCalificaciones.length; i++) {
            for (int j = 0; j < inicializarCalificaciones.length; j++) {
                if(i==0){
                    inicializarCalificaciones[i][j]=matrizConNombresEstudiantes[i][j];
                }else{
                    while (true) {
                        
                    
                        if(sc.hasNextInt()){
                        int valor=sc.nextInt();
                        if(valor<10&&valor>0){
                            inicializarCalificaciones[i][j]="o";
                            break;

                            }else{
                            System.out.println("Introduce un valor de nuevo");
                            sc.nextLine();//Eliminamos la entrada si no está entre 0 y 10
                        }
                        }
                
                    }
                }
                
            }
        }
        
        return inicializarCalificaciones;
    }
    public static void mostrarCalificaciones(String [][] matriz){
        System.out.println("Calificaciones de Estudiantes Actual:");
        System.out.println("|---------------------------|---------------|---------------|---------------|");

        
        System.out.printf("| %-25s | %-13s | %-13s | %-13s |%n", "Estudiante", "Evaluación 1", "Evaluación 2",
                "Evaluación 3");
        System.out.println("|---------------------------|---------------|---------------|---------------|");

    }
    public static void consultarCalificacionesPorEstudiante(String [][]matrizevaluada){
        System.out.println("Selecciona la persona del que quieras ver las notas");

    }
    public static double[]actualizarCalificacion(Scanner sc){
        return null;
    }
    public static String[][] eliminarEstudiante(Scanner sc){
        String [][]stringConEliminacion;
        return null;
    }
 
}