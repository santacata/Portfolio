class Submarino extends VehiculoAcuatico {
    private double profundidadMaxima;

    public Submarino(String matricula, String modelo, double eslora, double profundidadMaxima) {
        super(matricula, modelo, eslora);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public void imprimir() {
        System.out.println("Submarino - Matrícula: " + matricula + ", Modelo: " + modelo + 
                          ", Eslora: " + eslora + "m, Profundidad máxima: " + 
                          profundidadMaxima + "m");
    }
}