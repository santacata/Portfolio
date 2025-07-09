package Articulo;


public class Articulo {
    public String nombre; // Atributos de la clase
    public final double IVA = 0.21;
    public double precio;
    public double total;
    public int cuantosQuedan;

    public void inicializarStock(int cantidad) { // Método de la clase
        cuantosQuedan = cantidad;
    }
    public Articulo() { // Constructor por defecto
        nombre="Pijama";
        precio=10;
        total=precio+(precio*IVA);
    }
    public void mostrarDatos(){
        System.out.println("El nombre es: "+nombre+" euros");
        System.out.println("El precio es: "+precio+" euros");
        System.out.println("El total es: "+total+" euros");
    }
}
