package Persona;

public class Persona {
    private final String dni; // DNI es final, no puede variar
    private String nom = "pepe";
    private String apellidos = "sarmiento";
    private int edad = 32;

    // Constructor por defecto
    public Persona() {
        this.dni = "2457651j"; // Asignación obligatoria porque dni es final
        this.nom = "Anon";
        this.apellidos = "Anon";
        this.edad = 0;
    }

    // Constructor con parámetros
    public Persona(String dni, String nom, String apellidos, int edad) {
        if (validarDNI(dni)) {
            this.dni = dni; // Asignación obligatoria porque dni es final
            this.nom = nom;
            this.apellidos = apellidos;
            this.edad = edad;
        } else {
            System.out.println("Error: DNI no válido. No se ha creado la persona.");
            this.dni = "00000000A"; // Valor por defecto en caso de DNI inválido
        }
    }

    // Método para validar el DNI manualmente
    public static boolean validarDNI(String dni) {
        // Verificar que el DNI tenga exactamente 9 caracteres
        if (dni == null || dni.length() != 9) {
            return false;
        }

        // Verificar que los primeros 8 caracteres sean dígitos
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }

        // Verificar que el último carácter sea una letra
        char ultimoCaracter = dni.charAt(8);
        return Character.isLetter(ultimoCaracter);
    }

    // Métodos getter
    public String getterDNI() {
        return dni;
    }

    public String getterNom() {
        return nom;
    }

    public void setterNom(String nouValor) {
        this.nom = nouValor;
    }

    public String getterApellidos() {
        return apellidos;
    }

    public void setterApellidos(String nouValor) {
        this.apellidos = nouValor;
    }

    public int getterEdad() {
        return edad;
    }

    public void setterEdad(int nouValor) {
        this.edad = nouValor;
    }

    // Métodos adicionales
    public void imprime() {
        System.out.println("DNI: " + dni);
        System.out.println("Nom: " + nom);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Edad: " + edad);
    }

    public boolean esMayorEdad() {
        return edad >= 18;
    }

    public boolean esJubilado() {
        return edad >= 68;
    }

    public int diferenciaEdad(Persona p) {
        return edad - p.edad;
    }
}