package Articulo;

public class Articulo {
    private String nombre; // Atributos de la clase
    private final double IVA = 0.21;
    private double precio;
    private double total;
    private static int cuantosQuedan = 1000; // Variable static compartida en este documento

    public void declararStock(int cantidad) { // Método de la clase
        cuantosQuedan = cantidad;
    }
    public getIVA() {
        return IVA;
    }
    public getnombre() {
        return nombre;
    }
    public getprecio() {
        return precio;
    }
    public getcuantosQuedan() {
        return cuantosQuedan;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public void setprecio(double precio) {
        this.precio = precio;
    }
    

    public Articulo() { // Constructor por defecto
        nombre = "Articulo";
        precio = 10;
        total = precio + (precio * IVA);
        cuantosQuedan--;
    }
    private void verificacion(String cadena) {
        if (cadena == null) {
            System.out.println("El nombre no puede ser nulo");
        }
        if (parseInt(cadena)<=0) {
            System.out.println("No puede ser negativo");
            
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

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Total: " + total);
        System.out.println("Quedan: " + cuantosQuedan);
    }

    public getPVP() {
        return total;
    }

    public getPVPDescuento(double descuento) {
        return total - (total * descuento);
    }

    public vender(int cantidad) {
        if (cuantosQuedan >= cantidad) {
            cuantosQuedan -= cantidad;
            System.out.println("Se han vendido " + cantidad + " unidades");
        } else {
            System.out.println("No hay suficientes unidades");
        }
    }

    public almacenar(int cantidad) {
        cuantosQuedan += cantidad;
        System.out.println("Se han almacenado " + cantidad + " unidades");
        System.out.println("Hay " + cuantosQuedan + " unidades");
    }
}
