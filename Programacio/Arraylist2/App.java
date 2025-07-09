import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Punto> puntos= new ArrayList<>();

        //Crear 4 puntos
        Punto p2= new Punto(1);
        Punto p1= new Punto(2, 3,"p2");
        Punto p3= new Punto(4, "p3");
        Punto p4= new Punto(2, 3,"p4");

        //Añadir puntos al arraylist
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(p4);

        puntos.add(new Punto(5,5,"p5")); //Se inserta en posicion 4

        Punto aux=puntos.get(4); //Devuelve la posicion 4

        System.out.println(aux.toString());

        puntos.add(new Punto(7, "p6"));

        //añadir en posicion determinada
        puntos.add(0, new Punto(8,9,"p7")); 
        puntos.add(3, new Punto(7, 8, "null"));

        System.out.println("Mostramos el arraylist de puntos");
        System.out.println(puntos.toString());

        System.out.println("Borramos el punto 'p3'"); 
        puntos.remove(4); //Hemos puesto un punto en la posicion 0
        System.out.println(puntos.toString());

        for (Punto punto : puntos) {
            System.out.println(punto.toStringNombre());
        }
        puntos.remove(new Punto(3,"p3"));
        System.out.println("Despues de borrar el punto 3 ¿Lo borra?");
        System.out.println(puntos.toString());


       System.out.println("mostrar datos con mostrarDatos");
       p1.mostrarDatos();
    }
}
