package Persona;

import java.util.Scanner;

public class UsoPersonas {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        ListaPersona lista = new ListaPersona();
        int op=0;

        do{
            imprimirMenu();
            op=Integer.parseInt(entrada.nextLine());
            switch (op) {
                    case 1:
                    introducirPersona(entrada, lista);
                    break;
                    case 2:
                    buscarPersona(entrada, lista);
                    break;
                    case 3:
                    borrarPersona(entrada, lista);
                    break;
                    case 4:
                    metodomostrarLista(lista);              
                    break;
                    case 5 :
                    metodomodificarPersona(entrada, lista);
                    break;
                default:
                    break;
            }
        }while(op!=6);
    }
    public static void imprimirMenu(){
        System.out.println("Introduce una opcion");
        System.out.println("1.Introducir datos");
        System.out.println("2.Buscar persona");
        System.out.println("3.Borrar Persona");
        System.out.println("4.Mostrar Lista");
        System.out.println("5.Modificar persona");
        System.out.println("6.Salir");
    }
    public static void imprimirSubmenu(){
        System.out.println("Introduce una opcion");
        System.out.println("a. Buscar por nombre");
        System.out.println("b. Buscar per primera letra");
        System.out.println("c. Nombre a buscar de la ultima persona");
        System.out.println("d. Salir del submenu");
    }
    public static void introducirPersona(Scanner entrada, ListaPersona lista){
        System.out.println("Introducir datos de personas");
        System.out.println("NOMBRE: ");
        String nom=entrada.nextLine();
        System.out.println("APELLIDOS: ");
        String ap=entrada.nextLine();
        System.out.println("TEL: ");
        String telefono=entrada.nextLine();
        Persona nuevaPersona = new Persona(nom, ap, telefono);
        lista.añadirPersona(nuevaPersona);
        System.out.println("La poersona ha sido añadida con exito");
    }
    public static void buscarPersona(Scanner entrada, ListaPersona lista){
        char opBuscarPersona;
        do {
            imprimirSubmenu();
            opBuscarPersona=entrada.nextLine().charAt(0);
            switch (opBuscarPersona) {
                case 'a':
                buscarpornombre(entrada, lista);
                break;
                case 'b':
                buscarporletra(entrada, lista);
                break;
                case 'c':
                buscarUltimaPersona(entrada, lista);
                break;
                case 'd':
                System.out.println("Saliendo del submenu");
            }
            
        } while (opBuscarPersona!='d');
        
    }

    public static void borrarPersona(Scanner entrada, ListaPersona lista){
        System.out.println("Introduce el nombre a borrar");
        String nombreBorrar=entrada.nextLine();
        Persona personaborrar = lista.buscarPersona(nombreBorrar);
        if (personaborrar!=null) {
            System.out.println(personaborrar);
            lista.eliminarPersona(personaborrar);
        }
    }
    public static void metodomostrarLista(ListaPersona lista){
        System.out.println("lista de personas");
        lista.mostrarLista();
        System.out.println("En total hay "+Persona.getNumPersonas());

    }
    public static void metodomodificarPersona(Scanner entrada, ListaPersona lista){
        System.out.println("Introduce el nombre a modificar");
        String nombremodificar= entrada.nextLine();
        Persona personaModificar = lista.buscarPersona(nombremodificar);

        if (personaModificar!=null) {
        System.out.println(personaModificar);
        System.out.println("Introduce el nuevo nombre");
        String nuevonombre =entrada.nextLine();
        System.out.println("Introduce el nuevo apellido");
        String nuevoApellido = entrada.nextLine();
        System.out.println("Introduce el nuevo teléfono");
        String nuevoTelefono = entrada.nextLine();

        lista.modificarPersona(personaModificar, nuevonombre, nuevoApellido, nuevoTelefono);

        System.out.println("Los datos han sido actualizados:");
        System.out.println(personaModificar);
        }
    }

    public static void buscarpornombre(Scanner entrada, ListaPersona lista){
        System.out.println("Introduce el nombre a buscar");
        String nombreBuscar=entrada.nextLine();
        Persona personaBuscada = lista.buscarPersona(nombreBuscar);
        if (personaBuscada!=null) {
            System.out.println("La persona encontrada es:");
            System.out.println(personaBuscada);
        }
    }
    public static void buscarporletra(Scanner entrada, ListaPersona lista){
        System.out.println("Introduce la letra de la persona a buscar");
        String primeraletra = entrada.nextLine().substring(0, 1); // Necesitamos un String para el metodo, pero tiene la longitud de un char
        for (Persona p : lista.buscarPersonas(primeraletra)) {
            System.out.println(p);
        }
    }

    public static void buscarUltimaPersona(Scanner entrada, ListaPersona lista){
        System.out.println("Introduce el nombre a buscar de la ultima persona");
        String nombreUltimaBuscar=entrada.nextLine();
        Persona ultimaPersonaBuscada = lista.buscarUltimaPersona(nombreUltimaBuscar);
        if (ultimaPersonaBuscada!=null) {
        System.out.println("La ultima persona con ese nombre es");
        System.out.println(ultimaPersonaBuscada); 
        }
    }

}
