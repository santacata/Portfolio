class Rectangulo implements iFigura2D {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double perimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public double area() {
        return ancho * alto;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            ancho *= escala;
            alto *= escala;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Rectángulo - Ancho: " + ancho + 
                          ", Alto: " + alto + 
                          ", Perímetro: " + perimetro() + 
                          ", Área: " + area());
    }
}
