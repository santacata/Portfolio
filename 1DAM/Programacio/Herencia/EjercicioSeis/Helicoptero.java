class Helicoptero extends VehiculoAereo {
    private int numHelices;

    public Helicoptero(String matricula, String modelo, int numAsientos, int numHelices) {
        super(matricula, modelo, numAsientos);
        this.numHelices = numHelices;
    }

    @Override
    public void imprimir() {
        System.out.println("Helicóptero - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Asientos: " + numAsientos + ", Hélices: " + numHelices);
    }
}