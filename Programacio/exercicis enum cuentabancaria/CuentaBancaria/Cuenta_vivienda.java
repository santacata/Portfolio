public class Cuenta_vivienda extends Cuenta {
    private double interes=getInteres();
    private double comision=super.comision;
    double saldo=this.getSaldo();


    public Cuenta_vivienda(int numeroCuenta, double saldo, Cliente titular) {
        super(numeroCuenta, saldo, titular);
        interes=0.2;
    }

    @Override
    public double getInteres() { //Así siempre se le guarda el ultimo valor
        return interes;
    }

    @Override
    public double getComision() {
        return comision;
    }
    //Le aplicamos un override a retirar para que no nos deje hacerlo
    @Override
    public void retirar(float cantidad){
        System.out.println("No se puede retirar de una cuenta vivienda");
    }
    //modificador comision
    public void setComision(double comision) {
        this.comision = comision;
    }
    
}
