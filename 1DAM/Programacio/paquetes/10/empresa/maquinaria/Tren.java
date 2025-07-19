import personal.Maquinista;

public class Tren {
    private Locomotora locomotora;
    private Vagon[] vagones;
    private int cantidadVagones;
    private Maquinista maquinista;

    private static final int MAX_VAGONES = 5;

    public Tren(Locomotora locomotora, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagones = new Vagon[MAX_VAGONES];
        this.cantidadVagones = 0;
    }

    public void agregarVagon(Vagon vagon) {
        if (cantidadVagones < MAX_VAGONES) {
            vagones[cantidadVagones++] = vagon;
        }
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }
    
    public Maquinista getMaquinista() {
        return maquinista;
    }
}