public class Doctor {

    private static int idGlobal = 0;
    private static int codigoNomina = 1000;

    public final static String HOSPITAL_NOMBRE = "Hospital General";
    public static final double IVA = 0.21;

    private String nombre;
    private String especialidad;
    private int edad;
    private String genero;
    private int experiencia;

    public Doctor() {
        System.out.println("Constructor por defecto, se ha creado un doctor");
        idGlobal++;
    }

    public Doctor(String nombre, int edad, String especialidad, String genero, int experiencia) {
        this();
        this.nombre = validarNombre(nombre);
        this.edad = validarEdad(edad);
        this.especialidad = especialidad;
        this.genero = validarGenero(genero);
        this.experiencia = experiencia;
    }

    public Doctor(String nombre, int edad, String genero) {
        this(nombre, edad, "General", genero, 0);
    }

    private String validarGenero(String genero) {
        if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")) {
            return genero;
        } else {
            System.out.println("Género no válido");
            return "No especificado";
        }
    }

    private int validarEdad(int edad) {
        if (edad >= 18) {
            return edad;
        } else {
            System.out.println("Eres menor de edad");
            return 0;
        }
    }

    private String validarNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            return nombre;
        } else {
            return "No especificado";
        }
    }

    public double calcularPlusGuardia(int nochesGuardia) {
        return nochesGuardia * 50;
    }

    public double calcularNomina(double salarioBase, int nochesGuardia) {
        return salarioBase + calcularPlusGuardia(nochesGuardia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarNombre(nombre);
    }

    public void setEdad(int edad) {
        this.edad = validarEdad(edad);
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Experiencia: " + experiencia + " años");
    }

    public static void mostrarIDGlobal() {
        System.out.println("ID global acumulado: " + idGlobal);
        System.out.println("Código de nómina: " + codigoNomina);
    }

    public static void main(String[] args) {
        Doctor d1 = new Doctor("Rubén", 27, "Cardiología", "Masculino", 3);
        d1.mostrarDatos();
        System.out.println("Sueldo: " + d1.calcularNomina(1800, 5) + " €");

        Doctor.mostrarIDGlobal();
    }
}
