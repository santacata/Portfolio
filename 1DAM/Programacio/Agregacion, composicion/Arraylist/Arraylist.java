import java.util.*;
public class Arraylist {

    public static void main(String[] args) {
        ArrayList<String> lista=new ArrayList<>();

        //añadir elementos

        lista.add("Manzana");
        lista.add("Cereza");

        System.out.println("Lista"+lista);

        //Modificar u obtener un elemento por su indice

        String fruta=lista.get(1);
        System.out.println("Elemento 2: "+fruta);

        //Modificar archivo por su pos
        lista.set(1, "pera");

        //El remove se haria igual (aunque yo prefiero usar removeif que no da error)
        lista.remove(1);

        //Comprobar si contiene un elemento llamado como queramos
        boolean contiene=lista.contains("pera");

        //Obtener tamaño
        int tamano= lista.size();

        //Recorrer lista usando for y size

        for (int index = 0; index < lista.size(); index++) {
            System.out.println("Indice: "+index+" fruta: "+lista.get(index));
            
        }

        //Recorrer con un foreach
        for (String elemento : lista) {
            System.out.println(elemento);
            
        }

         //Limpiar la lista
         lista.clear();

         //Convertir la lista en un array
         
         Object[]array=lista.toArray();
    }
   
    

}