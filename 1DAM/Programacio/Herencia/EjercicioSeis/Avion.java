class Avion extends VehiculoAereo {
    private double tiempoMaxVuelo;

    public Avion(String matricula, String modelo, int numAsientos, double tiempoMaxVuelo) {
        super(matricula, modelo, numAsientos);
        this.tiempoMaxVuelo = tiempoMaxVuelo;
    }

    @Override
    public void imprimir() {
        System.out.println("Avión - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Asientos: " + numAsientos + ", Tiempo máximo de vuelo: " + 
                          tiempoMaxVuelo + "h");
    }
}