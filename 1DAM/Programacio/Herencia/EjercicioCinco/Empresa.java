import java.util.ArrayList;
class Empresa {

    private final String nombre;
    private final String cif;
    private String telefono;
    private String direccion;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.empleados = new ArrayList<>();
    }

    public Empresa(String nombre, String cif, String telefono, String direccion) {
        this(nombre, cif);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println();
        }
    }

    public void mostrarSueldos() {
        for (Empleado empleado : empleados) {
            System.out.println("DNI: " + empleado.getDni() + 
                              ", Sueldo bruto: " + empleado.getSueldoBruto() + 
                              ", Sueldo neto: " + empleado.calcularSueldoNeto());
        }
    }

    public double totalSueldosBrutos() {
        double total = 0;
        for (Empleado empleado : empleados) {
            total += empleado.getSueldoBruto();
        }
        return total;
    }

    public double totalSueldosNetos() {
        double total = 0;
        for (Empleado empleado : empleados) {
            total += empleado.calcularSueldoNeto();
        }
        return total;
    }
    @Override
    public String toString() {
        return "La información de la empresa es [nombre=" + nombre + ", cif=" + cif + ", telefono=" + telefono + ", direccion=" + direccion
                + ", empleados=" + empleados + ", totalSueldosBrutos()=" + totalSueldosBrutos()
                + ", totalSueldosNetos()=" + totalSueldosNetos() + "]";
    }
}
