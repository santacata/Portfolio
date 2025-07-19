public class Habitacion {
    private String tipo;

    public Habitacion(String tipo){
        this.tipo = tipo;
    }

    public void mostrarInfo(){
        System.out.println("Habitación " + tipo);
    }
}
