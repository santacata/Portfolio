public class Fondo_inversion extends Cuenta {

    private double interes;
    private double comision;

    public Fondo_inversion(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
        this.interes = 0.34;
        this.comision = 0.6; // o el valor que quieras
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
