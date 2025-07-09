import java.util.Scanner;

public class ClienteEnums {
    //QUEREMOS CONSTRUIR CLIENTE QUE SOLO TENGA PARAMETROS PARA CONSTRUIR HOMBRE MUJER O ELLE
    enum Genero{HOMBRE, MUJER, ELLE}
    String nombre;
    String DNI;
    Genero genero;

    //cREAMOS CONSTRUCTOR

    ClienteEnums(String nombre, String DNI, String sexo){
        this.nombre=nombre;
        this.DNI=DNI;
        this.genero=Genero.valueOf(sexo.toUpperCase());
    }


    //Caso 2 definirlo directamente como genero

    ClienteEnums(String nombre, String DNI, Genero genero){
        this.nombre=nombre;
        this.DNI=DNI;
        this.genero=genero;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduce el genero(HOMBRE/MUJER/ELLE)");
        String sexoCliente= sc.next().toUpperCase();

        //Lo pasamos como String al constructor

        ClienteEnums c1= new ClienteEnums("Joan", "202087028", sexoCliente);


        System.out.println("Nombre"+c1.nombre+"DNI"+c1.DNI+c1.genero);

        //Antes de pasarlo

        ClienteEnums c2= new ClienteEnums("Pedro", "7698659878", Genero.valueOf(sexoCliente));

        System.out.println("Nombre"+c2.nombre+"DNI"+c2.DNI+c2.genero);

        sc.close();
    }










}
