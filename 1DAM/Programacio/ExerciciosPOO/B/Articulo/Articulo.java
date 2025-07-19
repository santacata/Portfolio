package Articulo;

public class Articulo {
    public String nombre; // Atributos de la clase
    public final double IVA = 0.21;
    public double precio;
    public double total;
    public static int cuantosQuedan = 1000; // Variable static compartida en este documento

    public void declararStock(int cantidad) { // Método de la clase
        cuantosQuedan = cantidad;
    }

    public Articulo() { // Constructor por defecto
        nombre = "Articulo";
        precio = 10;
        total = precio + (precio * IVA);
        cuantosQuedan--;
    }
    public void verificacion() {
        if (nombre == null) {
            System.out.println("El nombre no puede ser nulo");
        }
        if (precio<0) {
            System.out.println("El precio no puede ser negativo");
            
        }
        if (cuantosQuedan <= 0) {
            System.out.println("No quedan articulos");
        } else {
            System.out.println("Quedan " + cuantosQuedan + " articulos");
        }
    }
    public void mostrarDatos() {
        System.out.println("El nombre es: " + nombre );
        System.out.println("El precio es: " + precio + " euros");
        System.out.println("El total es: " + total + " euros");
        System.out.println("Quedan " + cuantosQuedan + " articulos");
    }

    public Articulo(String nombre, double precio) { // Constructor con parámetros & Solo puedo editar estos porque el IVA es final, el total lo calcula y cuantosQuedan no me interesa cambiarlo
        this.nombre = nombre;
        this.precio = precio;
        total = precio + (precio * IVA);
        cuantosQuedan--; // Decrementa la variable static
    }
}
