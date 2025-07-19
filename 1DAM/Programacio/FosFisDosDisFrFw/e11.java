import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class e11 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Pide un valor double por consola y guárdalo en un archivo binario.");
        try {
            System.out.println("Dime un double");
            String numero=sc.nextLine();
            DataOutputStream dos= new DataOutputStream(new FileOutputStream("arxiu.bin"));
            double usar=Double.parseDouble(numero); //Con esta conversion me lo deja usar
            dos.writeDouble(usar);
            dos.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Ha explotado");
            e.printStackTrace();
        }
        
        
    }
}
