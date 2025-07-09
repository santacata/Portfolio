public class Fondo_inversion extends Cuenta {
    private double interes=getInteres();
    private double comision=super.comision;


    double saldo=this.getSaldo();

    public Fondo_inversion(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
        interes=0.34;
    }

    @Override
    public double getInteres() {
        return interes;
    }

    @Override
    public double getComision() {
        return comision;
    }

    //modificador comision
    public void setComision(double comision) {
        this.comision = comision;
    }
    
}
