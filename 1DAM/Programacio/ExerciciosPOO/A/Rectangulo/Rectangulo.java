package Rectangulo;


public class Rectangulo {
    public int x1; // Atributos de la clase
    public int y1;
    public int x2;
    public int y2;
    public int x3;
    public int y3;
    public int x4;
    public int y4;

    public Rectangulo() { // Constructor por defecto
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        x3 = 0;
        y3 = 0;
        x4 = 0;
        y4 = 0;
    }
    public Rectangulo(int coordX1, int coordY1,int coordX2, int coordY2,int coordX3, int coordY3,int coordX4, int coordY4) { // Constructor con parametros
        x1 = coordX1;
        y1 = coordY1;
        x2 = coordX2;
        y2 = coordY2;
        x3 = coordX3;
        y3 = coordY3;
        x4 = coordX4;
        y4 = coordY4;
    }
}
