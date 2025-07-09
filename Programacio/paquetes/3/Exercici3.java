public class Exercici3 {
    public static void main(String[] args) {
        CuentaCorriente2 cuenta1=new CuentaCorriente2("20564978K", "Pablo");
        cuenta1.ingresarDinero(200);
        System.out.println("El saldo de la cuenta es "+cuenta1.getSaldo());
    }
}
