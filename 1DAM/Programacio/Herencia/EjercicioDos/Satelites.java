public class Satelites extends Astros {


    public int distanciaAlPlaneta;
    public int orbitaPlanetaria;
    public int planetaAlQuePertenece;

    public Satelites(int masaCuerpo, int diametroMedio, int rotacionSobreMismoEje, int translacionSobreOtroAstro,
            int distanciaOtroAstro, int temperaturaMedia, int gravedad, int distanciaAlPlaneta, int orbitaPlanetaria,
            int planetaAlQuePertenece) {
        super(masaCuerpo, diametroMedio, rotacionSobreMismoEje, translacionSobreOtroAstro, distanciaOtroAstro,
                temperaturaMedia, gravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaAlQuePertenece = planetaAlQuePertenece;
    }

    
public String muestra(){
    return "Satelites [masaCuerpo=" + masaCuerpo + ", distanciaAlPlaneta=" + distanciaAlPlaneta + ", diametroMedio="
    + diametroMedio + ", orbitaPlanetaria=" + orbitaPlanetaria + ", rotacionSobreMismoEje="
    + rotacionSobreMismoEje + ", planetaAlQuePertenece=" + planetaAlQuePertenece
    + ", translacionSobreOtroAstro=" + translacionSobreOtroAstro + ", distanciaOtroAstro="
    + distanciaOtroAstro + ", temperaturaMedia=" + temperaturaMedia + ", gravedad=" + gravedad
    + "]";
}
}
