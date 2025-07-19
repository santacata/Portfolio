package Punto;

public class ExerciciA1 {
    public static void main(String[] args) {
        
        Punto punto1 = new Punto(); //Accedeix al per defecte
        Punto punto2 = new Punto(2, -3);
        Punto punto3 = new Punto(-3, 7);

        
        System.out.println("Punt 1: (" + punto1.getterX() + ", " + punto1.getterY() + ")");
        System.out.println("Punt 2: (" + punto2.getterX() + ", " + punto2.getterY() + ")");
        System.out.println("Punt 3: (" + punto3.getterX() + ", " + punto3.getterY() + ")");

       
        punto1.setterX(punto1.getterX() + 30);
        punto1.setterY(punto1.getterY() - 1);
        punto1.setterX(punto2.getterX() * 2);
        punto1.setterY(punto2.getterY() / 2);
        punto1.setterX(punto3.getterX() - 5);
        punto1.setterY(punto3.getterY() + 3);

        System.out.println();
        System.out.println("Coordenades modificades:");
        System.out.println("Punt 1: (" + punto1.getterX() + ", " + punto1.getterY() + ")");
        System.out.println("Punt 2: (" + punto2.getterX() + ", " + punto2.getterY() + ")");
        System.out.println("Punt 3: (" + punto3.getterX() + ", " + punto3.getterY() + ")");
    }
}