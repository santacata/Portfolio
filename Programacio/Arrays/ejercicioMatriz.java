public class ejercicioMatriz {
    public static void main(String[] args) {

        
        crearmatriz(4);
        imprimirmatrizsinidices();
        
    }
    static void crearmatriz(int n){
        int[][] m = new int [n][n];
        for (int[] fila : m) {         
                String linea="";
                for (int columna : fila) {
                    if (columna==1) {
                        linea= "X"+linea;
                        
                    }else{
                        linea="- "+linea;
                    }
                    
                }
            
        }
    }
    static void imprimirmatriz(int[][] m){

    }
    public static void imprimirmatrizsinidices(){

    }

}
