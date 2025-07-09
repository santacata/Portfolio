<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
    $estil = isset($_SESSION['estil']) ? $_SESSION['estil'] : 'estils.css';
    $email = htmlspecialchars(trim($_POST['email']));
    $missatge = isset($_POST['missatge']) ? htmlspecialchars(trim($_POST['missatge'])) : 'No especificat';
    $puntuacio = isset($_POST['puntuacio']) ? (int) $_POST['puntuacio'] : 0;
    $multiplicador = isset($_POST['multiplicador']) && is_numeric($_POST['multiplicador']) ? (int) $_POST['multiplicador'] : 1;
    $totalPuntuacio = $puntuacio * $multiplicador;
    $paraules = explode(" ", $missatge);

if ($puntuacio >= 1 && $puntuacio <= 5) {
    $img_url = "./images/puntuacio{$puntuacio}.png";
} else {
    $img_url = "../images/sense_puntuacio.png";
    $puntuacio = 0;
};
?>

<!DOCTYPE html>
<html>
<head>
<?php
    // Carregar l'estil CSS
    $estil = isset($_SESSION['estil']) ? ($_SESSION['estil']) : 'estils.css';
    echo '<link rel="stylesheet" href="./css/' . htmlspecialchars($estil) . '">';

    ?>
    <title>Resultat del Contacte</title>
</head>
<body>
    <header>
        <h1>Resultat del Contacte</h1>
    </header>
    <main>
        <h2>Missatge enviat:</h2>
        <ul>
            <li><strong>Correu electrònic:</strong> <?= $email ?></li>
            <li><strong>Missatge:</strong> <?=$missatge ?></li>
            <li><strong>Puntuació:</strong> <?=$totalPuntuacio ?></li>
        </ul>
        <h3>Puntuació visualitzada:</h3>
        <div>
            <?php for ($i = 0; $i < $totalPuntuacio; $i++): ?>
    <img src="<?= $img_url ?>" alt="Puntuació" style="width: 50px; height: 50px;">
<?php endfor;?>
        </div>
        
        
        <ul style="list-style-type: none; padding: 0;">
    <?php foreach ($paraules as $paraula): ?>
        <?php
        $classes = "normal";
        if (strcasecmp($paraula, "fruita") === 0 || strcasecmp($paraula, "verdura") === 0) {
            $classes = "keyword";
        } elseif (strlen($paraula) >= 10) {
            $classes = "long-word";
        }
        ?>
        <li style="display: inline-block; margin: 5px; padding: 5px; border: 1px solid #ccc; background-color: <?= $classes === 'keyword' ? '#FFD700' : ($classes === 'long-word' ? '#000' : '#f4f4f4') ?>; color: <?= $classes === 'long-word' ? '#fff' : '#000' ?>;">
            <?= htmlspecialchars($paraula) ?>
        </li>
    <?php endforeach; ?>
</ul>
        <a href="./index.php?apartat=contacte">Tornar</a>
        <?php

?>
    </main>
</body>
</html>