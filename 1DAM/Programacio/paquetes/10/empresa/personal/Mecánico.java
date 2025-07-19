package personal;

public class Mecánico {
    public String nombre;
    public String telefono;
    public String especialidad; // Puede ser: frenos, hidráulica, electricidad o motor

    public Mecánico(String nombre, String telefono, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }
}