package Persona;

public class Persona { //variables de la classe
    
    private String dni="1235465w";
    private String nom="pepe";
    private String apellidos="sarmiento";
    private int edad=32;

    public Persona() { //VALORS SI NO LI CLAVES RES
    dni="2457651j";
    nom="Anon";
    apellidos="Anon";
    edad=0;
    }

    public void imprime() {
        System.out.println("DNI: "+dni);
        System.out.println("Nom: "+nom);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("Edad: "+edad);
    }

    public boolean esMayorEdad() {
        if (edad>=18) {
            return true;
        } else {
            return false;
        }
    }
    public boolean esJubilado() {
        if (edad>=68) {
            return true;
        } else {
            return false;
        }
    }

    public int diferenciaEdad(Persona p) {
        return edad-p.edad;
    }


    public String getterDNI(){
        return dni;
    }
    public void setterDNI(String nouValor){
        dni=nouValor;
    }
    public String getterNom(){
        return nom;
    }
    public void setterNom(String nouValor){
        nom=nouValor;
    }
    public String getterApellidos(){
        return apellidos;
    }
    public void setterApellidos(String nouValor){
        apellidos=nouValor;
    }
    public int getterEdad(){
        return edad;
    }
    public void setterEdad(int nouValor){
        edad=nouValor;
    }
    

    public Persona(String dni, String nom, String apellidos, int edad) {
        this.dni = dni;
        this.nom = nom;
        this.apellidos = apellidos;
        this.edad = edad;
        }
}