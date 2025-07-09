public class Jugador{

    private String nombre;
    private Equipo equipo; //RELACION de agregación
    //El jugador puede tener un equipo
    //Unico atributo ya que 1 jugador solo pertenece a un equipo
public Jugador(String nombre) {
    this.nombre = nombre;
    this.equipo = null; // 1 jugador no pertenece a ningun equipo al crearse
}

    public void SetEquipo(Equipo equipo){
    this.equipo = equipo;
    //Luego añadiremos al equipo
}

    public String getNombre(){
        return nombre;
    }

    public void mostrarInformacion(){
        System.out.println("Jugador: " + nombre);

        if (equipo != null) {
            System.out.println("Equipo : " + equipo.getNombre());
        } else{
            System.out.println("Sin equipo");
        }
    }


    public void asignarEquipo(Equipo equipo){
        this.equipo = equipo;
    }

}
