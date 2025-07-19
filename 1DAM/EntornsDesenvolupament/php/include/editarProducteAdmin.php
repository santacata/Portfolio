<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

if (!isset($_GET['id'])) {
    die("ID no especificat.");
}

$id = intval($_GET['id']);

// Inclou amb comprovació de si existeixen els arxius
if (file_exists("./entity/CredencialsBD.php")) {
    include_once "./entity/CredencialsBD.php";
} else {
    echo "No s'ha pogut incloure CredencialsBD.php<br>";
}
if (file_exists("./configMySQL.php")) {
    include_once "./configMySQL.php";
} else {
    echo "No s'ha pogut incloure configMySQL.php<br>";
}

// Consultar el producte per eixe ID
$sql = "SELECT * FROM producte WHERE id = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id);
$stmt->execute();
$resultat = $stmt->get_result();

if ($resultat->num_rows === 0) {
    die("Producte no trobat.");
}

$fila = $resultat->fetch_assoc(); // Obtenim les dades del producte

// Mostrar el formulari amb les dades del producte
echo "<h2>Formulari d'edició de producte</h2>
<form action='' method='POST' enctype='multipart/form-data'>
    <label>Nom: <input type='text' name='nom' value='" . htmlspecialchars($fila['nom']) . "'></label><br>
    <label>Descripció: <input type='text' name='descripcio' value='" . htmlspecialchars($fila['descripcio']) . "'></label><br>
    <label>Preu: <input type='text' name='preu' value='" . htmlspecialchars($fila['preu']) . "'></label><br>
    <label>M'agrada: <input type='text' name='magrada' value='" . htmlspecialchars($fila['magrada']) . "'></label><br>
    <label>Data afegit: <input type='date' name='data_afegit' value='" . htmlspecialchars($fila['data_afegit']) . "'></label><br>
    <label>Estoc: <input type='text' name='estoc' value='" . htmlspecialchars($fila['estoc']) . "'></label><br>
    <input type='submit' value='Guardar canvis'>
</form>";

// Si rebem el formulari per POST, actualitzem el producte
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nom = $_POST['nom'];
    $descripcio = $_POST['descripcio'];
    $preu = $_POST['preu'];
    $magrada = $_POST['magrada'];
    $data_afegit = $_POST['data_afegit'];
    $estoc = $_POST['estoc'];

    $sql = "UPDATE producte SET nom=?, descripcio=?, preu=?, magrada=?, data_afegit=?, estoc=? WHERE id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssdsdsi", $nom, $descripcio, $preu, $magrada, $data_afegit, $estoc, $id);
    $stmt->execute();

    $_SESSION['missatge'] = "Producte actualitzat correctament.";

    $conn->close();

    //Escriure en el log
    $_SESSION["editar"]=true;
    include "./funcions.php";
    escriureLog(($nom));

    
    exit;
}
?>
