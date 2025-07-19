<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (!isset($_SESSION['estil'])) {
    $_SESSION['estil'] = 'estils.css';
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['idProducte']) && isset($_POST['quantitatProducte'])) {
    $_SESSION['idProducte'] = $_POST['idProducte'];
    $_SESSION['quantitatProducte'] = $_POST['quantitatProducte'];
}

$estil = $_SESSION['estil'];

echo "<link rel='stylesheet' href='css/$estil'>";
?>

<h2>Botiga</h2>

<?php

include './include/funcions.php'; // Ací tinc definida mostraProductesBD

// Paginació
if (!isset($_GET['mostrar'])) {
    $pagina = isset($_GET['pagina']) ? intval($_GET['pagina']) : 1;
    if ($pagina < 1) $pagina = 1;
    mostraProductesBD($pagina);
}

include_once './include/partials/infocarret.partial.php';
function mostraFormulariProducte($id) {
    echo "
    <form  id='formulariProducte_$id' name='formulariProducte_$id' method='post' action=''>
        <input type='hidden' name='idProducte' value='$id'>
        <label for='quantitat_$id' >Quantitat:</label>
        <input type='number' id='quantitat_$id' name='quantitatProducte' value='1' min='0' step='any' required>
        <button type='submit'>Afegeix al carret</button>
    </form>
    ";
}


?>