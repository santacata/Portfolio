import java.time.LocalDate;

class Canario extends Ave {
    private String color;
    private boolean canta;

    public Canario(String nombre, int edad, String estado, LocalDate fechaNacimiento, 
                   String tipoPico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, tipoPico, vuela);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public void muestra() {
        System.out.println("Canario: " + nombre + ", Color: " + color + 
                          ", Canta: " + (canta ? "Sí" : "No"));
    }

    @Override
    public void habla() {
        System.out.println(nombre + " dice: ¡Pío pío!");
    }
}
