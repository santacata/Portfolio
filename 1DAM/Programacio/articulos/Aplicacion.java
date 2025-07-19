package articulos;

public class Aplicacion {
    public static void main(String[] args) {
        
    //Creamos articulos
    Articulo articulo1=new Articulo();
    Articulo articulo2=new Articulo();
    Articulo articulo3=new Articulo();

    //Valores a los Atributos
    articulo1.cod="001";
    articulo1.titulo= "La guerra de las galaxias";
    articulo1.formato="DVD";
    articulo1.precio_alquiler=2.5f;

    articulo2.cod="002";
    articulo2.titulo= "La guarra de las galaxias";
    articulo2.formato="DVB";
    articulo2.precio_alquiler=3.5f;
    
    System.out.println(articulo1.cod+" "+articulo1.titulo+" "+articulo1.precio1());
    System.out.println(articulo2.cod+" "+articulo2.titulo+" "+articulo2.precio2());
    Articulo.mostrarContador();

}
}
