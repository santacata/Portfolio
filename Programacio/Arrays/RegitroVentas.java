import java.util.Scanner;

public class RegitroVentas {
    /*Desarrollar un programa para registrar, calcular y mostrar ventas trimestrales de varios productos
     * Solicitará al usuario la cantidad de productos, nombre y ñas ventas de los mesos de enero febrero y marzo
     * 
     * Guardar los nombres en un array
     * y las ventas en una matriz bidimensional
     */
    public static void main(String[] args) {
        Scanner entradausuario= new Scanner(System.in);

        //Solicitamos la cnatidad de productos a registrar
        System.out.println("Introduce en numero de productos");
        int numeroDeProductos= entradausuario.nextInt();

        entradausuario.nextLine(); //Borrar la linea
        double[][]ventasPorProducto=new double[numeroDeProductos][3];
        String[] nombreDeProductos = new String[numeroDeProductos];

        //!Registrar datos para cada producto
        for (int indiceDeProducto = 0; indiceDeProducto < numeroDeProductos; indiceDeProducto++) {
            //Solicitar el producto y almacenarl
            nombreDeProductos[indiceDeProducto]=obtenerNombreProducto(entradausuario);
            for (int mes = 0; mes <3; mes++) {
            System.out.println("ingresa las ventas y el mes en el que se ingresan");
            System.out.printf("Ingresa las ventas para su %s en el mes %s: ",nombreDeProductos[indiceDeProducto], obtenerNombreMes(mes));
            ventasPorProducto[indiceDeProducto][mes]=entradausuario.nextDouble();
            }
            entradausuario.nextLine();
        }
        
        //Leer y guardar las ventas en la matriz
        System.out.println("ventas ingresadas");
        for (int indiceDeProducto = 0; indiceDeProducto < numeroDeProductos; indiceDeProducto++) {
            System.out.printf("producto: %s\t Ventas en enero: %2f€\tVentas en febrero: %2f€\tVentas en marzo: : %2f€\t",
            nombreDeProductos[indiceDeProducto],
            ventasPorProducto[indiceDeProducto][0],
            ventasPorProducto[indiceDeProducto][1],
            ventasPorProducto[indiceDeProducto][2]);
            
        }
        //Calcular y mostrar el total de ventas de producto
        System.out.println("Total de ventas de producto");
        for (int indiceDeProducto = 0; indiceDeProducto < numeroDeProductos; indiceDeProducto++) {
            //Crear un metodo para calcular el total de ventas
            
        }
    }
    static String obtenerNombreProducto(Scanner entrada){
        System.out.println("Introduce el nombre del producto");
        String nombre=entrada.nextLine();
        return nombre;
    }
    static String obtenerNombreMes(int indiceMes){
        String[]meses={"enero","febrero","marzo"};
        return meses[indiceMes];
    }
    static void mostrarVentasProductos(String[] productos, double [][]ventasPorProducto){
        System.out.println("\n Resumen de ventas por producto: ");
        System.out.println("|------------------------------------------------| |----------------------||-------------------------||-----------------|");
        System.out.printf("|%-25s|%-15s|%-15s|%-15s|%n","Producto","enero","febrero","marzo");
        System.out.println("|------------------------------------------------| |----------------------||-------------------------||-----------------|");

        //Mostrar las ventas de cada producto
        for (int indiceDeProducto = 0; indiceDeProducto < productos.length; indiceDeProducto++) {
            System.out.printf("|%-25s|%-15s|%-15s|%-15s|%n",
            productos[indiceDeProducto],
            ventasPorProducto[indiceDeProducto][0],
            ventasPorProducto[indiceDeProducto][1],
            ventasPorProducto[indiceDeProducto][2]);
        }
        System.out.println("|------------------------------------------------| |----------------------||-------------------------||-----------------|");
    }
}
