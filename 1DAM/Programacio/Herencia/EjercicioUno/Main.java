import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Gel De Baño"));
        productos.add(new Producto("Revista"));
        productos.add(new Producto("Clinex"));
        productos.add(new Producto("PapelWC"));
        productos.add(new Producto("Video"));

        // Obtener un Iterator de la lista
        Iterator<Producto> iterador = productos.iterator();

        // Recorrer la lista usando Iterator
        System.out.println("--------------------------------");
        while (iterador.hasNext()) {
            Producto p = iterador.next();
            System.out.println("Producto: "+p);
        }
        //Eliminar productos de la lista
        productos.remove(1);
        productos.remove(2); //Que sería el cuarto si antes no hubieramos borrado el index 1 (pero es el tercero)
        // 6. Insertar un nuevo producto en el medio
         Producto nuevoProducto = new Producto("Muñeca Hinchable");
         productos.add(1, nuevoProducto); //Ponemos uno porque es el de enmedio, puede ser de 0 a 3
         for (Producto producto : productos) {
            ArrayList<String>noms=new ArrayList<>();
            noms.add(producto.nombre);
         }
         
 
        // 7. Visualizar el contenido con Iterator nuevamente
        System.out.println("--------------------------------");
         System.out.println("Lista actual:");
         iterador = productos.iterator();
         while (iterador.hasNext()) {
             System.out.println("Producto: "+iterador.next());
         }
 
        // 8. Eliminar todos los valores del ArrayList
         productos.clear();
         System.out.println("--------------------------------");
         System.out.println("Lista después de borrar todo: "+productos); //No hay nada
         
    }
}