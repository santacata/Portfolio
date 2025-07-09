public class SintonizadorFM {
    private double frecuencia;

    public SintonizadorFM() {
        frecuencia = 80;
    }
    public SintonizadorFM(double frecuencia) { //Para hacerla con la frecuencia que queramos
        this.frecuencia = frecuencia;
    }

    public void upFrecuencia() {
        frecuencia += 0.5;
        if (frecuencia > 108) {
            frecuencia = 87.0;
        }
    }

    public void downFrecuencia() {
        frecuencia -= 0.5;
        if (frecuencia < 80.0) {
            frecuencia = 108;
        }
    }

    public double getFrecuencia() {
        return frecuencia;
    }
}
