import java.util.ArrayList;

class Inventario {
    private ArrayList<Mascota> animales;

    public Inventario() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Mascota animal) {
        animales.add(animal);
    }

    public void eliminarAnimal(Mascota animal) {
        animales.remove(animal);
    }

    public void vaciarInventario() {
        animales.clear();
    }

    public void mostrarListaAnimales() {
        for (Mascota animal : animales) {
            animal.muestra();
        }
    }

    public void mostrarDatosAnimal(Mascota animal) {
        if (animales.contains(animal)) {
            animal.muestra();
            animal.habla();
            if (animal instanceof Ave) {
                ((Ave) animal).volar();
            }
        } else {
            System.out.println("El animal no existe en la base de datos.");
        }
    }

    public void mostrarTodosDatos() {
        for (Mascota animal : animales) {
            mostrarDatosAnimal(animal);
            System.out.println();
        }
    }
}
