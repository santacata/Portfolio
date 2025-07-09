class Empleado {
    private final String nombre;
    private final String dni;
    private double sueldoBruto;
    private Integer edad;
    private String telefono;
    private String direccion;

    public Empleado(String nombre, String dni, double sueldoBruto) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoBruto = sueldoBruto;
    }

    public Empleado(String nombre, String dni, double sueldoBruto, 
                    Integer edad, String telefono, String direccion) {
        this(nombre, dni, sueldoBruto);
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double calcularSueldoNeto() {
        double sueldoAnual = sueldoBruto * 12;
        double irpf;
        
        if (sueldoAnual < 12000) {
            irpf = 0.20;
        } else if (sueldoAnual <= 25000) {
            irpf = 0.30;
        } else {
            irpf = 0.40;
        }
        
        return sueldoBruto * (1 - irpf);
    }

    public void mostrarInformacion() {
        System.out.println("--------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Sueldo bruto: " + sueldoBruto);
        System.out.println("Sueldo neto: " + calcularSueldoNeto());
        if (edad != null) System.out.println("Edad: " + edad);
        if (telefono != null) System.out.println("Teléfono: " + telefono);
        if (direccion != null) System.out.println("Dirección: " + direccion);
        System.out.println("--------------------------------");
    }
}