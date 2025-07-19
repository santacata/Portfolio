import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class e15 {
    public static void main(String[] args) {
        System.out.println("Implementa un programa que lea números enteros desde el fichero numeros.dat y los vaya guardando en los ficheros pares.dat e impares.dat, según su paridad");
        try (DataOutputStream dos=new DataOutputStream(new FileOutputStream("pares.dat"));
        DataOutputStream dos2=new DataOutputStream(new FileOutputStream("impares.dat"));
        DataInputStream dis= new DataInputStream(new FileInputStream("numeros.dat"))) {
            try {
                while (true) {
                    int numero=dis.readInt();
                    (numero%2==0?dos:dos2).writeInt(numero);
                }
            } catch (EOFException e) {
                System.out.println("Se ha terminado el archivo");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
