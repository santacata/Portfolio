import java.util.ArrayList;

public class Banco {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        CuentaCorriente cc1 = new CuentaCorriente("ES1234567890123456789012", 1000);
        CuentaAhorro ca1 = new CuentaAhorro("ES9876543210987654321098", 5000, 1000);
        CuentaAhorro ca2 = new CuentaAhorro("ES5678901234567890123456", 800, 1000);
        
        cuentas.add(cc1);
        cuentas.add(ca1);
        cuentas.add(ca2);
        
        // Realizar operaciones
        cc1.ingresar(500);
        ca1.retirar(1000);
        cc1.traspasar(200, ca2);
        
        // Calcular intereses
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.calcularIntereses();
        }
        
        // Mostrar datos
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.mostrarDatos();
        }
    }
}