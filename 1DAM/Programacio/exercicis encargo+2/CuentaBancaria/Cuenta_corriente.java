public class Cuenta_corriente extends Cuenta {
    private double interes;
    private double comision;

    public Cuenta_corriente(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
        this.interes = 0.05;   // Ejemplo de interés
        this.comision = 0.3;   // Ejemplo de comisión
    }

    @Override 
    public double getInteres() {
        return interes;
    }

    @Override
    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
