class CuentaAhorro extends CuentaBancaria {
    private double saldoMinimo;

    public CuentaAhorro(String iban, double saldo, double saldoMinimo) {
        super(iban, saldo);
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public void calcularIntereses() {
        double tasaInteres;
        if (saldo < saldoMinimo) {
            tasaInteres = interesAnualBasico / 2;
        } else {
            tasaInteres = interesAnualBasico * 2;
        }
        double intereses = saldo * tasaInteres;
        añadir(intereses);
    }
}