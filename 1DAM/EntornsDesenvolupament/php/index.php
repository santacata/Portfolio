<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

include_once "include/header.php";

if (isset($_GET["apartat"])) {
    switch ($_GET['apartat']) {
        case "registre":
            include "./include/partials/registre.partial.php";
            break;
        case "contacte":
            include "./include/partials/contacte.partial.php";
            break;
        case "botiga":
            include "./include/partials/botiga.partial.php";
            break;
        case "admin":
            include "./include/partials/admin.partial.php";
            break;
        case "processaContacte":
            include "./include/processaContacte.php";
            break;
        case "processaRegistre":
            include "./include/processaRegistre.php";
            break;
        default:
            include "./include/partials/inici.partial.php";

            // Si l'usuari vol canviar la imatge de perfil
            if (isset($_GET["perfil"]) && $_GET["perfil"] === "canvi") {
                include "./include/partials/canviaImatge.partial.php";
            }
            break;
    }
} else {
    include "./include/partials/inici.partial.php";
}

include "./include/partials/data.partial.php";
include "./include/partials/estils.partial.php";
include_once "./include/footer.php";
////Fins aci

require './include/entity/Producte.php';
require './include/entity/CarretCompra.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['afegir_carret'])) {
    // Dades del formulari
    $id = (int) $_POST['id'];
    $nom = $_POST['nom'];
    $quantitat = (int) $_POST['quantitat'];
    $preu = (float) $_POST['preu'];
    $desc = $_POST['descripcio'];

    // Crear objecte Producte
    $producte = new Producte($id, $nom, $quantitat, $preu, $desc);

    // Comprovar si ja existeix carret a la sessió
    if (isset($_SESSION['carret'])) {
        $carret = unserialize($_SESSION['carret']);
    } else {
        $idUsuari = isset($_SESSION['email']) ? $_SESSION['email'] : session_id();
        $carret = new CarretCompra($idUsuari);
    }

    // Afegir o actualitzar el producte
    $carret->afegirProducte($producte);

    // Guardar el carret actualitzat a la sessió
    $_SESSION['carret'] = serialize($carret);

    // Guardar últim producte afegit
    $_SESSION['ultimProducte'] = serialize($producte);

    // Opcional: redireccionar o mostrar missatge
    header('Location: index.php');
    exit;
}
?>
