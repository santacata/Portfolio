public class App {
    

    public static void main(String[] args) {
        
        Casa c = new Casa("C/Java", 3);

        c.mostrarInformacion();

        c = null;

        Casa c2 = new Casa("C/Otra casa", 2);
        Ventana[] v = new Ventana[3];


        v[0] = new Ventana("Ventana Salon", 120, 120);
        v[1] = new Ventana("Ventana Salon", 120, 120);
        v[2] = new Ventana("Ventana Salon", 120, 120);
    
    }

}
