class Vagon {
    private int numero;
    private int cargaMaxima;
    private int cargaActual;
    private String tipoMercancia;

    public Vagon(int numero, int cargaMaxima, int cargaActual, String tipoMercancia) {
        this.numero = numero;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    public void getInfo() {
        System.out.println("Número: " + numero);
        System.out.println("Carga máxima: " + cargaMaxima);
        System.out.println("Carga actual: " + cargaActual);
        System.out.println("Tipo de mercancía: " + tipoMercancia);
    }
}