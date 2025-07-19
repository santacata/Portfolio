package Rectangulo;

public class ExerciciA3 {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(); // Accedeix al constructor per defecte
        Rectangulo rectangulo2 = new Rectangulo(10, 10, 21, 23, 45, 65, 47, 78); // Accedir al constructor amb datos

        System.out.println("Rectangulo 1: (" + rectangulo1.getX1() + ", " + rectangulo1.getY1() + ", " + rectangulo1.getX2() + ", " + rectangulo1.getY2() + ", " + rectangulo1.getX3() + ", " + rectangulo1.getY3() + ", " + rectangulo1.getX4() + ", " + rectangulo1.getY4() + ")");
        System.out.println("Rectangulo 2: (" + rectangulo2.getX1() + ", " + rectangulo2.getY1() + ", " + rectangulo2.getX2() + ", " + rectangulo2.getY2() + ", " + rectangulo2.getX3() + ", " + rectangulo2.getY3() + ", " + rectangulo2.getX4() + ", " + rectangulo2.getY4() + ")");

        rectangulo1.setX1(rectangulo1.getX1() + 3);
        rectangulo1.setY1(rectangulo1.getY1() - 1);
        rectangulo1.setX2(rectangulo1.getX2() * 2);
        rectangulo1.setY2(rectangulo1.getY2() / 2);
        rectangulo1.setX3(rectangulo1.getX3() - 5);
        rectangulo1.setY3(rectangulo1.getY3() + 3);
        rectangulo1.setY4(rectangulo1.getY4() * 2);
        rectangulo1.setX4(rectangulo1.getX4() - 5);

        rectangulo2.setX1(rectangulo2.getX1() + 3);
        rectangulo2.setY1(rectangulo2.getY1() - 1);
        rectangulo2.setX2(rectangulo2.getX2() * 2);
        rectangulo2.setY2(rectangulo2.getY2() / 2);
        rectangulo2.setX3(rectangulo2.getX3() - 5);
        rectangulo2.setY3(rectangulo2.getY3() + 3);
        rectangulo2.setY4(rectangulo2.getY4() + 12);
        rectangulo2.setX4(rectangulo2.getX4() - 5);

        System.out.println();
        System.out.println("Coordenades modificades:");
        System.out.println("Rectangulo 1: (" + rectangulo1.getX1() + ", " + rectangulo1.getY1() + ", " + rectangulo1.getX2() + ", " + rectangulo1.getY2() + ", " + rectangulo1.getX3() + ", " + rectangulo1.getY3() + ", " + rectangulo1.getX4() + ", " + rectangulo1.getY4() + ")");
        System.out.println("Rectangulo 2: (" + rectangulo2.getX1() + ", " + rectangulo2.getY1() + ", " + rectangulo2.getX2() + ", " + rectangulo2.getY2() + ", " + rectangulo2.getX3() + ", " + rectangulo2.getY3() + ", " + rectangulo2.getX4() + ", " + rectangulo2.getY4() + ")");
    }
}