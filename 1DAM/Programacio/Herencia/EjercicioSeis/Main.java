import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        // Vehículos genéricos
        VehiculoTerrestre vt = new VehiculoTerrestre("1234ABC", "Genérico", 4) {};
        VehiculoAcuatico va = new VehiculoAcuatico("ABCDE", "Genérico", 10.5) {};
        VehiculoAereo vae = new VehiculoAereo("ABCD123456", "Genérico", 2) {};
        
        // Vehículos específicos
        Coche coche = new Coche("5678DEF", "Toyota", 4, true);
        Moto moto = new Moto("9012GHI", "Honda", 2, "Rojo");
        Barco barco = new Barco("FGHIJ", "Yate", 15.0, true);
        Submarino submarino = new Submarino("KLMNO", "Militar", 50.0, 300.0);
        Avion avion = new Avion("EFGH456789", "Boeing", 150, 12.5);
        Helicoptero helicoptero = new Helicoptero("IJKL987654", "Heli", 6, 2);
        
        vehiculos.add(vt);
        vehiculos.add(va);
        vehiculos.add(vae);
        vehiculos.add(coche);
        vehiculos.add(moto);
        vehiculos.add(barco);
        vehiculos.add(submarino);
        vehiculos.add(avion);
        vehiculos.add(helicoptero);
        
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("--------------------------------");
            vehiculo.imprimir();
            System.out.println("--------------------------------");
        }
    }
}