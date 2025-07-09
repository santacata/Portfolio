package Cliente;

public class UsoCuentas {
    public static void main(String[] args) {
        Cliente cliente1= new Cliente("Pedro", "Picapiedra", "Calle en construccion", "LaPiedra", null);

        Cliente cliente2=new Cliente("Pedro", "Picapiedra", "Calle en construccion2", "LaPiedra", null);

        Cliente cliente3=new Cliente("Pedro", "Picapiedra", "Calle en construccion3", "LaPiedra", null);
        System.out.println(cliente1.equals(cliente2)); //Caguenlaputa


Cuenta cuenta1= new Cuenta(21, 1000, cliente3, null);

Cuenta cuenta2= new Cuenta(27, 1000, cliente1, null);


    }
    
}
