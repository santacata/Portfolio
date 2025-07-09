public class Bombilla {
    private String nombre;
    private boolean estado;
    private InterruptorGeneral interruptor;

    public Bombilla(String nombre, InterruptorGeneral interruptor) {
        this.nombre = nombre;
        this.interruptor = interruptor;
        interruptor.nuevaBombilla(this);
        actualizarEstado();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaEncendida() {
        return estado;
    }

    public void asignarInterruptor(InterruptorGeneral interruptor) {
        if (this.interruptor == null) { 
            this.interruptor = interruptor;
            actualizarEstado(); // Actualizar estado de la bombilla al asignarla
        }
    }

    public void actualizarEstado() {
        if (interruptor != null) {
            estado = interruptor.consultarEstado(); //Asigna true o false segun el interruptor a la bombilla
        }
    }
}
