import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {
    private String nombre;
    private ArrayList<Futbolista> listaJugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void anyadirFutbolista(Futbolista f) {
        int contador = 0;
        for (Futbolista fut : listaJugadores) {
            if (fut.getPosicion() == f.getPosicion()) {
                contador++;
            }
        }

        boolean sePuede = false;
        if (f.getPosicion() == Futbolista.Posicion.PORTERO && contador < 2) sePuede = true;
        if (f.getPosicion() == Futbolista.Posicion.DEFENSA && contador < 5) sePuede = true;
        if (f.getPosicion() == Futbolista.Posicion.CENTROCAMPISTA && contador < 5) sePuede = true;
        if (f.getPosicion() == Futbolista.Posicion.DELANTERO && contador < 4) sePuede = true;

        if (sePuede) {
            listaJugadores.add(f);
        } else {
            System.out.println("No se puede añadir más " + f.getPosicion() + "S.");
        }
    }

    public void listarFormacionDelEquipo() {
        // Recorremos con Iterator
        Iterator<Futbolista> it =listaJugadores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + ", listaJugadores=" + listaJugadores+ "]";
    }

}