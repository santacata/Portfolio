package Persona;

public class Persona { //variables de la classe
    
    public String dni;
    public String nom;
    public String apellidos;
    public int edad;

    public Persona() { //VALORS PER DEFECTE
    dni="2457651j";
    nom="Anon";
    apellidos="Anon";
    edad=0;
    }
    

    public Persona(String dni, String nom, String apellidos, int edad) {
        this.dni = dni;
        this.nom = nom;
        this.apellidos = apellidos;
        this.edad = edad;
        }
}