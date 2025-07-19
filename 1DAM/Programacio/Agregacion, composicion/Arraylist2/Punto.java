public class Punto {
    private int x;
    private int y;
    public String nombre; //Identificar el punto

    //Constructores
        public Punto(int x) {
        this.x = x;
        this.y = x;
    }
    public Punto(int x, String nombre) {
        this.x = x;
        this.y = x;
        this.nombre= nombre;
    }
    public Punto(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre= nombre;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override //Sobreescriu un metode Existent
    //Predefinido ArrayList
    public String toString(){
        return "Punto [x="+x+" y "+y + nombre+"]";
    }
    public String toStringNombre(){
        return "Punto [nombre="+ nombre+"]";
    }
    public void mostrarDatos(){
        if (this.nombre== null) {
            System.out.println("El punto no tiene nombre, sus datos son");
        }else{
            System.out.println("El punto de nombre"+nombre+" tiene los siguienmtes datos");
        }
        System.out.println("X="+x);
        System.out.println("Y="+y);
        System.out.println("La distancia al centro es "+calcularDistanciaCentro());
    }
    public double calcularDistanciaCentro(){
        double z;
        z=Math.sqrt((x*x)+(y*y));
        return z;
    }
    
}
