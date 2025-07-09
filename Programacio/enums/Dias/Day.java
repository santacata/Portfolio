package Dias;

public enum Day {
    //Cada valor un mensaje y numero asociado
    LUNES("estoy cansado",1), MARTES("Estoy cansado",2),MIERCOLES("estoy cansado",3), JUEVES("Estoy cansado",4), VIERNES("estoy cansado",5), SABADO("Estoy cansado",6);

    private String actividad;
    private int numeroDia;

    private Day(String actividad, int num){
        this.actividad=actividad;
        this.numeroDia=num;
    }

    public String getActividad() {
        return actividad;
    }

    public int getNumeroDia() {
        return numeroDia;
    }


    //Metodo para mostrar todos los dias con sus actividades y numeros
    public static  void mostrarTodosLosDias(){
        for (Day d : Day.values()) {
            System.out.println("Dia"+d+"actividad"+d.getActividad()+"numero"+d.getNumeroDia());
        }
    }

}
