public class Cuenta_corriente extends Cuenta {
    private double interes=getInteres();
    private double comision=super.comision;
    double saldo=this.getSaldo();

    public Cuenta_corriente(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
    }

    //unimplemented methods

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
