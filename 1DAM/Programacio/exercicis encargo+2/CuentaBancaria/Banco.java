import java.time.LocalDate;
import java.util.ArrayList;

public class Banco {
    private String nombre;
    private String localidad;
    private LocalDate fechaInicio;
    private ArrayList<Cuenta> cuentas;

    public Banco(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechaInicio = LocalDate.now();
        this.cuentas = new ArrayList<>();
    }

    public void añadirCuentaABanco(Cuenta cuenta) {
        if (cuenta != null && !cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
        }
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Banco [nombre=").append(nombre)
          .append(", localidad=").append(localidad)
          .append(", fechaInicio=").append(fechaInicio)
          .append(", cuentas=[");
        for (Cuenta c : cuentas) {
            sb.append(c.getNumeroCuenta()).append(", ");
        }
        if (!cuentas.isEmpty()) sb.setLength(sb.length() - 2); // Eliminar última coma
        sb.append("]]");
        return sb.toString();
    }
}
