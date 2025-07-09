import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        
        Perro perro1 = new Perro("Rex", 3, "Vivo", LocalDate.of(2020, 5, 15), 
                               "Labrador", false);
        Gato gato1 = new Gato("Misi", 2, "Vivo", LocalDate.of(2021, 8, 10), 
                             "Negro", true);
        Loro loro1 = new Loro("Paco", 5, "Vivo", LocalDate.of(2018, 3, 20), 
                             "Curvo", true, "Amazonas");
        Canario canario1 = new Canario("Piolín", 1, "Vivo", LocalDate.of(2022, 2, 5), 
                                      "Pequeño", true, "Amarillo", true);
        
        inventario.agregarAnimal(perro1);
        inventario.agregarAnimal(gato1);
        inventario.agregarAnimal(loro1);
        inventario.agregarAnimal(canario1);
        
        System.out.println("Lista de animales:");
        inventario.mostrarListaAnimales();
        
        System.out.println("\nDatos de un animal concreto:");
        inventario.mostrarDatosAnimal(loro1);
        
        System.out.println("\nTodos los datos de todos los animales:");
        inventario.mostrarTodosDatos();
    }
}
