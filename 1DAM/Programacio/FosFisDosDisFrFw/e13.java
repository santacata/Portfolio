import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;

public class e13 {
    public static void main(String[] args) {
        
        System.out.println("Escribe un programa que lea de un fichero binario una tabla de números double y después muestre el contenido de la tabla por consola.");
        try (DataInputStream dis= new DataInputStream(new FileInputStream("arxiu.bin"))) {
            try {
                while (true) {
                    System.out.println(dis.readDouble());
                }        
            } catch (EOFException e) {
                System.out.println("Se ha acabado el archivo");
            }
            
        } catch (Exception e) {
            System.out.println("Ha explotado");
            e.printStackTrace();
        }
    }
}
