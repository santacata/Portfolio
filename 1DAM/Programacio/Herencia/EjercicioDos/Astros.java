public abstract class Astros {
    public int masaCuerpo;
    public int diametroMedio;
    public int rotacionSobreMismoEje;
    public int translacionSobreOtroAstro;
    public int distanciaOtroAstro;
    public int temperaturaMedia;
    public int gravedad;

    public Astros(int masaCuerpo, int diametroMedio, int rotacionSobreMismoEje, int translacionSobreOtroAstro,
            int distanciaOtroAstro, int temperaturaMedia, int gravedad) {
        this.masaCuerpo = masaCuerpo;
        this.diametroMedio = diametroMedio;
        this.rotacionSobreMismoEje = rotacionSobreMismoEje;
        this.translacionSobreOtroAstro = translacionSobreOtroAstro;
        this.distanciaOtroAstro = distanciaOtroAstro;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;
    }

    public abstract String muestra();
}