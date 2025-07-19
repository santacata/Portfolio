public class CuentaCorriente3 {
    String numeroDNI;
    public String nombreTitular;
    private int saldo=0;
    private String banco="Lacabra";

    

        public CuentaCorriente3(String numeroDNI, String nombretitular){
        this.numeroDNI=numeroDNI;
        this.nombreTitular=nombretitular;
        }
    
        public void sacarDinero(int valorARestar){
            saldo-=valorARestar;
            
        }
    
        public void ingresarDinero(int valorAIngresar){
            saldo+=valorAIngresar;
    
        }
        public void mostrarInformacion(){
            System.out.println("Tu DNI es: "+numeroDNI);
            System.out.println("Eres: "+nombreTitular);
            System.out.println("Tu saldo es: "+saldo);
        }
    
        public CuentaCorriente3(String numeroDNI, int saldo){
            this.numeroDNI=numeroDNI;
            this.saldo=saldo;
        }
        public CuentaCorriente3(String DNI, String nombreTitular, int saldo){
            numeroDNI=DNI;
            this.nombreTitular=nombreTitular;
            this.saldo=saldo;
        }
    
    public int getSaldo() {
        return saldo;
    }

    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }

}
