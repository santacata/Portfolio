import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppSucursal {
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Cuenta> cuentasTodas = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Banco> bancos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 4) {
            menuPrincipal();
            opcion = leerEntero("Selecciona una opción:");
            switch (opcion) {
                case 1 -> menuAdministradorFlow();
                case 2 -> menuClientesFlow();
                case 3 -> menuCuentasFlow();
                case 4 -> System.out.println("Gracias por venir");
                default -> System.out.println("Selecciona una opción entre 1 y 4");
            }
        }
    }

    static void menuAdministradorFlow() {
        System.out.println("Has elegido Administrador");
        int subOpcion;
        do {
            menuAdministrador();
            subOpcion = leerEntero("Opción:");
            switch (subOpcion) {
                case 1 -> crearBanco();
                case 2 -> revisionCuentas();
                case 3 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Opción no válida.");
            }
        } while (subOpcion != 3);
    }

    static void menuClientesFlow() {
        System.out.println("Gestión de clientes");
        int subOpcion;
        do {
            submenu2();
            subOpcion = leerEntero("Opción:");
            switch (subOpcion) {
                case 1 -> crearCliente();
                case 2 -> eliminarCliente();
                case 3 -> modificarCliente();
                case 4 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("No has introducido valores enteros del 1 al 4");
            }
        } while (subOpcion != 4);
    }

    static void menuCuentasFlow() {
        System.out.println("Gestión de cuentas");
        int subOpcion;
        do {
            submenu3();
            subOpcion = leerEntero("Opción:");
            switch (subOpcion) {
                case 1 -> crearCuenta();
                case 2 -> ingresar(leerEntero("Número de cuenta para ingresar:"));
                case 3 -> retirar(leerEntero("Número de cuenta para retirar:"));
                case 4 -> consultarSaldo();
                case 5 -> consultarPuntos();
                case 6 -> revisionMensual();
                case 7 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Selecciona un entero del 1 al 7");
            }
        } while (subOpcion != 7);
    }

    static void retirar(int numeroCuenta) {
        Cuenta cuenta = validarCuenta(numeroCuenta);
        if (cuenta != null) {
            float cantidad = leerFloat("Introduce la cantidad a retirar:");
            cuenta.retirar(cantidad);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    static void ingresar(int numeroCuenta) {
        Cuenta cuenta = validarCuenta(numeroCuenta);
        if (cuenta != null) {
            double cantidad = leerDouble("Introduce la cantidad a ingresar:");
            cuenta.ingresar(cantidad);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    static void eliminarCliente() {
        System.out.print("Introduce el nombre del cliente a eliminar: ");
        String nombre = entrada.nextLine();
        Cliente cliente = validarCliente(nombre);
        if (cliente != null) {
            cuentasTodas.removeIf(c -> c.getTitular().equals(cliente.getNombre()));
            clientes.remove(cliente);
            System.out.println("Cliente y sus cuentas eliminados.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    static void modificarCliente() {
        System.out.print("Introduce el nombre del cliente a modificar: ");
        String nombre = entrada.nextLine();
        Cliente cliente = validarCliente(nombre);
        if (cliente != null) {
            System.out.println("Introduce nuevos datos:");
            System.out.print("Nuevo apellido: ");
            cliente.setApellido(entrada.nextLine());
            System.out.print("Nueva dirección: ");
            cliente.setDireccion(entrada.nextLine());
            System.out.print("Nuevo DNI: ");
            cliente.setDni(entrada.nextLine());
            System.out.println("Cliente modificado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes. No se puede crear una cuenta.");
            return;
        }

        Cliente cliente;
        do {
            System.out.println("Introduce el nombre del cliente:");
            clientes.forEach(c -> System.out.println("- " + c.getNombre()));
            cliente = validarCliente(entrada.nextLine());
            if (cliente == null) System.out.println("Cliente no encontrado.");
        } while (cliente == null);

        int numCuenta = leerEntero("Introduce el número de cuenta:");
        double saldo = leerDouble("Introduce el saldo inicial:");

        Cuenta cuenta = new Cuenta_corriente(numCuenta, saldo, cliente);
        cuentasTodas.add(cuenta);
        cliente.getCuentas().add(cuenta);
        System.out.println("Cuenta creada correctamente.");
    }

    static void crearCliente() {
        System.out.print("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el apellido: ");
        String apellido = entrada.nextLine();
        System.out.print("Introduce la dirección: ");
        String direccion = entrada.nextLine();
        System.out.print("Introduce el DNI: ");
        String dni = entrada.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, direccion, dni);
        clientes.add(cliente);
        System.out.println("Cliente creado correctamente.");
    }

    static Cuenta validarCuenta(int numeroCuenta) {
        for (Cuenta c : cuentasTodas) {
            if (c.getNumeroCuenta() == numeroCuenta) return c;
        }
        return null;
    }

    static Cliente validarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) return c;
        }
        return null;
    }

    static void consultarSaldo() {
        int num = leerEntero("Introduce el número de cuenta:");
        Cuenta c = validarCuenta(num);
        if (c != null) System.out.println(c);
        else System.out.println("Cuenta no encontrada.");
    }

    static void consultarPuntos() {
        int num = leerEntero("Introduce el número de cuenta:");
        Cuenta c = validarCuenta(num);
        if (c != null) System.out.println("Puntos: " + c.getPuntos());
        else System.out.println("Cuenta no encontrada.");
    }

    public static void crearBanco() {
        System.out.print("Nombre del banco: ");
        String nombre = entrada.nextLine();
        System.out.print("Localidad: ");
        String localidad = entrada.nextLine();
        bancos.add(new Banco(nombre, localidad));
        System.out.println("Banco creado.");
    }

    public static void revisionCuentas() {
        if (cuentasTodas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            cuentasTodas.forEach(System.out::println);
        }
    }

    public static void revisionMensual() {
        for (Cuenta c : cuentasTodas) {
            double nuevoSaldo = c.getSaldo() + (c.getSaldo() * c.getInteres()) - c.getComision();
            c.setSaldo(nuevoSaldo);
        }
        System.out.println("Revisión mensual aplicada.");
    }

    // Menús
    static void menuPrincipal() {
        System.out.println("""
                --- MENÚ PRINCIPAL ---
                1. Administrador
                2. Gestión de clientes
                3. Gestión de cuentas
                4. Salir""");
    }

    static void submenu3() {
        System.out.println("""
                --- GESTIÓN DE CUENTAS ---
                1. Crear cuenta
                2. Ingresar dinero
                3. Sacar dinero
                4. Consultar saldo
                5. Consultar puntos
                6. Revisión mensual
                7. Volver al menú principal""");
    }

    static void menuAdministrador() {
        System.out.println("""
                --- ADMINISTRADOR ---
                1. Crear banco
                2. Revisión de todas las cuentas
                3. Volver al menú principal""");
    }

    static void submenu2() {
        System.out.println("""
                --- GESTIÓN DE CLIENTES ---
                1. Alta de cliente
                2. Baja de cliente
                3. Modificación de cliente
                4. Volver al menú principal""");
    }

    // Métodos de lectura seguros
    static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + " ");
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número entero válido.");
            }
        }
    }

    static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + " ");
                return Double.parseDouble(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número decimal válido.");
            }
        }
    }

    static float leerFloat(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + " ");
                return Float.parseFloat(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número decimal válido.");
            }
        }
    }
}
