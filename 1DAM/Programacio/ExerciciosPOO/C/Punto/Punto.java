package Punto;

public class Punto {
    private int x=12; // Atributos de la clase
    private int y=32;

    public int getterX(){
        return x;
    }

    public void setterX(int x){
        this.x=x;
    }

    public int getterY(){
        return y;
    }
    public void setterY(int y){
        this.y=y;
    }



    public Punto() { //Si no li passem valors
        x = 0;
        y = 0;
    }

    public Punto(int x, int y) // Constructor por defecto
    {    
    this.x = x;
    this.y = y;
    }
}
