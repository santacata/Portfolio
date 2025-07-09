class Cuadrado implements iFigura2D {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            lado *= escala;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Cuadrado - Lado: " + lado + 
                          ", Perímetro: " + perimetro() + 
                          ", Área: " + area());
    }
}
