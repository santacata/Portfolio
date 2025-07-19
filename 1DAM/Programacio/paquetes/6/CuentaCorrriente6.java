import java.time.LocalTime;

public class CuentaCorrriente6 {
    public String numeroDNI;
    public String nombreTitular;
    private int saldo=0;
    private String banco="Lacabra";
    private Gestor gestor;
    private LocalTime tiempo;

    

    public CuentaCorrriente6(String numeroDNI, String nombretitular){

    }
    public void sacarDinero(int valorARestar){

        
    }
    public void ingresarDinero(int valorAIngresar){

    }
    public void mostrarInformacion(){
        System.out.println("Tu DNI es: "+numeroDNI);
        System.out.println("Eres: "+nombreTitular);
        System.out.println("Tu saldo es: "+saldo);
        System.out.println("El gestor es"+gestor.getNombre());
    }
    public CuentaCorrriente6(String numeroDNI, int saldo){

    }
    public CuentaCorrriente6(String DNI, String nombreTitular, int saldo, Gestor gestor){
        numeroDNI=DNI;
        this.nombreTitular=nombreTitular;
        this.saldo=saldo;
        this.gestor=gestor;
        tiempo=LocalTime.now();

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
 public static void main(String[] args) {
    System.out.println("Hola");
 }
}
