import java.util.Scanner;
public class arraysv2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int []array={1,2,33,44,5,56};
        int numerousuario;
        int posicion=0;
        boolean encontrado= false;

        int maximo = array[0];
        int posicionmaximo=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]<maximo){
                maximo=array[i];
                posicionmaximo=i;
            }
        }
        int minimo = array[0];
        int posicionminimo=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]<minimo){
                minimo=array[i];
                posicionminimo=i;
            }
        }
    }
}
