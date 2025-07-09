class Producto {
    String nombre; //Los productos sólo se diferencian por esto
    
    public Producto(String nombre) { //el constructor
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
