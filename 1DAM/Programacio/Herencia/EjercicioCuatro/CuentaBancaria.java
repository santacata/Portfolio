abstract class CuentaBancaria {
    protected String iban;
    protected double saldo;
    protected static double interesAnualBasico = 0.01; // 1%

    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            añadir(cantidad);
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            añadir(-cantidad);
        }
    }

    public void traspasar(double cantidad, CuentaBancaria otraCuenta) {
        if (cantidad > 0 && saldo >= cantidad) {
            this.retirar(cantidad);
            otraCuenta.ingresar(cantidad);
        }
    }

    public void añadir(double cantidad) {
        saldo += cantidad;
    }

    public abstract void calcularIntereses();

    public void mostrarDatos() {
        System.out.println("IBAN: " + iban + ", Saldo: " + saldo);
    }
}
