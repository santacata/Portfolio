import java.util.ArrayList;

abstract class Cliente {
    private double pago;
    private String nombre;
    private String direccion;
    private static ArrayList<Cliente> clientes= new ArrayList<>();
    private static ArrayList<Encargo> encargos= new ArrayList<>();


    public double getPago() {
        return pago;
    }

    public Cliente(double pago, String nombre, String direccion) {
        this.pago = pago;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return ", nombre=" + nombre + ", direccion=" + direccion;
    }

    public static void anyadirArrayList(Cliente cliente){
        clientes.add(cliente);
    }
    public static void anyadirArrayList(Encargo encargo){
        encargos.add(encargo);
    }
    public static void enunciarClients(){
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());  
        }
    }

    public static void enunciarEncarrecs(){
        for (Encargo encargo : encargos) {
            System.out.println(encargo.toString());
        }
    }
    
}
