class Circulo implements iFigura2D {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            radio *= escala;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Círculo - Radio: " + radio + 
                          ", Perímetro: " + perimetro() + 
                          ", Área: " + area());
    }
}
