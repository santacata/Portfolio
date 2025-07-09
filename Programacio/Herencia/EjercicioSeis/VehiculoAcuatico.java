abstract class VehiculoAcuatico extends Vehiculo {
    protected final double eslora;

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo);
        this.eslora = eslora;
    }

    @Override
    public void imprimir() {
        System.out.println("Vehículo acuático - Matrícula: " + matricula + 
                          ", Modelo: " + modelo + ", Eslora: " + eslora + "m");
    }
}