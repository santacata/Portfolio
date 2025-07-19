<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
require_once './include/entity/CarretCompra.php';
require_once './include/entity/Producte.php';

// 👉 Gestionem l’eliminació abans de mostrar res
if (isset($_GET['elimina']) && isset($_SESSION["carretCompra"])) {
    $id = $_GET['elimina'];
    $carretCompra = unserialize($_SESSION["carretCompra"]);
    $carretCompra->eliminarProducte($id);
    $_SESSION["carretCompra"] = serialize($carretCompra);
}

// 👉 Ara gestionem la modificació de la quantitat quan es fa POST
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['idProducte']) && isset($_POST['quantitatProducte'])) {



    $idProducte = $_POST['idProducte'];
    $quantitatProducte = $_POST['quantitatProducte'];

    if (isset($_SESSION["carretCompra"])) {
        // Recuperem el carret de la sessió
        $carretCompra = unserialize($_SESSION["carretCompra"]);

        

        $productes = $carretCompra->getProductes();

        // Busquem el producte per ID i modifiquem la quantitat
        foreach ($productes as $producte) {
            if ($producte->getId() == $idProducte) {
                // Si la nova quantitat és menor que l'actual, actualitzem la quantitat
                if ($quantitatProducte < $producte->getQuantitat()) {
                    $producte->setQuantitat(($producte->getQuantitat())-$quantitatProducte); // Actualitzar la quantitat
                } else {
                    echo "<p style='color: red;'>La nova quantitat no pot ser superior o igual a l'actual.</p>";
                }
                break;
            }
        }

        // Actualitzem el carret a la sessió després de modificar la quantitat
        $_SESSION["carretCompra"] = serialize($carretCompra);
    }
}

// 👉 Recuperem el carret per mostrar-lo
if (isset($_SESSION["carretCompra"])) {
    $carretCompra = unserialize($_SESSION["carretCompra"]);
    $productes = $carretCompra->getProductes();

    // Ordenem els productes per ID de menor a major
    usort($productes, function($a, $b) {
        return $a->getId() - $b->getId();
    });

    echo "<h2>Contingut del carret</h2>";
            $carretCompra->mostrarCarret();

} else {
    echo "<p>Encara no tens carret.</p>";
}
    // ✅ Eliminem les variables temporals després d’usar-les
    unset($_SESSION['idProducte']);
    unset($_SESSION['quantitatProducte']);
echo "<a href='index.php?apartat=botiga'>🔙 Tornar a la botiga</a>";
?>
