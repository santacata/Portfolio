public class Main {
    public static void main(String[] args) {
        Planetas tierra = new Planetas(4564, 312, 25, 256,
        1034, 50, 10, 800, 256,
        3);
        Planetas saturno = new Planetas(4564, 312, 25, 256,
        1034, 50, 10, 800, 256,
        1);
        Satelites sol = new Satelites(2000, 300, 0, 25,
        50, 5, 2,20, 30,
        2);

        System.out.println(tierra.muestra());
        System.out.println();
        System.out.println(saturno.muestra());
        System.out.println();
        System.out.println(sol.muestra());
    }
}
