function agregarLista() {
    let lista = document.createElement("ol"); // Crear la lista

    for (let i = 0; i < 5; i++) {
        let nuevoElemento = document.createElement("li"); // Crear cada elemento <li>
        nuevoElemento.textContent = "Nuevo Elemento " + (i + 1); // Añadir texto
        lista.appendChild(nuevoElemento); // Agregar cada <li> a la lista
    }

    document.body.appendChild(lista); // Agregar la lista al body
}