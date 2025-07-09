public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Tech Solutions", "A12345678", 
                                    "912345678", "Calle Falsa 123");
        
        Empleado emp1 = new Empleado("Juan Pérez", "12345678A", 2000, 
                                    30, "600123456", "Calle Real 1");
        Empleado emp2 = new Empleado("Ana García", "87654321B", 1500);
        Empleado emp3 = new Empleado("Luis Martínez", "56781234C", 3000, 
                                    45, "611234567", "Avenida Principal 5");
        
        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        System.out.println("--------------------------------");
        System.out.println("Información de todos los empleados:");
        empresa.mostrarEmpleados();
        System.out.println("--------------------------------");
        System.out.println("Sueldos de los empleados:");
        empresa.mostrarSueldos();
        System.out.println("--------------------------------");
        System.out.println("Total sueldos brutos: " + empresa.totalSueldosBrutos());
        System.out.println("Total sueldos netos: " + empresa.totalSueldosNetos());
    }
}