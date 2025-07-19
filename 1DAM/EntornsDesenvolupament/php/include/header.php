<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
$estil = isset($_SESSION['estil']) ? ($_SESSION['estil']) : 'estils.css';
?>
<!DOCTYPE html>
<html>
<head>
    
    <link rel="stylesheet" href="/css/<?= htmlspecialchars($estil) ?>">
    <title>Projecte PHP</title>
    
</head>
<body>
    <header>
        <img id="poma" src="./images/poma.png">
        <h1>Fruites Cata</h1>
        <h3>Fruiteria/Verdureria Online</h3>
        <img id="platan" src="./images/platan.png">
        <?php 
        include_once "partials/menu.partial.php";
        include_once 'partials/login.partial.php'; ?>

    </header>
