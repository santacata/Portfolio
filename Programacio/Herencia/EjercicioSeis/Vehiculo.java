abstract class Vehiculo {
    protected final String matricula;
    protected final String modelo;

    public Vehiculo(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public abstract void imprimir();
}