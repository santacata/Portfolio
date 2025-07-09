import java.util.ArrayList;

public class Futbolista implements Deportista {
    private String nombre;
    private int edad;
    private Posicion posicion;
    private int anyos;
    private ArrayList<String> equipos;
    private int trofeos;
    public enum Posicion {
        PORTERO(2000, 3000),
        DEFENSA(2500, 3500),
        CENTROCAMPISTA(3500, 4000),
        DELANTERO(4000, 5000);
    
        private double salarioMinimo;
        private double salarioMaximo;
    
        Posicion(double min, double max) {
            salarioMinimo = min;
            salarioMaximo = max;
        }
    
        public double getSalarioMinimo() { return salarioMinimo; }
        public double getSalarioMaximo() { return salarioMaximo; }
    }

    public Futbolista(String nombre, int edad, Posicion posicion, int anyos, ArrayList<String> equipos, int trofeos) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.anyos = anyos;
        this.equipos = equipos;
        this.trofeos = trofeos;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Posicion getPosicion() { return posicion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }
    
    //Override de Getters obligatorios al impplementar
    @Override
    public int getAnyosProfesional() { return anyos; }

    @Override
    public ArrayList<String> getListadoEquipos() { return equipos; }

    @Override
    public int getTotalTrofeos() { return trofeos; }


    //Setters
    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }


    public void setEquipos(ArrayList<String> equipos) {
        this.equipos = equipos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    //Metodo toString    
    @Override
    public String toString() {
        return "Futbolista " + nombre + " con edad " + edad + " que ocupa la posición " + posicion +
               ". Su rango salarial estará entre " + posicion.getSalarioMinimo() +
               " y " + posicion.getSalarioMaximo();
    }
    
}
