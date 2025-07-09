import java.time.LocalDateTime;
import java.time.LocalDate;

public class Texto {
    public LocalDateTime creacion; //Para agregar la fecha en la que se creó
    public LocalDateTime modificacion;
    private int vocales=0;
    private int longitudMAX=15;
    private String texto;

    

    public Texto(String texto, int longitudMAX){
        this.longitudMAX=longitudMAX;
        this.texto=texto;
        if (this.texto.length()>longitudMAX) {
            System.out.println("La cadena es demasiado larga");
        }else{
            
        }
    }
    public void addFinal(char c){
if ((texto.length()+1)>longitudMAX) {
    System.out.println("El caracter no se puede añadir");
}else{
    System.out.println("La cadena resultante es: "+texto+Character.toString(c));
}
    }
    public void addFinal(String c){

    }
    
}
