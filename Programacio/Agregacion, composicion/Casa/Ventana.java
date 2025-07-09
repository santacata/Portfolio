public class Ventana{

    private String nombre; // nombre ventana // salon comedor...

    private int ancho, alto;

    public Ventana(String nombre, int ancho, int alto) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.alto = alto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    

    public void mostrarInformacion(){
        System.out.println(nombre + " " + ancho + " x " + alto);
        
    }
}