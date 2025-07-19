import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String documentoNacionalIdentidad;
    private ArrayList<Cuenta>cuentas;

    public Cliente(String nombre, String apellidos, String direccion,
    String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.documentoNacionalIdentidad = dni;
        AppSucursal.clientes.add(this); //Anyadim al client a la bbdd
        cuentas=new ArrayList<>();
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    //NOMBRE COMPLETO
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDNI() {
        return documentoNacionalIdentidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellidos + "\n" +
                "Direccion: " + direccion +", con DNI "+documentoNacionalIdentidad;
    }

    @Override
    public boolean equals(Object o) {
        Cliente cl = (Cliente) o; //convertimos el objeto 'o' a un objeto de la clase 
        //Cliente
        return this.nombre.equals(cl.nombre) && this.apellidos.equals(cl.apellidos); //Si nombre y apellidos coinciden devuelve true
    }

    public void setDni(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDni'");
    }

    public void setApellido(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setApellido'");
    }


    

}
