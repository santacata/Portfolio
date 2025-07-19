package Datos;

public class Libro {

    private String titulo;
    private String editorial;
    private int numPaginas;
    private Autor autor;
    
    public Libro(String titulo, String editorial, int numPaginas, Autor autor) {
        this(titulo); //este busca un parametro y siempre va de primero
        this.editorial = editorial;
        setNumPaginas(numPaginas);
        this.autor = autor;
        autor.nuevoLibro(this); //No es un constructor
    }
    public void setNumPaginas(int numPaginas) {
        if ( numPaginas > 0) {
            this.numPaginas = numPaginas;
        }else{
            this.numPaginas = 1;
        }

    }

    public Libro(String titulo) {
        this.titulo = titulo;
        editorial = "";
        numPaginas = 1;
    }

    public Libro() {
        titulo = "";
        
        numPaginas = 1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void mostrarInformacion(){
        System.out.println("titulo "+ titulo);
        System.out.println("editorial: "+ editorial);
        System.out.println("paginas: "+ numPaginas);
        System.out.println("autor: "+ autor.getNombre());
    }


}