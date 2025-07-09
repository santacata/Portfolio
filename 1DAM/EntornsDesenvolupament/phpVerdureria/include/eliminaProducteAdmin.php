<?php

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
if (!isset($_GET['id'])) {
    die("ID no especificat.");
}

$id = intval($_GET['id']);

include_once "./entity/CredencialsBD.php";
include_once "./configMySQL.php";


// 1. Obtenir la imatge del producte
$sql = "SELECT imatge FROM producte WHERE id = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id);
$stmt->execute();
$resultat = $stmt->get_result();

if ($fila = $resultat->fetch_assoc()) {
    $imatge = $fila['imatge'];

    // 2. Eliminar de la BD
    $stmtNom= $conn->prepare("SELECT nom FROM producte WHERE id = ?");
    $stmtNom->bind_param("i", $id); //Mostra que es un integer el valor que anem a anyadir
    $stmtNom->execute();
    // Recuperar el resultado de la consulta
    $result = $stmtNom->get_result();
    $row = $result->fetch_assoc(); //El resultat dóna sempre un array
    $nom = $row['nom']; // Ací ja tiens el nom
    //Eliminar el producte
    $stmtDel = $conn->prepare("DELETE FROM producte WHERE id = ?");
    $stmtDel->bind_param("i", $id); //Mostra que es un integer el valor que anem a anyadir
    $stmtDel->execute();

    // 3. Eliminar la imatge si existeix
    if ($imatge && file_exists("images/$imatge")) {
        unlink("images/$imatge");
    }

    //Escriure en el log
    $_SESSION["eliminar"]=true;
    include "./funcions.php";
    escriureLog(($nom));

    $_SESSION['missatge'] = "Producte eliminat correctament.";
} else {
    $_SESSION['missatge'] = "El producte no existeix.";
}

$conn->close();

// 4. Redirigir
header("Location: ../index.php?apartat=admin&seccio=productes&eliminat=si");
exit;
;