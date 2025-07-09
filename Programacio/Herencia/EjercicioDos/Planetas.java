public class Planetas extends Astros {
    public int distanciaAlSol;
    public int orbitaAlSol;
    public int tieneSatelites;
    
    public Planetas(int masaCuerpo, int diametroMedio, int rotacionSobreMismoEje, int translacionSobreOtroAstro,
    int distanciaOtroAstro, int temperaturaMedia, int gravedad, int distanciaAlSol, int orbitaAlSol,
    int tieneSatelites) {
super(masaCuerpo, diametroMedio, rotacionSobreMismoEje, translacionSobreOtroAstro, distanciaOtroAstro,
        temperaturaMedia, gravedad);
this.distanciaAlSol = distanciaAlSol;
this.orbitaAlSol = orbitaAlSol;
this.tieneSatelites = tieneSatelites;
}




public String muestra() {
    return "Planetas [masaCuerpo=" + masaCuerpo + ", distanciaAlSol=" + distanciaAlSol + ", diametroMedio="
            + diametroMedio + ", orbitaAlSol=" + orbitaAlSol + ", rotacionSobreMismoEje=" + rotacionSobreMismoEje
            + ", tieneSatelites=" + tieneSatelites + ", translacionSobreOtroAstro=" + translacionSobreOtroAstro
            + ", distanciaOtroAstro=" + distanciaOtroAstro + ", temperaturaMedia=" + temperaturaMedia + ", gravedad="
            + gravedad +"]";
}
}
