import java.io.DataInputStream;
import java.io.FileInputStream;

public class e12 {
    public static void main(String[] args) {
        try {
            System.out.println("Leemos el numero double del fichero arxiu.bin");
            DataInputStream dis= new DataInputStream(new FileInputStream("arxiu.bin"));
            System.out.println(dis.readDouble());
            dis.close();
        } catch (Exception e) {
            System.out.println("Ha explotado");
        }
    }
}
