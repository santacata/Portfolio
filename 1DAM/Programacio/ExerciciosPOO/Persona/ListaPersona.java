package Persona;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPersona {
    //Gestionar lista de personas
    //Podemos usar persona en otros conmtextos
    //No necesitamos conocer como se implementa Persona
    //Claridad y mantenibilidad en el codigo
    //Más escalable
    //Nos permite encapsulamiento de datos en el proyecto

    private ArrayList <Persona> listasPersonas;

    public ListaPersona(){
        this.listasPersonas = new ArrayList<>();
    }
    public void añadirPersona(Persona p){
        listasPersonas.add(p);
    }
    public void eliminarPersona(Persona p){
        listasPersonas.remove(p);
    }
    //Buscar persona por nombre
    public Persona buscarPersona(String nombre){
        //Iterar a traves de la lista de personas
        for (int i = 0; i < listasPersonas.size(); i++) {
            //Comparar el nombre en la lista
            if (listasPersonas.get(i).getNombre().equals(nombre)) {
                return listasPersonas.get(i);
                
            }
                        
        }
        return null;
    }
    public ArrayList<Persona> buscarPersonas(String nombre){
        ArrayList<Persona>resultado=new ArrayList<>();;
        //Almaceno las personas
        for (Persona p : listasPersonas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(p);
            }
            
        }
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron personas con el nombre");     
        }
        return resultado;
    }
    public void modificarPersona(Persona p, String nombre, String apellidos, String telefono){
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setTelefono(apellidos);
    }
    
    //Utilizando un iterador (Iterator) Interfaz de Java
    //Iterator<persona> it=listasPersonas.iterator();
    public Persona buscarUltimaPersona(String nombre){
        for (int i = listasPersonas.size() -1; i>=0; i--) {
            if(listasPersonas.get(i).getNombre().equalsIgnoreCase(nombre)){
                return listasPersonas.get(i);
            }
            
        }
        return null;
    }

    public void mostrarLista(){
        for (Persona p : listasPersonas) {
            System.out.println(p);
        }
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



}
