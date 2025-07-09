import personal.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Personal empresaPersonal = new Personal();
        Maquinaria empresaMaquinaria = new Maquinaria();

        // Agregar personal
        Maquinista m1 = new Maquinista("Carlos Pérez", "12345678A", 2500.0, "Senior");
        Maquinista m2 = new Maquinista("Laura García", "87654321B", 2200.0, "Junior");

        Mecánico mec1 = new Mecánico("Roberto López", "678901234", "Electricidad");
        Mecánico mec2 = new Mecánico("Ana Martín", "654321098", "Hidráulica");

        JefeEstacion jefe1 = new JefeEstacion("Pedro Sánchez", "11223344C", LocalDate.of(2020, 5, 10));

        empresaPersonal.agregarMaquinista(m1);
        empresaPersonal.agregarMaquinista(m2);
        empresaPersonal.agregarMecanico(mec1);
        empresaPersonal.agregarMecanico(mec2);
        empresaPersonal.agregarJefeEstacion(jefe1);

        // Agregar maquinaria
        Locomotora loc1 = new Locomotora("ABC123", 4000, 2015, mec1);
        Locomotora loc2 = new Locomotora("XYZ789", 3500, 2018, mec2);

        Tren tren1 = new Tren(loc1, m1);
        Tren tren2 = new Tren(loc2, m2);

        empresaMaquinaria.agregarLocomotora(loc1);
        empresaMaquinaria.agregarLocomotora(loc2);
        empresaMaquinaria.agregarTren(tren1);
        empresaMaquinaria.agregarTren(tren2);

        // Mostrar información
        empresaPersonal.mostrarPersonal();
        System.out.println("\n-----------------------------------\n");
        empresaMaquinaria.mostrarMaquinaria();
    }
}