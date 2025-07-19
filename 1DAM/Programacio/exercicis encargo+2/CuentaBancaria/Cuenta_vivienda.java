public class Cuenta_vivienda extends Cuenta {
    private double interes;
    private double comision;

    public Cuenta_vivienda(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
        this.interes = 0.2;
        this.comision = 0.0; // Puedes poner el valor deseado
    }

    @Override
    public double getInteres() {
        return interes;
    }

    @Override
    public double getComision() {
        return comision;
    }

    @Override
    public void retirar(float cantidad) {
        System.out.println("No se puede retirar de una cuenta vivienda.");
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
