import java.time.LocalDate;
import java.util.ArrayList;

public class Banco {
    String nombre;
    String localidad;
    LocalDate fechaInicio;
    ArrayList<Cuenta> cuentas;

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public Banco(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechaInicio = LocalDate.now(); // CORREGIDO
        this.cuentas = new ArrayList<>();
        //Añadimos la cuenta a CuentasTodas de AppSucursal
        AppSucursal.getBancos().add(this);
    }

    public void añadirCuentaABanco(Cuenta cuenta) {
        if (!cuentas.contains(cuenta)) { // evitar duplicados
            cuentas.add(cuenta);
        }
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", localidad=" + localidad + ", fechaInicio=" + fechaInicio + ", cuentas=" + cuentas + "]";
    }

    public String getNombre() {
        return nombre;
    }
}