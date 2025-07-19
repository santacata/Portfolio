public class Equipo{

    private static final int MAX_JUGADORES = 10;
    private String nombre;
    private Jugador[] jugadores;
    // Relación de agregacion. El equipo tiene un array de jugadores.
    private int cantidad; //Cantidad actual de jugadores en el equipo




    public Equipo(String nombre){
        this.nombre = nombre;
        this.jugadores = new Jugador[MAX_JUGADORES];
        //Inicializa el array con el tamaño máximo
        this.cantidad = 0; // Al inicio está vacio
    }

    public void nuevoJugador(Jugador jugador){
        if (cantidad < MAX_JUGADORES) {
            jugadores[cantidad] = jugador;
            //Agrega el jugador al equipo
            cantidad++;
            jugador.asignarEquipo(this);
            //Relacionamos el jugador con el equipo
        }
    }

    public String getNombre(){
        return nombre;
    }

public void mostrarInformacion() {
    System.out.println("Equipo: " + nombre);
    boolean hayJugadores = false;

    for (Jugador jugador : jugadores) {
        if (jugador != null) {
            System.out.println("Jugador: " + jugador.getNombre());
            hayJugadores = true;
        }
    }

    if (!hayJugadores) {
        System.out.println("No hay jugadores en este equipo");
    }
}

}