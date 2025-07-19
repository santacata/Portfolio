class Coche extends VehiculoTerrestre {
    private boolean aireAcondicionado;

    public Coche(String matricula, String modelo, int numRuedas, boolean aireAcondicionado) {
        super(matricula, modelo, numRuedas);
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public void imprimir() {
        System.out.println("Coche - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Ruedas: " + numRuedas + ", Aire acondicionado: " + 
                          (aireAcondicionado ? "Sí" : "No"));
    }
}