public class Lista {
    private int[] elementos; 
    private int cantidad;
    private static final int INCREMENTO_CAPACIDAD = 10;

    public Lista() {
        elementos = new int[INCREMENTO_CAPACIDAD]; // Espacio inicial
        cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void insertarFinal(int num) {
        if (cantidad == elementos.length) {
            aumentarCapacidad();
        }
        elementos[cantidad] = num;
        cantidad++;
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(elementos[i]);
            if (i < cantidad - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // MÉTODO DE INSTANCIA PARA CONCATENAR OTRA LISTA
    public Lista concatenar(Lista otraLista) {
        Lista resultado = new Lista();
        for (int i = 0; i < this.cantidad; i++) {
            resultado.insertarFinal(this.elementos[i]);
        }
        for (int i = 0; i < otraLista.cantidad; i++) {
            resultado.insertarFinal(otraLista.elementos[i]);
        }
        return resultado;
    }

    // Método para aumentar la capacidad del arreglo
    private void aumentarCapacidad() {
        int[] nuevoArreglo = new int[elementos.length + INCREMENTO_CAPACIDAD];
        System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length);
        elementos = nuevoArreglo;
    }

    //Metodo para mostrar la lista (la tendremos que comprobar en el main)
    public void mostrarLista(){
        for (int i = 0; i < cantidad; i++) {
            System.out.print(elementos[i] + " ");
        }            
        System.out.println();
    }

}