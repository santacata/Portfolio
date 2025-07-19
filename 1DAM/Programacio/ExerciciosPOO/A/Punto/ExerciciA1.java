package Punto;

public class ExerciciA1 {
    public static void main(String[] args) {
        
        Punto punto1 = new Punto(); //Accedeix al per defecte
        Punto punto2 = new Punto(10, 10); //Accedeix amb paràmetres
        Punto punto3 = new Punto(-3, 7);

        
        System.out.println("Punt 1: (" + punto1.x + ", " + punto1.y + ")");
        System.out.println("Punt 2: (" + punto2.x + ", " + punto2.y + ")");
        System.out.println("Punt 3: (" + punto3.x + ", " + punto3.y + ")");

       
        punto1.x += 3;
        punto1.y -= 1;
        punto2.x *= 2;
        punto2.y /= 2;
        punto3.x -= 5;
        punto3.y += 3;

        System.out.println();
        System.out.println("Coordenades modificades:");
        System.out.println("Punt 1: (" + punto1.x + ", " + punto1.y + ")");
        System.out.println("Punt 2: (" + punto2.x + ", " + punto2.y + ")");
        System.out.println("Punt 3: (" + punto3.x + ", " + punto3.y + ")");
    }
}