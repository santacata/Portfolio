class Barco extends VehiculoAcuatico {
    private boolean motor;

    public Barco(String matricula, String modelo, double eslora, boolean motor) {
        super(matricula, modelo, eslora);
        this.motor = motor;
    }

    @Override
    public void imprimir() {
        System.out.println("Barco - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Eslora: " + eslora + "m, Motor: " + (motor ? "Sí" : "No"));
    }
}
