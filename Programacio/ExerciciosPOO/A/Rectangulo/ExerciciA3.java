package Rectangulo;


public class ExerciciA3 {
    public static void main(String[] args) {
        
        Rectangulo rectangulo1 = new Rectangulo(); //Accedeix al per defecte
        Rectangulo rectangulo2 = new Rectangulo(10, 10,21,23,45,65,45,78); //Accedeix amb paràmetres

        
        System.out.println("Rectangulo 1: (" + rectangulo1.x1 + ", " + rectangulo1.y1 + ", " +rectangulo1.x2 + ", " + rectangulo1.y2 + ", " + rectangulo1.x3 + ", " + rectangulo1.y3 + ", " + rectangulo1.x4 + ", " + rectangulo1.y4 +   ")");
        System.out.println("Rectangulo 2: (" + rectangulo2.x1 + ", " + rectangulo2.y1 + ", " +rectangulo2.x2 + ", " + rectangulo2.y2 + ", " + rectangulo2.x3 + ", " + rectangulo2.y3 + ", " + rectangulo2.x4 + ", " + rectangulo2.y4 +   ")");

       
        rectangulo1.x1 += 3;
        rectangulo1.y1-= 1;
        rectangulo1.x2 *= 2;
        rectangulo1.y2 /= 2;
        rectangulo1.x3 -= 5;
        rectangulo1.y3 += 3;
        rectangulo1.y4 /= 2;
        rectangulo1.x4 -= 5;

        rectangulo2.x1 += 3;
        rectangulo2.y1-= 1;
        rectangulo2.x2 *= 2;
        rectangulo2.y2 /= 2;
        rectangulo2.x3 -= 5;
        rectangulo2.y3 += 3;
        rectangulo2.y4 /= 2;
        rectangulo2.x4 -= 5;

        System.out.println();
        System.out.println("Coordenades modificades:");
        System.out.println("Rectangulo 1: (" + rectangulo1.x1 + ", " + rectangulo1.y1 + ", " +rectangulo1.x2 + ", " + rectangulo1.y2 + ", " + rectangulo1.x3 + ", " + rectangulo1.y3 + ", " + rectangulo1.x4 + ", " + rectangulo1.y4 +   ")");
        System.out.println("Rectangulo 2: (" + rectangulo2.x1 + ", " + rectangulo2.y1 + ", " +rectangulo2.x2 + ", " + rectangulo2.y2 + ", " + rectangulo2.x3 + ", " + rectangulo2.y3 + ", " + rectangulo2.x4 + ", " + rectangulo2.y4 +   ")");
    }
}