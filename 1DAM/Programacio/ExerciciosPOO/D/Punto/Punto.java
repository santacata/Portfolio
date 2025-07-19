package Punto;
import java.util.random;

public class Punto {
    Random rnd=new Random();

    private int x; // Atributos de la clase
    private int y;

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

    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void imprime(){
        System.out.println("x = " + x + " y = " + y);
    }

    public void desplaza(int dx, int dy){ //dESPLAZAMOS ESTA CANTIDAD
        x += dx;
        y += dy;
    }

    public int distancia(Punto p){
        int dx = x - p.x;
        int dy = y - p.y;
        return (int) Math.sqrt(dx*dx + dy*dy); //Entenc el procediment, però no sé per què fa una arrel quadrada
    }

    public Punto() { //Si no li passem valors
        x = rnd.nextInt(-100, 100);
        y = rnd.nextInt(-100, 100);
    }

    public Punto(int x, int y) // Constructor por defecto
    {    
    this.x = x;
    this.y = y;
    }
}
