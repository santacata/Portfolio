public class CuentaCorriente {
    public String numeroDNI;
    public String nombreTitular;
    private int saldo=0;

    
    public CuentaCorriente(String numeroDNI, String nombretitular){

    }
    public void sacarDinero(int valorARestar){

        
    }
    public void ingresarDinero(int valorAIngresar){

    }
    public void mostrarInformacion(){
        System.out.println("Tu DNI es: "+numeroDNI);
        System.out.println("Eres: "+nombreTitular);
        System.out.println("Tu saldo es: "+saldo);
    }

}
