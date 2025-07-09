public class App {
    public static void main(String[] args) {
        InterruptorGeneral interruptor1= new InterruptorGeneral();
        Bombilla bombilla1= new Bombilla("Bombilla de casa", interruptor1);
        Bombilla bombilla2= new Bombilla("Bombilla de la habitacion", interruptor1);
        interruptor1.encenderInterruptor();
        interruptor1.mostrarInformacion();
        interruptor1.apagarInterruptor();
        interruptor1.mostrarInformacion();
    }
}
