import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Equipo eq = new Equipo("MiEquipo");

        ArrayList<String> equipos1 = new ArrayList<>();
        equipos1.add("A");
        eq.anyadirFutbolista(new Futbolista("Juan", 24, Futbolista.Posicion.PORTERO, 5, equipos1, 1));

        ArrayList<String> equipos2 = new ArrayList<>();
        equipos2.add("B");
        eq.anyadirFutbolista(new Futbolista("Luis", 26, Futbolista.Posicion.PORTERO, 4, equipos2, 2));

        ArrayList<String> equipos3 = new ArrayList<>();
        equipos3.add("Z");
        eq.anyadirFutbolista(new Futbolista("Extra", 30, Futbolista.Posicion.PORTERO, 10, equipos3, 5)); // exceso

        ArrayList<String> equipos4 = new ArrayList<>();
        equipos4.add("C");
        eq.anyadirFutbolista(new Futbolista("Carlos", 27, Futbolista.Posicion.DEFENSA, 6, equipos4, 0));

        ArrayList<String> equipos5 = new ArrayList<>();
        equipos5.add("D");
        eq.anyadirFutbolista(new Futbolista("Pedro", 28, Futbolista.Posicion.CENTROCAMPISTA, 3, equipos5, 3));

        ArrayList<String> equipos6 = new ArrayList<>();
        equipos6.add("E");
        eq.anyadirFutbolista(new Futbolista("Miguel", 29, Futbolista.Posicion.DELANTERO, 7, equipos6, 4));

        System.out.println("\nFormación del equipo:");
        eq.listarFormacionDelEquipo();
    }
}