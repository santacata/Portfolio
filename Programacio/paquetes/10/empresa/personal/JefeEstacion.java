package personal;

import java.time.LocalDate;

public class JefeEstacion {
    public String nombre;
    public String dni;
    public LocalDate fechaNombramiento;

    public JefeEstacion(String nombre, String dni, LocalDate fechaNombramiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNombramiento = fechaNombramiento;
    }
}