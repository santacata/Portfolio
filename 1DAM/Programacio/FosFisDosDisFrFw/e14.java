import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class e14 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try (DataOutputStream dos= new DataOutputStream(new FileOutputStream("arxiu.bin"));
        DataInputStream dis= new DataInputStream(new FileInputStream("arxiu.bin"))) {
            System.out.println("Dime una frase");
            String frase=sc.nextLine();
            dos.writeChars(frase);
            
            for (int i = 0; i < frase.length(); i++) {
            System.out.print(dis.readChar());  
            }

        } catch (Exception e) {
            System.out.print("Ha explotado");
        }
    }
}
