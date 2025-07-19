package articulos;

public class Articulo {
    String cod;
    String titulo;
    String formato;
    float precio_alquiler;

    //Static
    private static int contador=0; //contar articulos creados
    public static final double IVA= 0.21; //Constante

    //Constructor por defecto
    public Articulo(){
        contador++;
    }

    //Definimos tres metodos para calcular el precio de alquiler de los articulos
    //Si es de un dia, dos días o tres

    float precio1(){
        return precio_alquiler;
    }
    float precio2(){
        float precio_total;
        precio_total=precio_alquiler*2;
        return precio_total;
    }
    float precio3(){
        float precio_total;
        precio_total=precio_alquiler*3;
        return precio_total;
    }
    public void mostrarArticulos(){
        if (titulo==null) {
            titulo="Sin titulo";
            System.out.println("articulo"+cod+titulo+formato+precio_alquiler+IVA);
        }
    }
    //Metodo para insertar un titulo que es null
    public void insertarTitulo(String titulo){
        if (titulo==null) 
        titulo="Sin Titulo";
            
    }
    public static void mostrarContador(){
        System.out.println("Numero de articulos creados= "+Articulo.contador);
        //Estatico necesita estaticos
        //Pertenece a la clase, no al objeto
        //Se puede usar sin crear una instancia.(Objeto)
    }
}
