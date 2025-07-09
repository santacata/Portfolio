public class Cliente_particular extends Cliente {

    private int pago;
    private int targetaNmr;

    public double pago(){
        return super.getPago()*1.05;
    }
   
    public Cliente_particular(int pago, String nombre, String direccion, int targetaNmr) {
        super((int)(pago*0.98), nombre, direccion);
        this.targetaNmr=targetaNmr;
        super.anyadirArrayList(this);
    }

    @Override
    public String toString() {
        return "Cliente_particular [pago=" + pago + ", targetaNmr=" + targetaNmr + super.toString()
                + "]";
    }
    
}
