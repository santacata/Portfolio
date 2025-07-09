package personal;

public class Personal {
    private static final int MAX_PERSONAL = 10; // Tamaño máximo
    private Maquinista[] maquinistas = new Maquinista[MAX_PERSONAL];
    private Mecánico[] mecanicos = new Mecánico[MAX_PERSONAL];
    private JefeEstacion[] jefesEstacion = new JefeEstacion[MAX_PERSONAL];

    private int cantidadMaquinistas = 0;
    private int cantidadMecanicos = 0;
    private int cantidadJefes = 0;

    public void agregarMaquinista(Maquinista maquinista) {
        if (cantidadMaquinistas < MAX_PERSONAL) {
            maquinistas[cantidadMaquinistas++] = maquinista;
        }
    }

    public void agregarMecanico(Mecánico mecanico) {
        if (cantidadMecanicos < MAX_PERSONAL) {
            mecanicos[cantidadMecanicos++] = mecanico;
        }
    }

    public void agregarJefeEstacion(JefeEstacion jefe) {
        if (cantidadJefes < MAX_PERSONAL) {
            jefesEstacion[cantidadJefes++] = jefe;
        }
    }

    public void mostrarPersonal() {
        System.out.println("=== Personal de la Empresa ===");

        System.out.println("\nMaquinistas:");
        for (int i = 0; i < cantidadMaquinistas; i++) {
            System.out.println("- " + maquinistas[i].nombre + " | DNI: " + maquinistas[i].dni + 
                               " | Sueldo: " + maquinistas[i].sueldo + " | Rango: " + maquinistas[i].rango);
        }

        System.out.println("\nMecánicos:");
        for (int i = 0; i < cantidadMecanicos; i++) {
            System.out.println("- " + mecanicos[i].nombre + " | Teléfono: " + mecanicos[i].telefono + 
                               " | Especialidad: " + mecanicos[i].especialidad);
        }

        System.out.println("\nJefes de Estación:");
        for (int i = 0; i < cantidadJefes; i++) {
            System.out.println("- " + jefesEstacion[i].nombre + " | DNI: " + jefesEstacion[i].dni + 
                               " | Nombrado el: " + jefesEstacion[i].fechaNombramiento);
        }
    }
}