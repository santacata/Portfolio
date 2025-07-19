public class Cliente_corporativo extends Cliente {

    private double pago=pago();
    private int cuenta;

    public int getCuenta() {
        return cuenta;
    }

    public double pago(){
        return super.getPago()*1.05;
    }
    
    public Cliente_corporativo(int pago, String nombre, String direccion, int cuenta){
        super(pago*1.05, nombre, direccion);
        this.cuenta=cuenta;
        super.anyadirArrayList(this);
    }
    
@Override
    public String toString() {
        return "Cliente_corporativo [pago=" + pago + ", cuenta=" + cuenta  + super.toString() + "]";
    }
}
