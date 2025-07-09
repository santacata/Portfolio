package persona;
class exercicidos {
    public static void main(String[] args) {
        Persona p1= new Persona();
        p1.mostrarDatos();
        p1.dni="123456A";
        p1.ciudadDeResidencia="Valencia";
        p1.setEdad(80);
        p1.profesioString="Xafador de xarcos";
        p1.mostrarDatos();

        //Tambien podemos instanciar
        Persona p2;
        p2= new Persona();
        p2.nombre="Pepa";
        p2.setEdad(55);
        p2.getEdad();
        p2.mostrarDatos();
        Persona p3=p2; //Per referencia
        //p3 i p2 son el mateix

        Persona p5=new Persona();
        p5.etablecerEdad(-22);
        

    }
}
