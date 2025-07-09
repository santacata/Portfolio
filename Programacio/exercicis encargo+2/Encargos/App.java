public class App {
    public static void main(String[] args) {
        Cliente_corporativo cc1= new Cliente_corporativo(12, "Paco", "Aichatiba", 1529884);
        Cliente_particular cp1= new Cliente_particular(12, "Paco", "Aichatiba", 1529887);
        Encargo e1= new Encargo(2, "34");
        Encargo e2= new Encargo(57, "sí");
        Cliente.enunciarClients();
        Cliente.enunciarEncarrecs();
    }
}
