class Triangulo implements iFigura2D {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double perimetro() {
        // Para simplificar, asumimos triángulo rectángulo
        double hipotenusa = Math.sqrt(base * base + altura * altura);
        return base + altura + hipotenusa;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            base *= escala;
            altura *= escala;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Triángulo - Base: " + base + 
                          ", Altura: " + altura + 
                          ", Perímetro: " + perimetro() + 
                          ", Área: " + area());
    }
}
