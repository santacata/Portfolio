public class Doctor {



    /*Almacenar info doctor
     * NBombre, edad, genero, especialidad y años de experiencia
     * Codigo ihnnterno para todos los doctores IdGlobal
     * 
     * Validar datos
     * Garaantizar que se muestren las edades y generos bien
     * 
     * Calcular las nominas segun las guardias y experiencia
     * 
     */
//Atributo statico
        private static int idGlobal=0;
        private static int codigoNomina=1000;

        //Atributo final constante para la instancia de doctor. El valor no cambia
        public final static String HOSPITAL_NOMBRE= "Hospital General";
        public static final double IVA= 0.21; //Para calculos


        //Atributos de instancia

        private static String nombre;
        private static String especialidad;
        private static int edad;
        private static String genero;
        private static int experiencia; //años experiencia doctor

        //Constructor
        public Doctor(){
            System.out.println("Constructor por defecto, se ha creado un doctor");
            idGlobal++;
        }
        //Constructor para la validacion de datos
        public Doctor(String nombre, int edad, String especialidad, String genero,int experiencia){
            this(); //Llamar al constructor anterior
            this.nombre=nombre;
            this.edad=edad;
            this.especialidad=especialidad;
            this.genero=genero;
            this.experiencia=experiencia;
        }
        //Constructor simplificado
        public Doctor(String nombre, int edad, String genero){
            this(nombre, edad, nombre, genero, edad);
        }

        //Metodos de validacion
        private String validarGenero(String genero){
            if(genero.equalsIgnoreCase("Masculino")|genero.equalsIgnoreCase("femenino")){
                return genero;
            }else{
                System.out.println("genero no válido");
                return "No especificado";
            }

        }

        private int validarEdad(int edad){
            if (edad>=18) {
                return edad;
            }else{
                System.out.println("Eres menor de edad");
                return 0;

            }
        }
        private String validarNombre(String nombre){
            if (nombre== null | nombre.trim().isEmpty()) {
                return nombre;
            }else{
                return "No especificat";
            }
        }



    public static void main(String[] args) {
        
    }
//Metodo para calcular el plus de las guardias

public double calcularPlusGuardia(int nochesguardia){
double plus=nochesguardia*50;
return plus;
}
public double calcularNomina(double salariobase, int nochesguardia){
    double plus= calcularPlusGuardia(nochesguardia);
    return salariobase+plus;
}
//Getter
public String getNombre(){
    return nombre;
}
//Setter
public void setNombre(String nombre){
    this.nombre=nombre; //No valida
}
public void setEdad(int edad){
    this.edad=edad; //No valida
}

public static void mostrarDatos(){
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
}
public static void mostrarIDGlobal(){
System.out.println("ID del doctor es "+idGlobal);
System.out.println("El numero de nomina es "+codigoNomina);
}


















}