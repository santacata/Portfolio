import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppSucursal {
    //Variables estaticas para que sean accesibles desde cualquier sitio de la clase y tb pa k los metodos no los tengamos que pasar como parametros
    private static Scanner entrada=new Scanner(System.in);
    //Clientes de la sucursal
    private static ArrayList <Cliente> clientes= new ArrayList<Cliente>();

    //Cuentas de la sucursal
    private static ArrayList <Cuenta> cuentas= new ArrayList<>();

    //cuenta actual
    private static Cuenta cuentaActual = null; //Nulo pk no hay ninguna cuenta

    //Contador de cuentas para asignar el numero de cuenta
    private static int contadorCuenta=123456780; //Le asignamos este numero pa k empiece de este


    public static void main(String[] args) {
        int opcion =0;
        while (opcion!=4) {
            menuPrincipal();
            opcion=Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1:
                crearCliente();
                    
                    break;
                    case 2:
                    crearCuenta();
                    break;
                    case 3:
                    mantenimientoCuenta();
                    break;
                    case 4:
                    System.out.println("gracias por venir");
                    break;
            
                default:
                System.out.println("Selecciona una opcion entre 1y 4");
                    break;
            }
            
        }
    } //Fin main

    static ArrayList<Cuenta>encontrarCuentaConMismoSaldo(String nombre){
        //;etodo para encontrar cuentas con un saldo especifico y el apellifo del titular
        ArrayList<Cuenta>cuentasConMismoSaldo=new ArrayList<>();
        //Recorrer la lista de cuentas
        for (Cuenta c : cuentas) {
            if (c.getSaldo()==cuentaActual.getSaldo()&&c.getTitular().equals(nombre)) {
                cuentasConMismoSaldo.add(c);
            }
            
        }
        return cuentasConMismoSaldo;
    }
    static void retirar(){
        System.out.println("Introduce la cantidad a retirar");
        float cantidad= Float.parseFloat(entrada.nextLine());
        cuentaActual.retirar(cantidad);
    }
    static void ingresar(){
        System.out.println("Introduce la cantidad a ingresar");
        double cantidad= Double.parseDouble(entrada.nextLine());
        cuentaActual.ingresar(cantidad);
    }
    static void seleccionarCuenta(){
        //No hay cuentas
        if (clientes.isEmpty()) {
            System.out.println("No hay cuentas en la sucursal crea una cuenta");
            return;
        }
        //2. Seleccionar la cuenta con la que se quiere trabajar
        int numCuenta;
        String nombre;
        Cliente cliente;
        do {
            //Hacemos lo mismo que en cliente
            System.out.println("Introduce el nombre del cliente para abrir la cuenta");

            for(Cuenta c:cuentas){
                System.out.println(c.getNumeroCuenta());
            }//Recorrer los numeros de las cuentas
            nombre=entrada.nextLine();
            cliente= validarCliente(nombre);
            numCuenta = entrada.nextInt();

            
        } while (!validarCuenta(numCuenta));
    }
    static boolean validarCuenta(int numCuenta){
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta()==numCuenta);
            return true; //Devuelve el cliente
            
        }
        return false; //Si no existe el cliente
    }
    static void mantenimientoCuenta(){
        String s="""
                1.Ingresar
                2.Retirar
                3.Ver Datos Cuenta
                4.Volver al menu ppal
                5. eliminar cuenta
                """;
                System.out.println(s);
                int opcion =0;
        while (opcion!=4) {
            opcion=Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1:
                crearCliente();
                break;
                case 2:
                crearCuenta();
                break;
                case 3:
                System.out.println("Introduce el numero de cuenta que quieres buscar");
                int numeroCuenta=entrada.nextInt();
                for (Cuenta cuenta : cuentas) {
                    if (cuenta.getNumeroCuenta()==numeroCuenta) {
                            System.out.println("Te digo sus datos");
                            cuenta.toString();
                    }
                }
                    
                    break;
                    case 4:
                    System.out.println("gracias por venir");
                    break;
                    case 5:
                    
                    System.out.println("Introduce la palabra para eliminar el cliente");
                    String palabrasecreta=entrada.nextLine();
                    if (palabrasecreta.equals("eliminar")){
                    System.out.println("Lista de clientes");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getNombreCompleto());
                    }
                    eliminarCliente();
                    break;
                }
                    else{
                        System.out.println("Cagaste");
                    }
                break;
            
                default:
                System.out.println("Selecciona una opcion entre 1 y 4");
                    break;
            }
        }

    }
    //Esto ha sido mandado de deberes para aprender
    static void eliminarCliente(){
        //Crear el metodo que elimina al cliente tras introducir nombre y apellidos
        System.out.println("Introduce el nombre de la persona a eliminar");
        String nombreClienteAEliminar=entrada.nextLine();
        boolean existeix=false;
        for (Cliente c: clientes) {
            if (c.getNombre().equals(nombreClienteAEliminar)) {
                System.out.println("S'ha trobat un client en el nom que dius");
                existeix=true;
            }
            else{
                System.out.println("No s'ha trobat res, eixim de esto");
                break;
            }
        }            
        for (Cuenta c : cuentas) { //Eliminem en els comptes que figure el titular
            if (c.getTitular().equals(nombreClienteAEliminar)) {
                System.out.println("S'ha trobat un compte que té eixe client i el eliminem");
                cuentas.remove(c);
            }else{
                System.out.println("El titular existeix pero no te cuentes");
                break;
            }
        }
        if (existeix){
            for (Cliente cliente : clientes) {
                if (cliente.getNombre().equals(nombreClienteAEliminar)) {
                    clientes.remove(cliente);
                    
                }
            }
            }
        
    }
    
    static Cliente  validarCliente(String nombre){
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre));
            return c; //Devuelve el cliente
            
        }
        return null; //Si no existe el cliente
    }


    static void crearCuenta(){
        //Diversas opciones
        //No hay clientes y no se puede crear la cuenta
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la sucursal. No se puede crear una cuenta");
            return;
            
        }
        //Si hay clientes
        String nombre;
        Cliente cliente;
        do{
            System.out.println("Introduce el nombre del cliente para abrir la cuenta");
            for(Cliente c:clientes){
                System.out.println(c.getNombre());
            }//Recorrer los nombres de los clientes
            nombre = entrada.nextLine();
            cliente=validarCliente(nombre);
        }while(cliente==null);
    }


    static void crearCliente(){
        System.out.println("Introduce el nombre");
        String nombre=entrada.nextLine();
        System.out.println("Introduce el apellido");
        String apellido=entrada.nextLine();
        System.out.println("Introduce la direccion");
        String direccion=entrada.nextLine();
        System.out.println("Introduce la localidad");
        String localidad=entrada.nextLine();
        System.out.println("Introduce la fecha de nacimiento en dormato YYYY-MM-DD");
        String fechaNacimiento=entrada.nextLine();
        //Creamos el cliente con los datos dados
        Cliente cliente = new Cliente(nombre, apellido, direccion, localidad);
        System.out.println(cliente.toString());
        System.out.println("El cliente se ha creado correctamente");
    }
    static void menuPrincipal(){
        String s= """
                1. CrearCliente
                2.Crear Cuenta
                3.Mantenimiento Cuenta
                4.Salir
                """;
                System.out.println(s);
    }
}
