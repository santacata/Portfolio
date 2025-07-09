package Rectangulo;

import java.util.Random;

public class Rectangulo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x4;
    private int y4;
    private static final int MIN = 0;
    private static final int MAX = 10;

    public int getX1() {
        return x1;
    }

    public void setX1(int coordX1) {
        if (esCoordenadaValida(coordX1)) {
            x1 = coordX1;
        } else {
            System.out.println("Error: Coordenada X1 fuera de rango.");
        }
    }
    public int getY1() {
        return y1;
    }

    public void setY1(int coordY1) {
        if (esCoordenadaValida(coordY1)) {
            y1 = coordY1;
        } else {
            System.out.println("Error: Coordenada Y1 fuera de rango.");
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int coordX2) {
        if (esCoordenadaValida(coordX2)) {
            x2 = coordX2;
        } else {
            System.out.println("Error: Coordenada X2 fuera de rango.");
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int coordY2) {
        if (esCoordenadaValida(coordY2)) {
            y2 = coordY2;
        } else {
            System.out.println("Error: Coordenada Y2 fuera de rango.");
        }
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int coordX3) {
        if (esCoordenadaValida(coordX3)) {
            x3 = coordX3;
        } else {
            System.out.println("Error: Coordenada X3 fuera de rango.");
        }
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int coordY3) {
        if (esCoordenadaValida(coordY3)) {
            y3 = coordY3;
        } else {
            System.out.println("Error: Coordenada Y3 fuera de rango.");
        }
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int coordX4) {
        if (esCoordenadaValida(coordX4)) {
            x4 = coordX4;
        } else {
            System.out.println("Error: Coordenada X4 fuera de rango.");
        }
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int coordY4) {
        if (esCoordenadaValida(coordY4)) {
            y4 = coordY4;
        } else {
            System.out.println("Error: Coordenada Y4 fuera de rango.");
        }
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

    public void imprime() {
        System.out.println("Coordenadas del rectangulo: ");
        System.out.println("Punto 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Punto 2: (" + x2 + ", " + y2 + ")");
        System.out.println("Punto 3: (" + x3 + ", " + y3 + ")");
        System.out.println("Punto 4: (" + x4 + ", " + y4 + ")");
    }

    public void setXY1(int x, int y){
        x1 = x;
        y1 = y;
    }
    public void setXY2(int x, int y){
        x2 = x;
        y2 = y;
    }
    public void setXY3(int x, int y){
        x3 = x;
        y3 = y;
    }
    public void setXY4(int x, int y){
        x4 = x;
        y4 = y;
    }
    
    public void getPerimetro(Rectangulo rectangulo){
        int perimetro = 0;
        perimetro = (rectangulo.x2 - rectangulo.x1) + (rectangulo.y2 - rectangulo.y1)+ (rectangulo.y3 - rectangulo.y2)+ (rectangulo.x3 - rectangulo.x2); //Suma de los lados
        System.out.println("El perimetro del rectangulo es: " + perimetro);
    }
    public void getArea(Rectangulo rectangulo){
        int area = 0;
        area = (rectangulo.x2 - rectangulo.x1) * (rectangulo.y3 - rectangulo.y2); //Base por altura
        System.out.println("El area del rectangulo es: " + area); 
    }

        public static Rectangulo crearRectanguloAleatorio() {
        Random rnd = new Random();
        int x1 = rnd.nextInt(MIN, MAX);
        int y1 = rnd.nextInt(MIN, MAX);
        int x2 = rnd.nextInt(MIN, MAX);
        int y2 = rnd.nextInt(MIN, MAX);
        int x3 = rnd.nextInt(MIN, MAX);
        int y3 = rnd.nextInt(MIN, MAX);
        int x4 = rnd.nextInt(MIN, MAX);
        int y4 = rnd.nextInt(MIN, MAX);

        return new Rectangulo(x1, y1, x2, y2, x3, y3, x4, y4);
    }
}