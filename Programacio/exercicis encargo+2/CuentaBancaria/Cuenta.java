import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public abstract class Cuenta {

    private int numeroCuenta; // identificador de la cuenta
    private double saldo;
    private double interes; //Los declaramos porque lo dice el ejercicio
    public abstract double getInteres();
    double comision=0.6;
    public abstract double getComision();
    private Cliente titular; // Cuando creemos una cuenta, tendrá un titular, apuntando a un cliente
    private ArrayList<Movimiento> movimientos;
    private double puntos=0;//Por defecto todos tienen 0 puntos




    //constructor
    public Cuenta(int numeroCuenta, double saldo, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        
        // cuando creamos una cuenta, creamos un arrayList de movimientos vacio sin movimientos. Lo inicializamos
        this.movimientos = new ArrayList<Movimiento>();
        //Añadimos la cuenta a CuentasTodas de AppSucursal
        AppSucursal.getCuentasTodas().add(this);
        
    } // fin constructor
    
    
        // Getters y setters
    
        public int getNumeroCuenta() {
            return numeroCuenta;
        }
    
        public void setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }
    
        public double getSaldo() {
            return saldo;
        }
    
        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
    
        public Cliente getTitular() {
            return titular;
        }
    
        public void setTitular(Cliente titular) {
            this.titular = titular;
        }
        public double getPuntos() {
            return puntos;
        }
    
    
        public void setPuntos(int puntos) {
            this.puntos = puntos;
        }

    //Metodo Ingresar
    public void ingresar(double cantidad) {
        // el ingreso debe ser positivo
        if (cantidad < 0) {
            System.out.println("No se puede ingresar una cantidad negativa");
            return;  //Se sale si es negativo
        }//fin if
        saldo += cantidad;
        puntos=+cantidad/6;

        // crear clase movimiento. Añadimos al arrayList de movimientos un nuevo
        // movimiento
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.INGRESO));
        
        System.out.println("Se han ingresado " + cantidad + "eur" 
                + " en la cuenta "
                + numeroCuenta + " de " + titular.getNombreCompleto() 
                + " y el saldo actual es " + saldo + "eur"+" los puntos son "+(int)puntos);
        

    } // fin metodo ingresar

    // Metodo Retirar
    public void retirar(float cantidad) {
        // el ingreso debe ser positivo
        if (cantidad < 0) {
            System.out.println("No se puede retirar una cantidad negativa");
            return; // para que no siga ejecutando el metodo

        } // fin if

        if (this instanceof Fondo_inversion) {
            if (saldo - cantidad < -500) {
                System.out.println("No hay suficiente saldo para esta operación (límite -500)");
                return;
            }
        } else {
            if (saldo - cantidad < 0) {
                System.out.println("No tienes saldo suficiente para esta operación");
                return;
            }
        }

        // se retira y se registra el movimiento
        saldo -= cantidad;

        // crear clase movimiento
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.RETIRADA)); 
        // el valor es 1 porque es un atributo de la clase Movimiento
                                                                                            
    

        System.out.println("Se han retirado " + cantidad + "eur" 
        + " en la cuenta " + numeroCuenta 
        + " de " + titular.getNombreCompleto() 
        + " y el saldo actual es " + saldo + "eur");
        // titular.nombreCompleto() es un metodo de la clase Cliente
    
    } // fin metodo retirar


    // Datos mas resumidos
    @Override // sobreescribimos el metodo toString de la clase Object
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta 
        + ", titular=" + titular.getNombreCompleto() + ", saldo="+saldo+"]";
    }




    /*
     * La clase Movimiento no tiene sentido sin la clase Cuenta,
     * por lo que la clase Movimiento es una clase interna de la clase Cuenta.
     * Si una cuenta se elimina, todos sus movimientos se eliminarán también.
     * 
     */
    // Solo la uso para ingresar y retirar
    //CLASE MOVIMIENTO

    private class Movimiento { // sin public, porque es una clase interna.

    
        private LocalDateTime fechaHora;
        private Byte tipo;
        private double importe;
        private double SaldoFinal;

        // PARA REPRESENTAR EL TIPO DE MOVIMIENTO
        // ASIGNAMOS UN VALOR A CADA TIPO DE MOVIMIENTO
        //Valores mas descriptivos que 0 y 1. Mejor legibilidad del codigo

        
        public static final byte INGRESO = 0;
        public static final byte RETIRADA = 1;

        public Movimiento(LocalDateTime fechaHora, double importe, Byte tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;

            this.SaldoFinal = saldo;
            // saldo es un atributo de la clase Cuenta y puedo acceder a el
            this.tipo = tipo;
        }

        // Un string con los datos del movimiento
        @Override
        public String toString() {
            return (tipo == INGRESO ? "Ingreso: " : "Retirada: ")
                    + "[ Fecha = " + fechaHora.format(DateTimeFormatter.ofLocalizedDateTime
                    (FormatStyle.MEDIUM))
                    // a través de la clase DateTimeFormatter, formateamos la fecha y la hora con un
                    // formato concreto
                    // a traves de la instancia de la clase DateTimeFormatter con fechaHora
                    + ", hora = " + fechaHora.format(DateTimeFormatter.ofLocalizedTime
                    (FormatStyle.MEDIUM))
                    + ", importe = " + importe + "eur"
                    + ", saldo = " + SaldoFinal + "eur"
                    + "]";
        }
    } // FIN CLASE MOVIMIENTO


    // Los movimientos se guardan en un arrayList de movimientos
    //Metodo para mostrar los movimientos de la cuenta
    public String obtenerMovimientos() {
        String s = "";
        for (Movimiento move : movimientos) {
            // en cada iteracion guarda en move un objeto de tipo Movimiento
            // usamos el toString de la clase Movimiento
            s += move.toString() + "\n";
        }
        return s;
        // en s tendremos todos los movimientos de la cuenta enm un String por lineas
        
    } //fin metodo obtenerMovimientos




    // Metodo para mostrar los datos de la cuenta
    public void verDatos() {
        // mostramos los datos de la cuenta
        // generamos una string con los datos de la cuenta

        String s = "";
        s += "Numero de cuenta: " + numeroCuenta + "\n";
        s += "Titular: " + titular.getNombreCompleto() + ", con DNI " 
        + titular.getDNI() + "\n";
        s += "Saldo: " + saldo + "\n";
        s += "-------------------------Movimientos--------------------------------------------- \n";
        s += obtenerMovimientos();  // añadimos los movimientos de la cuenta
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(s);
    }

}
