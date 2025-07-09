public class He_Usado_esto_para_probar {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Mar", "Perez", "Calle Simarro 1", "89588984e");

        Cliente cliente2 = new Cliente("Joan", "Carrillo", "Calle Simarro 50", "489585d");

        Cliente cliente3 = new Cliente("Joan", "Carrillo", "Calle Instituot 50", "48151s");

        System.out.println(cliente3.equals(cliente1));

        Cuenta_corriente cuenta1 = new Cuenta_corriente(13, 200, cliente1); //en la comision se indica en entero porque decimos directamente el porcentaje
        Cuenta_vivienda cuenta2 = new Cuenta_vivienda(14, 500, cliente2);
        Fondo_inversion cuenta3= new Fondo_inversion(45, 0, cliente3);

        cuenta1.ingresar(100);
        cuenta1.ingresar(500);
        cuenta1.retirar(120);
        cuenta1.retirar(5000);
        cuenta3.retirar(498);
        cuenta2.ingresar(1000);
        cuenta2.retirar(2000);
        cuenta2.retirar(1000);
        cuenta2.retirar(-500);

        System.out.println("Ver datos de cuenta 1");
        cuenta1.verDatos();

        System.out.println("Ver datos de cuenta 2");
        cuenta2.verDatos();


    }
}
