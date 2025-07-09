import java.util.Scanner;

public class AppDoctores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Creacion de doctores");
//Vamos a usar el constriuctor por defecto
Doctor doctor1= new Doctor();
doctor1.setNombre("Pedro");
System.out.println(doctor1); //Muestra la posicion de memoria
System.out.println(doctor1.calcularNomina(1500, 2));

//Construimos un doctor con parametros
Doctor doctor2 = new Doctor("Laura", 40, "Femenino");
doctor2.setEdad(80);
//Calcular nomina del doctor2
    int nochesguardia= sc.nextInt();
    double nomina2= doctor2.calcularNomina(1500, nochesguardia);
    Doctor doctor3 = new Doctor("Carlos", 50, "Masculino");
    doctor3.setEdad(45);

    System.out.println("Uso de metodos staticos");
    Doctor.mostrarIDGlobal();
    Doctor doctores []= {doctor1, doctor2, doctor3};
    for (Doctor doctor : doctores) { //Con un fori o foreach
        doctor.mostrarDatos();
        
    }
    

    System.out.println("doble for");
    for (int i = 0; i < doctores.length; i++) {
        System.out.println("doctor "+(i+1)+": ");
        doctores[i].mostrarDatos();
        
    }
    }
}
