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

    // Método para aumentar la capacidad del arreglo si no caben más elementos
    private void aumentarCapacidad() {
        int[] nuevoArreglo = new int[elementos.length + INCREMENTO_CAPACIDAD];
        System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length); // Copiar elementos al nuevo arreglo
        elementos = nuevoArreglo;
    }

       // Método estático para concatenar dos listas (Estático porque no depende de una instancia y le pasamos las dos listas como argumentos)
       public static Lista concatena(Lista lista1, Lista lista2) {
        Lista resultado = new Lista();
        for (int i = 0; i < lista1.cantidad; i++) {
            resultado.insertarFinal(lista1.elementos[i]);
        }
        for (int i = 0; i < lista2.cantidad; i++) {
            resultado.insertarFinal(lista2.elementos[i]);
        }
        return resultado;
    }

    //Metodo para mostrar la lista (la tendremos que comprobar en el main)
    public void mostrarLista(){
        for (int i = 0; i < cantidad; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}