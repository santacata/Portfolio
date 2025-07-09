public class InterruptorGeneral {
    public boolean estado = true;
    private Bombilla[] bombillas;
    private static final int MAX_BOMBILLAS = 15;
    private int cantidad = 0;

    public InterruptorGeneral() {
        bombillas = new Bombilla[MAX_BOMBILLAS]; // Inicializamos el array de bombillas con un maximo logico de 15
    }

    public void nuevaBombilla(Bombilla bombilla) {
        if (cantidad < MAX_BOMBILLAS) {
            bombillas[cantidad] = bombilla;
            cantidad++;
            bombilla.asignarInterruptor(this);
            bombilla.actualizarEstado(); // Ajustamos el estado de la bombilla según el interruptor
        }
    }

    public void apagarInterruptor() {
        estado = false;
        actualizarBombillas();
    }

    public void encenderInterruptor() {
        estado = true;
        actualizarBombillas();
    }

    public boolean consultarEstado() {
        return estado;
    }

    private void actualizarBombillas() {
        for (int i = 0; i < cantidad; i++) {
            bombillas[i].actualizarEstado(); // Todas las bombillas se actualizan
        }
    }

    public void mostrarInformacion() {
        System.out.println("---- Interruptor ----");
        System.out.println("Estado: " + (estado ? "Encendido" : "Apagado"));

        if (cantidad > 0) {
            System.out.println("Bombillas:");
            for (int i = 0; i < cantidad; i++) {
                System.out.println(" - " + bombillas[i].getNombre() + " [" + (bombillas[i].estaEncendida() ? "Encendida" : "Apagada") + "]"); //Podemos realizar una ternaria enmedio de un println
            }
        } else {
            System.out.println("No hay bombillas aquí");
        }
    }
}
