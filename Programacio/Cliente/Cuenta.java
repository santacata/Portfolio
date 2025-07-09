package Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Cuenta {

    private int numerocuenta;
    private int saldo;
    private Cliente titular;

    //Cuando creemos una cuenta tendrá un titular

    private ArrayList<Movimiento> movimientos;
    private class Movimiento{

        private LocalDate fechaHora;
        private Byte tipo;
        private double importe;
        private double saldoFinal;

        //PARA REPRESENTAR EL TIPO MOVIMIENTO ASIGNAMOS UN VALOR A CADA MOVIMIENTO

        public static final byte INGRESO=0;
        public static final byte RETIRADA=1;

        public Movimiento(LocalDate fechaHora, Byte tipo, double importe) {
            this.fechaHora = fechaHora;
            this.tipo = tipo;
            this.importe = importe;
        }
        @Override
        public String toString(){
            return (tipo== INGRESO?"INGRESO":"RETIRADA")+fechaHora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        }
        public LocalDate getFechaHora() {
            return fechaHora;
        }
        public void setFechaHora(LocalDate fechaHora) {
            this.fechaHora = fechaHora;
        }
        public Byte getTipo() {
            return tipo;
        }
        public void setTipo(Byte tipo) {
            this.tipo = tipo;
        }
        public double getImporte() {
            return importe;
        }
        public void setImporte(double importe) {
            this.importe = importe;
        }
        public double getSaldoFinal() {
            return saldoFinal;
        }
        public void setSaldoFinal(double saldoFinal) {
            this.saldoFinal = saldoFinal;
        }
        public static byte getIngreso() {
            return INGRESO;
        }
        public static byte getRetirada() {
            return RETIRADA;
        }
    }
    public int getNumerocuenta() {
        return numerocuenta;
    }
    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    } 
       public Cuenta(int numerocuenta, int saldo, Cliente titular, ArrayList<Movimiento> movimientos) {
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = movimientos;
    }
    //METODO PARA INGRESAR
    public void ingresar(double cantidad){
        //El ingreso ha de ser pos
        if (cantidad<0) {
            System.out.println("No se puede ingresar una cantidad negativa");
            return;
        }
        saldo+=cantidad;
        movimientos.add(new Movimiento(LocalDate.now(), Movimiento.INGRESO, cantidad));


        System.out.println("Se ha INGRESADO"+cantidad+" en la cuenta "+numerocuenta +"de "+titular.nombreCompleto()+"y su saldo actual es"+saldo);
    }
    public void retirar(double cantidad){
        //El ingreso ha de ser pos
        if (cantidad<0) {
            System.out.println("No se puede retirar una cantidad negativa");
            return;
        }
        if (cantidad>saldo) {
            System.out.println("No hay suficiente saldo");
            return;
            
        }
        saldo-=cantidad;

        //Creamos el movimiento
        movimientos.add(new Movimiento(LocalDate.now(), Movimiento.RETIRADA, cantidad));

        System.out.println("Se ha RETIRADO"+cantidad+" en la cuenta "+numerocuenta +"de "+titular.nombreCompleto()+"y su saldo actual es"+saldo);
    }

    @Override
    public String toString(){
        return numerocuenta+" "+titular.nombreCompleto();
    }
        //LOS MOVIMIENTOS SE GUARDAN EN UN ARRAYLIST DE MOVIMIENTOS
        //METODO PARA MOSTRAR ARRAYLIST DE LA CUENTA
    public String obtenerMovimientos(){
            String s="";
            for (Movimiento movimiento : movimientos) {
                s+=movimiento.toString();
                
            }
            return s;
    }

    public void verDatos(){
            String s="";

    }
}
