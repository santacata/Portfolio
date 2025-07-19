//Asociacion de Composicion
//Clase CPU parte interna de un ordenador. NO puede existir SOLA

class CPU{
    private String modelo;
    private int nucleos;

    public CPU(String modelo, int nucleos){
        this.modelo = modelo;
        this.nucleos = nucleos;
    }
    @Override
    public String toString() {
        return " CPU: " + modelo + ", Nucleos: " + nucleos;
    }
} // Fin CPU

class Ordenador{
    private String marca;
    private CPU cpu; // Relacion de composicion

    public Ordenador(String marca, String modeloCPU, int nucleos){
        this.marca = marca;
        this.cpu = new CPU(modeloCPU, nucleos);
        //Se crea la CPU dentro del constructor
    }


    public void mostrarINFO(){
        System.out.println("Ordenador "  + marca + cpu.toString());
    }
} // fin ordenador



public class Subclases{
    public static void main(String[] args) {
        Ordenador pc1 = new Ordenador("Lenovo", "Intel I7", 8);
        Ordenador pc2 = new Ordenador("Asus", "AMD Ryzen 5", 6);

        pc1.mostrarINFO();
        pc2.mostrarINFO();
    }
}