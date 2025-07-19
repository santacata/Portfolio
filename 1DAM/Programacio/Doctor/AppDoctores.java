import java.util.Scanner;

public class AppDoctores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Creación de doctores ===");
        Doctor doctor1 = new Doctor();
        doctor1.setNombre("Pedro");

        System.out.println("Doctor " + doctor1.getNombre());
        System.out.println("Nómina: " + doctor1.calcularNomina(1500, 2) + " €");

        Doctor doctor2 = new Doctor("Laura", 40, "Femenino");
        doctor2.setEdad(80);

        System.out.print("Introduce el número de noches de guardia para Laura: ");
        int nochesguardia = sc.nextInt();
        double nomina2 = doctor2.calcularNomina(1500, nochesguardia);
        System.out.println("Nómina de Laura: " + nomina2);

        Doctor doctor3 = new Doctor("Carlos", 50, "Masculino");
        doctor3.setEdad(45);

        Doctor[] doctores = {doctor1, doctor2, doctor3};

        System.out.println("\n=== Uso de métodos estáticos ===");
        Doctor.mostrarIDGlobal();

        System.out.println("\n=== Mostrar doctores con for-each ===");
        for (Doctor doctor : doctores) {
            doctor.mostrarDatos();
        }

        System.out.println("\n=== Mostrar doctores con for clásico ===");
        for (int i = 0; i < doctores.length; i++) {
            System.out.println("Doctor " + (i + 1) + ":");
            doctores[i].mostrarDatos();
        }

        sc.close();
    }
}
