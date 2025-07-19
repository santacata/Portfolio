<?php 
if (session_status() === PHP_SESSION_NONE) {
    session_start(); // Iniciar la sesión solo si no está activa antes de res
}

$_SESSION['estil'] = isset($_POST['estil']) ? $_POST['estil'] : 'estils.css';
$estil = $_SESSION['estil'] ?? 'estils.css';
include_once './include/dades.php'; // Està al mateix nivell
$poblacioDades = $dadesPoblacions[$_POST['poblacio']];
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./css/<?= $estil ?>">
    <title>Resultat del Registre</title>
</head>
<body>
    <header>
        <h1>Resultat del Registre</h1>
    </header>
    <main>
    <?php


// Guardar los datos del formulario en la sesión
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $_SESSION['nom'] = isset($_POST['nom']) ? htmlspecialchars(trim($_POST['nom'])) : 'No especificat';
    $_SESSION['cognoms'] = isset($_POST['cognoms']) ? htmlspecialchars(trim($_POST['cognoms'])) : 'No especificats';
    $_SESSION['passwordNova'] = isset($_POST['passwordNova']) ? trim($_POST['passwordNova']) : '';
    $_SESSION['confirmPassword'] = isset($_POST['confirm_password']) ? trim($_POST['confirm_password']) : '';    
    $_SESSION['emailNou'] = isset($_POST['emailNou']) ? htmlspecialchars(trim($_POST['emailNou'])) : 'No especificat';
    $_SESSION['poblacio'] = isset($_POST['poblacio']) ? $_POST['poblacio'] : '';
    $_SESSION['horari'] = isset($_POST['horari']) ? $_POST['horari'] : 'No seleccionat';
    $_SESSION['accepta'] = isset($_POST['accepta']) ? 'Si' : 'No';
    $_SESSION['estil'] = isset($_POST['estil']) ? $_POST['estil'] : 'estils.css';
    $_SESSION['preferides'] = isset($_POST['preferides']) ? $_POST['preferides'] : [];
}

$nom = $_SESSION['nom'] ?? 'No especificat';
$cognoms = $_SESSION['cognoms'] ?? 'No especificats';
$emailNou = $_SESSION['emailNou'];
$passwordNova = $_SESSION['passwordNova'];
$confirmPassword = $_SESSION['confirmPassword'];
$poblacioSeleccionada = $_SESSION['poblacio'] ?? '';
$horari = $_SESSION['horari'] ?? 'No seleccionat';
$accepta = $_SESSION['accepta'] ?? 'No';
$estil = $_SESSION['estil'] ?? 'estils.css';
$preferides = $_SESSION['preferides'];
$estilSeleccionado = $estil === 'estils.css' ? 'Estil predeterminat' : ucfirst(str_replace('.css', '', $estil));
$imagenPoblacion = "./images/{$poblacioSeleccionada}.png";


// Quantitat de preferides seleccionades
$quantitatPreferides = is_array($preferides) ? count($preferides) : 0;

// Associació de preferides amb imatges
$imatges = [
    "Poma" => "./images/poma.png",
    "Plàtan" => "./images/platan.png",
    "Pastanaga" => "./images/pastanaga.png",
    "Tomata" => "./images/tomata.png",
    "Enciam" => "./images/enciam.png",
];


if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (strlen($passwordNova) > 0 && $passwordNova === $confirmPassword) {
        $archivo = './usuaris/passwd.txt'; // Ruta del archivo donde se guardarán los usuarios
        $lineas = file_exists($archivo) ? file($archivo, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES) : [];
        $emailExiste = false;

        foreach ($lineas as $linea) {
            $datos = explode(':', $linea);
            if (count($datos) >= 2 && $datos[1] === $emailNou) {
                $emailExiste = true; 
                break; //Si el email existeix ix del foreach i activa el boolean que baix no el posa de nou en el arxiu
            }
        }

        if (!$emailExiste) {
            $linea = "\n$nom:$emailNou:" . password_hash($passwordNova, PASSWORD_BCRYPT); //Esto s'escriu en el arxiu
            file_put_contents($archivo, $linea, FILE_APPEND);
        }else{
            include './include/funcions.php';
            $_SESSION["emailExistente"] = $emailNou;
            escriureLog($emailNou);
        }
?>            
<h2>Informació registrada:</h2>
<ul>
    <li><strong>Nom:</strong> <?= $nom ?></li>
    <li><strong>Cognoms:</strong> <?= $cognoms ?></li>
    <li><strong>Correu electrònic:</strong> <?= $emailNou ?></li>
    <li><strong>Contrasenya:</strong> <?= $passwordNova; ?></li>
    <li><strong>Estil:</strong> <?= $estilSeleccionado ?></li>
</ul>

<?php if ($poblacioDades): ?>
    <h3>Informació de la població seleccionada: <?= $poblacioSeleccionada ?></h3>
    <img src="<?= $imagenPoblacion ?>" alt="Imatge de <?= $poblacioSeleccionada ?>" style="width: 200px; height: auto; display: block; margin: 0 auto;">
    <br/>
    <table style="border:1px solid black; border-collapse: collapse; width: 50%; margin: auto;">
        <tr>
            <th style="border:1px solid black;">Camp</th>
            <th style="border:1px solid black;">Valor</th>
        </tr>
        <?php foreach ($poblacioDades as $camp => $valor): ?>
            <tr>
                <td style="border:1px solid black;"><?= htmlspecialchars(ucfirst($camp)) ?></td>
                <td style="border:1px solid black;"><?= htmlspecialchars($valor) ?></td>
            </tr>
        <?php endforeach; ?>
    </table>
<?php endif; ?>

<ul>
    <li><strong>Horari:</strong> <?= $horari ?></li>
    <li><strong>Accepta les condicions:</strong> <?= $accepta ?></li>
    <li><strong>Preferides seleccionades:</strong></li>
    <?php if ($quantitatPreferides > 0): ?>
        <ul>
            <?php foreach ($preferides as $preferida): ?>
                <li><?= $preferida ?></li>
            <?php endforeach; ?>
        </ul>
    <?php else: ?>
        <p>Cap preferida seleccionada.</p>
    <?php endif; ?>
</ul>
<a href="./index.php?apartat=registre">Tornar</a>
<br/>
<?php

$_SESSION["registreCorrecte"]=$nom;
include './include/funcions.php';
escriureLog($emailNou);
    } else {
        ?>
        <p>❌ Les contrasenyes no coincideixen, el usuari no s'ha registrat.</p>
        <a href="./../index.php">Tornar</a>
        <?php
        $_SESSION["contrasenyaNoIgual"]=true;
        include './include/funcions.php';
        escriureLog($emailNou);
    }
}
?>

    </main>
</body>
</html>
