abstract class VehiculoAereo extends Vehiculo {
    protected final int numAsientos;

    public VehiculoAereo(String matricula, String modelo, int numAsientos) {
        super(matricula, modelo);
        this.numAsientos = numAsientos;
    }

    @Override
    public void imprimir() {
        System.out.println("Vehículo aéreo - Matrícula: " + matricula + 
                          ", Modelo: " + modelo + ", Asientos: " + numAsientos);
    }
}