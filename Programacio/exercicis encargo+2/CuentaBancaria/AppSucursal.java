import java.util.ArrayList;
import java.util.Scanner;

public class AppSucursal {
    //Scanner global
    private static Scanner entrada=new Scanner(System.in);
    //Aqui se almacena TODo    
    private static ArrayList <Cuenta> cuentasTodas= new ArrayList<>();
    public static ArrayList<Cliente> clientes= new ArrayList<>(); 
    public static ArrayList<Banco> bancos= new ArrayList<>();


public static void main(String[] args) {
        int opcion = 0;
        while (opcion!=4) {
            menuPrincipal();
            opcion=Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1:
                System.out.println("Has Elegido Administrador");
                int subOpcion1=0;
                while (subOpcion1!=4) {
                menuAdministrador();
                subOpcion1=Integer.parseInt(entrada.nextLine());
                switch (subOpcion1) {
                    case 1:
                        System.out.println("Creamos un banco");
                        crearBanco();
                    break;
                    case 2:
                        System.out.println("Revision de todas las cuentas de este banco");
                        revisionCuentas();
                    break;
                    case 3:
                        System.out.println("Volviendo al menu principal");
                    break;
                    default:
                    break;
                }
                }
                    
                break;
                case 2:
                System.out.println("Gestion de clientes");
                int subOpcion2=0;
                while (subOpcion2!=4) {
                    submenu2();
                    subOpcion2=Integer.parseInt(entrada.nextLine());
                    switch (subOpcion2) {
                        case 1:
                            System.out.println("Has elegido crear cliente");
                            crearCliente();
                        break;
                        case 2:
                            System.out.println("Has elegido dar de baja a un cliente, y consecuentemente sus cuentas");
                            eliminarCliente();
                        break;
                        case 3:
                            System.out.println("Has elegido la modificación de un cliente");
                            crearCliente(); //Se crea uno nuevo y se elimina el viejo
                            eliminarCliente(); //Se elimina el viejo
                        break;
                        case 4:
                            System.out.println("Volviendo al menu principal");
                        break;
                    
                        default:
                        System.out.println("No has introducido valores enteros del 1 al 4");
                        break;
                    }
                }
                
                
                break;
                case 3:
                System.out.println("Gestion de cuentas");
                int subOpcion3=0;
                while (subOpcion3!=7) {
                        submenu3();
                        subOpcion3=Integer.parseInt(entrada.nextLine());
                        switch (subOpcion3) {
                            case 1:
                            System.out.println("creamos una cuenta");
                                crearCuenta();
                            break;
                            case 2:
                                System.out.println("Ingresamos dinero");
                                System.out.println("Dime el num de la cuenta donde lo quieres ingresar");
                                ingresar(entrada.nextInt());
                            break;
                            case 3:
                                System.out.println("Retiramos dinero");
                                System.out.println("Dime el num de la cuenta donde quieres retirar");
                                retirar(entrada.nextInt());
                            break;
                            case 4:
                                System.out.println("Consultamos nuestro sueldo");
                                consultarSaldo();
                            break;
                            case 5:
                                System.out.println("Consultamos nuestros puntos");
                                consultarPuntos();
                            break;
                            case 6:
                                System.out.println("Revision Mensual");
                                revisionMensual();
                            break;
                        
                            default:
                            System.out.println("Selecciona un entero del 1-5");
                            break;
                        }
                
                
                
                }

                break;
                case 4:
                System.out.println("Gracias por venir");
                break;
            
                default:
                System.out.println("Selecciona una opcion entre 1y 4");
                    break;
            }
            
        }
    } //Fin main

    static void retirar(int numeroCuenta){
        Cuenta cuentaOperacion=null;
        for (Cuenta c  : cuentasTodas) {
            if (c.getNumeroCuenta()==numeroCuenta) {
                cuentaOperacion=c;
                break;//No hace falta que continue
            }
        }
        System.out.println("Introduce la cantidad a retirar");
        float cantidad= Float.parseFloat(entrada.nextLine());
        if (cuentaOperacion!=null) {
            cuentaOperacion.retirar(cantidad);
        }
    }
    static void ingresar(int numeroCuenta){
        Cuenta cuentaOperacion=null;
        for (Cuenta c  : cuentasTodas) {
            if (c.getNumeroCuenta()==numeroCuenta) {
                cuentaOperacion=c;
                break;//No hace falta que continue
            }
        }
        System.out.println("Introduce la cantidad a ingresar");
        double cantidad= Double.parseDouble(entrada.nextLine());
        if (cuentaOperacion!=null) {
            cuentaOperacion.ingresar(cantidad);
        }
        
    }

    static void eliminarCliente(){
        //Crear el metodo que elimina al cliente tras introducir nombre y apellidos
        System.out.println("Introduce el nombre de la persona a eliminar");
        String nombreClienteAEliminar=entrada.nextLine();
        boolean existeix=false;
        Cliente aEliminar=null;
        for (Cliente c: clientes) {
            if (c.getNombre().equals(nombreClienteAEliminar)) {
                System.out.println("S'ha trobat un client en el nom que dius");
                aEliminar=c;
            }
            else{
                System.out.println("No s'ha trobat res, eixim de esto");
                break;
            }
        }            
        for (Cuenta c : aEliminar.getCuentas()) { //Eliminem en els comptes que figure el titular
            if (c.getTitular().equals(nombreClienteAEliminar)) {
                System.out.println("S'ha trobat un compte que té eixe client i el eliminem");
                aEliminar.getCuentas().remove(c);
            }else{
                System.out.println("El titular existeix pero no te comptes");
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
    
    static Cuenta  validarCuenta(int numeroCuenta){
        for (Cuenta c : cuentasTodas) {
            if (c.getNumeroCuenta()==(numeroCuenta));
            return c; //Devuelve la cuenta
            
        }
        return null; //Si no existe la cuenta devuelve null
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
        System.out.println("Introduce su dni");
        String dni=entrada.nextLine();
        //Creamos el cliente con los datos dados
        Cliente cliente = new Cliente(nombre, apellido, direccion, dni);
        System.out.println(cliente.toString());
        System.out.println("El cliente se ha creado correctamente");
    }
    static void menuPrincipal(){
        String s= """
                1. Administrador
                2. Gestión de clientes (Alta, Baja, Modificación)
                3. Gestión de cuentas (para un cliente seleccionado)
                4. Salir
                """;
                System.out.println(s);
    }
    static void submenu3(){
        String s= """
                3.1.- Crear cuenta
                3.2.- Ingresar dinero
                3.3.- Sacar dinero
                3.4.- Consultar saldo
                3.5.- Consulta puntos
                3.6.- Revisión mensual
                3.7. - Volver al menu ppal
                """;
                System.out.println(s);
    }
    static void menuAdministrador(){
        String s= """
                1.1.- Creación de banco
                1.2.- Revisión de todas las cuentas
                1.3 - Volver al menu ppal
                """;
                System.out.println(s);
    }
    static void submenu2(){
        String s= """
                2.1.- Alta de Cliente
                2.2.- Baja de Cliente
                2.3 - Modificación de cliente
                2.4 - Volver al menú principal
                """;
                System.out.println(s);
    }
    static void consultarSaldo(){
        System.out.println("Dime el numero cuenta del que quieres consultar el saldo y su banco");
        Cuenta cuentaAConsultar=validarCuenta(entrada.nextInt());
        cuentaAConsultar.toString();
    }
    static void consultarPuntos(){
        System.out.println("Dime el numcuenta quieres consultar los puntos.");
        int numeroABuscar=entrada.nextInt();
        Cuenta cuentaAConsultar=null;
        for (Cuenta cuenta : cuentasTodas) {
            if (cuenta.getNumeroCuenta()==numeroABuscar) {
                cuentaAConsultar=cuenta;
            }
            if (cuentaAConsultar!=null) {
                System.out.println("Los puntos de la cuenta son "+cuentaAConsultar.getPuntos());
            }else{
                System.out.println("No hay ninguna cuenta con ese numero en la BBDD");
            }
        }
        
    }

    public static ArrayList<Cuenta> getCuentasTodas() {
        return cuentasTodas;
    }

    public static void crearBanco(){
        System.out.println("creamos un banco");
        System.out.println("Dime el nombre y su localidad");
        Banco nuevoBanco=new Banco(entrada.nextLine(), entrada.nextLine()); //Uso nextLine porque next no admite espacios
    }
    public static ArrayList<Banco> getBancos() {
        return bancos;
    }
    public static void revisionCuentas(){
            for (Cuenta cuenta : cuentasTodas) {
                cuenta.toString();
            }
    }
    public static void revisionMensual(){
        for (Cuenta cuenta : cuentasTodas) { //Se aplica a todas las cuentas una revisión
            cuenta.setSaldo(cuenta.getSaldo()+(cuenta.getSaldo()*cuenta.getInteres())-cuenta.getComision());
        }
    }
}
