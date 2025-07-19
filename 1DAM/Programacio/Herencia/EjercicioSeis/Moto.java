class Moto extends VehiculoTerrestre {
    private String color;

    public Moto(String matricula, String modelo, int numRuedas, String color) {
        super(matricula, modelo, numRuedas);
        this.color = color;
    }

    @Override
    public void imprimir() {
        System.out.println("Moto - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Ruedas: " + numRuedas + ", Color: " + color);
    }
}