import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<iFigura2D> figuras = new ArrayList<>();
        
        figuras.add(new Cuadrado(5));
        figuras.add(new Rectangulo(4, 6));
        figuras.add(new Triangulo(3, 4));
        figuras.add(new Circulo(2.5));
        System.out.println("--------------------------------");
        System.out.println("Figuras iniciales:");
        for (iFigura2D figura : figuras) {
            figura.imprimir();
        }
        System.out.println("--------------------------------");
        System.out.println("Escalando figuras x2:");
        for (iFigura2D figura : figuras) {
            figura.escalar(2);
            figura.imprimir();
        }
        System.out.println("--------------------------------");
        System.out.println("Escalando figuras x0.1:");
        for (iFigura2D figura : figuras) {
            figura.escalar(0.1);
            figura.imprimir();
        }
        System.out.println("--------------------------------");
    }
}