import personal.Mecánico;

public class Locomotora {
    public String matricula;
    public int potencia;
    public int añoFabricacion;
    private Mecánico mecanicoAsignado;

    public Locomotora(String matricula, int potencia, int añoFabricacion, Mecánico mecanicoAsignado) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.añoFabricacion = añoFabricacion;
        this.mecanicoAsignado = mecanicoAsignado;
    }
}