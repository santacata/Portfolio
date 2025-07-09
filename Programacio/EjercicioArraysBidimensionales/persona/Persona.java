package persona;
public class Persona {

String nombre; //Atributos
int edad;
String ciudadDeResidencia;
String profesioString;
String dni;

//Para crear una instancia necesito un contstructor y siempre ha de ser un public+nombreDeLaClase
public Persona(String nom, int edat, String dn){

}
public Persona(){
    nombre="Joan";
    edad=20;
    ciudadDeResidencia="Sin ciudad";
    profesioString="sin profesion";
    dni="Sin dni";
}
public Persona(String s){
    nombre=s;//Asigna al valor del elemento s
    edad=20;
    ciudadDeResidencia="Sin ciudad";
    profesioString="sin profesion";
    dni="Sin dni";
}
//Metodos de la clase (COMPORTAMIENTO DE LA CLASE)(funciones/metodos)
public String getNom(){
    return nombre;
}
int getEdad(){
    return edad;
}
void setEdad(int e){
    edad=e;
}
public void establecerEdad(int e){
    if (e < 0){
        System.out.println("La edad no puede ser negativa");
    }else{
        edad=e;
    }
}
boolean esMayorEdad(){
    return edad>=18;
}
public void mostrarDatos(){
    System.out.println("nombre"+nombre);
    System.out.println("dni"+dni);
    System.out.println("edad"+edad);
    System.out.println("ciudad"+ciudadDeResidencia);
    System.out.println("profesion;"+profesioString);

}

}