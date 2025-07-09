package Principal;

import Datos.Autor;
import Datos.Libro;

public class App {
    public static void main(String[] args) { 
        //Asociacion simple Crear un autor y dos libros
            Autor autor1=new Autor("Francisco Ibanes", 1963);

    //Libros
    Libro l1= new Libro("El caso del bacalao","Editorial A", 800, autor1); //Lo asociamos a autor1

    Libro l2= new Libro("Hay un traidor en la TIA", "Editorial A", 100, autor1);

    System.out.println("informacion de l1");
    l1.mostrarInformacion();
    System.out.println();
    System.out.println("Informacion del autor");
    autor1.mostrarInformacion();
    System.out.println("\n");


    //Asociamos la informacion del libro al autor
    autor1.nuevoLibro(l1);
    autor1.nuevoLibro(l2);

    System.out.println("Mostramos la info del autor");
    autor1.mostrarInformacion();

    }
   

    
}
