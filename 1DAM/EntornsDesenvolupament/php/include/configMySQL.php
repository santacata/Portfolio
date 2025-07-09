<?php
if (file_exists('./include/entity/CredencialsBD.php')) {
    include './include/entity/CredencialsBD.php';
}



$conn = new mysqli($servidor, $usuari, $contrasenya, $basedades);

// Comprovar connexió
if ($conn->connect_error) {
    die("Error de connexió: " . $conn->connect_error);
}

// Establir charset
$conn->set_charset($charset);
?>