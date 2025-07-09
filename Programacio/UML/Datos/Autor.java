package Datos;

public class Autor {

    static final int MAX_LIBROS = 10; //Constante de clase

    private String nombre;
    private int nacimiento;

    //Establecer primera relacion
    private Libro[] libros;
    //Un autor puede tener varios libros

    private int cantidad; //numero de libros que tiene el autor

    public Autor (String nombre, int nacimiento){
        this.nombre = nombre;
        this.nacimiento=nacimiento;
        this.libros= new Libro[MAX_LIBROS];
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Obtener libros del autor
    public Libro[]getLibros(){
        return libros;
    }
    public int getCantidad(){
        return cantidad;
    }
    //Asignar libros al array
    public void nuevoLibro(Libro nuevo){
        if (cantidad < MAX_LIBROS) {
            libros[cantidad]=nuevo;
            cantidad++;
            
        }
    }
    public void mostrarInformacion(){
        //Accedo a loas variables de la clase anterior
        if (cantidad<0) { 
            for (int i = 0; i < cantidad; i++) {
                libros[i].mostrarInformacion();
            }
            
        }else{
            System.out.println("No tiene libros");
        }
    }
}
