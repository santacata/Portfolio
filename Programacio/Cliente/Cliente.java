package Cliente;

import java.time.LocalDate;

public class Cliente {
 
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private LocalDate fechanacimiento;
       public Cliente(String nombre, String apellidos, String direccion, String localidad, LocalDate fechanacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.fechanacimiento = fechanacimiento;
    }
    public String nombreCompleto(){
        return nombre+" "+apellidos;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }
    @Override
    public String toString(){
        return nombre+apellidos+direccion+localidad+fechanacimiento.getDayOfMonth()+fechanacimiento.getMonthValue()+fechanacimiento.getYear();
    }
    @Override
    public boolean equals(Object o){
        Cliente cl=(Cliente)o;
        //Convertimos el objeto o a un objeto de la clase client
    return this.nombre.equals(cl.nombre) && this.apellidos.equals(cl.apellidos);
    }
}
