abstract class VehiculoTerrestre extends Vehiculo {
    protected final int numRuedas;

    public VehiculoTerrestre(String matricula, String modelo, int numRuedas) {
        super(matricula, modelo);
        this.numRuedas = numRuedas;
    }

    @Override
    public void imprimir() {
        System.out.println("Vehículo terrestre - Matrícula: " + matricula + 
                          ", Modelo: " + modelo + ", Ruedas: " + numRuedas);
    }
}