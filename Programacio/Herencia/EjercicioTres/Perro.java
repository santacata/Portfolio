import java.time.LocalDate;

class Perro extends Mascota {
    private String raza;
    private boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fechaNacimiento, 
                String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    @Override
    public void muestra() {
        System.out.println("Perro: " + nombre + ", Raza: " + raza + 
                          ", Pulgas: " + (pulgas ? "Sí" : "No"));
    }

    @Override
    public void habla() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
}