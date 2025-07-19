import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public abstract class Cuenta {

    private int numeroCuenta;
    private double saldo;
    private Cliente titular;
    private ArrayList<Movimiento> movimientos;
    private double puntos = 0;

    public Cuenta(int numeroCuenta, double saldo, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = new ArrayList<>();
    }

    // Métodos abstractos
    public abstract double getInteres();
    public abstract double getComision();

    // Getters y setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    // Métodos funcionales
    public void ingresar(double cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede ingresar una cantidad negativa");
            return;
        }

        saldo += cantidad;
        puntos += cantidad / 6;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.INGRESO));

        System.out.printf("Se han ingresado %.2f € en la cuenta %d de %s. Saldo actual: %.2f €, puntos: %.0f\n",
                cantidad, numeroCuenta, titular.getNombreCompleto(), saldo, puntos);
    }

    public void retirar(float cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede retirar una cantidad negativa");
            return;
        }

        if (this instanceof Fondo_inversion) {
            if (saldo - cantidad < -500) {
                System.out.println("No hay suficiente saldo para esta operación (límite -500)");
                return;
            }
        } else {
            if (saldo - cantidad < 0) {
                System.out.println("No tienes saldo suficiente para esta operación");
                return;
            }
        }

        saldo -= cantidad;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.RETIRADA));

        System.out.printf("Se han retirado %.2f € en la cuenta %d de %s. Saldo actual: %.2f €\n",
                cantidad, numeroCuenta, titular.getNombreCompleto(), saldo);
    }

    public String obtenerMovimientos() {
        StringBuilder s = new StringBuilder();
        for (Movimiento m : movimientos) {
            s.append(m.toString()).append("\n");
        }
        return s.toString();
    }

    public void verDatos() {
        StringBuilder s = new StringBuilder();
        s.append("Número de cuenta: ").append(numeroCuenta).append("\n");
        s.append("Titular: ").append(titular.getNombreCompleto())
         .append(", con DNI ").append(titular.getDNI()).append("\n");
        s.append("Saldo: ").append(String.format("%.2f", saldo)).append(" €\n");
        s.append("------ MOVIMIENTOS ------\n");
        s.append(obtenerMovimientos());
        s.append("-------------------------");
        System.out.println(s.toString());
    }

    @Override
    public String toString() {
        return "Cuenta [nº " + numeroCuenta +
               ", titular=" + titular.getNombreCompleto() +
               ", saldo=" + String.format("%.2f", saldo) + " €]";
    }

    // Clase interna Movimiento
    private class Movimiento {
        private LocalDateTime fechaHora;
        private byte tipo;
        private double importe;
        private double saldoFinal;

        public static final byte INGRESO = 0;
        public static final byte RETIRADA = 1;

        public Movimiento(LocalDateTime fechaHora, double importe, byte tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.tipo = tipo;
            this.saldoFinal = saldo;
        }

        @Override
        public String toString() {
            return (tipo == INGRESO ? "Ingreso: " : "Retirada: ") +
                    "[Fecha=" + fechaHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                    ", Importe=" + String.format("%.2f", importe) + " €" +
                    ", Saldo=" + String.format("%.2f", saldoFinal) + " €]";
        }
    }
}
