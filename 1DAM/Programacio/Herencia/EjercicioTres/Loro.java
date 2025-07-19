import java.time.LocalDate;

class Loro extends Ave {
    private String origen;

    public Loro(String nombre, int edad, String estado, LocalDate fechaNacimiento, 
                String tipoPico, boolean vuela, String origen) {
        super(nombre, edad, estado, fechaNacimiento, tipoPico, vuela);
        this.origen = origen;
    }

    @Override
    public void muestra() {
        System.out.println("Loro: " + nombre + ", Origen: " + origen + 
                          ", Tipo de pico: " + tipoPico);
    }

    @Override
    public void habla() {
        System.out.println(nombre + " dice: ¡Hola! ¡Soy un loro!");
    }

    public void saluda() {
        System.out.println(nombre + " saluda: ¡Buenos días!");
    }
}