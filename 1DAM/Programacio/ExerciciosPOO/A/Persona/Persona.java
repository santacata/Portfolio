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
    

public Persona(String id, String nm, String ap, int ed) { //VALORS SI EN PASSEN ALGO DE INFORMACIO
    dni = id;
    nom = nm;
    apellidos = ap;
    edad = ed;
    }
}