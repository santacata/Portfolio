public class App {

    public static void main(String[] args) {
        
        //Crear equipos

        Equipo eq1 = new Equipo("Miau");
        Equipo eq2 = new Equipo("Meow");

        //Crear jugadores

        Jugador jug1 = new Jugador("Ratchet");
        Jugador jug2 = new Jugador("Cusa");
        Jugador jug3 = new Jugador("Alfic");

        System.out.println("Asignar Jugadores");

        eq1.nuevoJugador(jug1);
        eq1.nuevoJugador(jug2);
        eq2.nuevoJugador(jug3);

        System.out.println("Mostrar información de los equipos");
        eq1.mostrarInformacion();
        eq2.mostrarInformacion();

        System.out.println("Mostrar información individual de los jugadores.");
        jug1.mostrarInformacion();
        jug2.mostrarInformacion();
        jug3.mostrarInformacion();
    }
}