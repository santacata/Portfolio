import java.time.LocalDate;

abstract class Mascota {
    protected String nombre;
    protected int edad;
    protected String estado;
    protected LocalDate fechaNacimiento;

    public Mascota(String nombre, int edad, String estado, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract void muestra();
    public abstract void habla();
    
    public void cumpleaños() {
        edad++;
    }
    
    public void morir() {
        estado = "Muerto";
    }
}