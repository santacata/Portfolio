import java.time.LocalDate;

class Gato extends Mascota {
    private String color;
    private boolean peloLargo;

    public Gato(String nombre, int edad, String estado, LocalDate fechaNacimiento, 
                String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public void muestra() {
        System.out.println("Gato: " + nombre + ", Color: " + color + 
                          ", Pelo largo: " + (peloLargo ? "Sí" : "No"));
    }

    @Override
    public void habla() {
        System.out.println(nombre + " dice: ¡Miau!");
    }
}