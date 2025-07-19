public class App {
    

    public static void main(String[] args) {
        
        Casa c = new Casa("C/Java", 3); //aqui le pasamos las habitaciones que queremos que tenga la casa

        c.mostrarInformacion();

        
        Casa c2 = new Casa("C/Otra casa", 2); //Hacemos otra casa

        Ventana[] v = new Ventana[3]; //Creamos un array de tipo ventana

        v[0] = new Ventana("Ventana Salon", 120, 120);
        v[1] = new Ventana("Ventana Salon", 120, 120);
        v[2] = new Ventana("Ventana Salon", 120, 120);

        c2.setVentanas(v); //Le asignamos las ventanas a la casa

        c2.mostrarInformacion(); //Mostramos la informacion de la casa
    
    }

}
