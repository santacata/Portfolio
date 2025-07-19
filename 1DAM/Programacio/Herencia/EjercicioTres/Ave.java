import java.time. LocalDate;

abstract class Ave extends Mascota {
    protected String tipoPico;
    protected boolean vuela;

    public Ave(String nombre, int edad, String estado, LocalDate fechaNacimiento, 
               String tipoPico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento);
        this.tipoPico = tipoPico;
        this.vuela = vuela;
    }

    public void volar() {
        System.out.println(nombre + (vuela ? " está volando." : " no puede volar."));
    }
}
