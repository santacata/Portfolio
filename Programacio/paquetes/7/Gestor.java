import java.util.Scanner;

public class Gestor {
    private static int numeroGestor=1; //Necessitem que siga Static per a que ho aplique al document i cada objecte no tinga el numero
    public String nombre;
    private int telefono;
    int maximoOperacion=1000; //Es default, visible solo por clases vecinas, por default 1000
    public void setMaximoOperacion(int valor){
        maximoOperacion=valor;
    }
    public int getMaximoOperacion(){
        return maximoOperacion;
    }
    public Gestor(String nom, int telefon, Scanner sc){
        numeroGestor++;
        nombre=nom;
        telefono= telefon;
        System.out.println("Quieres el maximo de 1000? Y/N");
        String entrada=sc.nextLine();
        if (entrada.equalsIgnoreCase("Y")) {
            System.out.println("Dime la cantidad maxima");
            int cantidadMaxima = sc.nextInt();
            maximoOperacion=cantidadMaxima;
        } else{
            System.out.println("Lo has introducido mal");
        }
    

        
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return telefono;
    }



}
