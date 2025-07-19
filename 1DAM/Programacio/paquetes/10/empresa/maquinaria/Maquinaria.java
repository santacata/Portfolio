public class Maquinaria {
    private static final int MAX_MAQUINARIA = 10;
    private Locomotora[] locomotoras = new Locomotora[MAX_MAQUINARIA];
    private Tren[] trenes = new Tren[MAX_MAQUINARIA];

    private int cantidadLocomotoras = 0;
    private int cantidadTrenes = 0;

    public void agregarLocomotora(Locomotora locomotora) {
        if (cantidadLocomotoras < MAX_MAQUINARIA) {
            locomotoras[cantidadLocomotoras++] = locomotora;
        }
    }

    public void agregarTren(Tren tren) {
        if (cantidadTrenes < MAX_MAQUINARIA) {
            trenes[cantidadTrenes++] = tren;
        }
    }

    public void mostrarMaquinaria() {
        System.out.println("=== Maquinaria de la Empresa ===");

        System.out.println("\nLocomotoras:");
        for (int i = 0; i < cantidadLocomotoras; i++) {
            System.out.println("- Matrícula: " + locomotoras[i].matricula + 
                               " | Potencia: " + locomotoras[i].potencia + 
                               "CV | Año de Fabricación: " + locomotoras[i].añoFabricacion);
        }

        System.out.println("\nTrenes:");
        for (int i = 0; i < cantidadTrenes; i++) {
            System.out.println("- Tren con locomotora " + trenes[i].getLocomotora().matricula + 
                               " | Maquinista: " + trenes[i].getMaquinista().nombre);
        }
    }
}