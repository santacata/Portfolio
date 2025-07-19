package Persona;

public class Persona {



    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private static int numPersonas=0;

        public Persona(int id, String nombre, String apellidos, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        numPersonas++;
    }
    public Persona(String nombre, String apellidos, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        numPersonas++;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public static int getNumPersonas() {
            return numPersonas;
        }

        public static void setNumPersonas(int numPersonas) {
            Persona.numPersonas = numPersonas;
        } 
           @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
    }
}
