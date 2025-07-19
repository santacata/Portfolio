package Rectangulo;

public class Rectangulo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x4;
    private int y4;

    public int getX1() {
        return x1;
    }

    public void setX1(int coordX1) {
        x1 = coordX1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int coordY1) {
        y1 = coordY1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int coordX2) {
        x2 = coordX2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int coordY2) {
        y2 = coordY2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int coordX3) {
        x3 = coordX3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int coordY3) {
        y3 = coordY3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int coordX4) {
        x4 = coordX4;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int coordY4) {
        y4 = coordY4;
    }

    public Rectangulo() {
        x1 = 0;
        y1 = 0;
        x2 = 1;
        y2 = 1;
        x3 = 2;
        y3 = 2;
        x4 = 2;
        y4 = 2;
    }

    public Rectangulo(int coordX1, int coordY1, int coordX2, int coordY2, int coordX3, int coordY3, int coordX4, int coordY4) {
        verificarCoordenadasX1(coordX1);
        verificarCoordenadasY1(coordY1);
        verificarCoordenadasX2(coordX2);
        verificarCoordenadasY2(coordY2);
        verificarCoordenadasX3(coordX3);
        verificarCoordenadasY3(coordY3);
        verificarCoordenadasX4(coordX4);
        verificarCoordenadasY4(coordY4);
    }

    private void verificarCoordenadasX1(int x1) {
        if (x1 == x2) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.x1 = x1;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasY1(int y1) {
        if (y1 == y2) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.y1 = y1;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasX2(int x2) {
        if (x1 == x2) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.x2 = x2;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasY2(int y2) {
        if (y1 == y2) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.y2 = y2;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasX3(int x3) {
        if (x3 == x4) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.x3 = x3;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasY3(int y3) {
        if (y3 == y4) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.y3 = y3;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasX4(int x4) {
        if (x3 == x4) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.x4 = x4;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }

    private void verificarCoordenadasY4(int y4) {
        if (y3 == y4) {
            System.out.println("ERROR al instanciar...");
        } else {
            this.y4 = y4;
            System.out.println("Rectangulo instanciado correctamente...");
        }
    }
}