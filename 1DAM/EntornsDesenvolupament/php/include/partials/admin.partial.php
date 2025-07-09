<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

$arxiu = './usuaris/passwd.txt';
$usuaris = [];

// Funció per guardar usuaris
function guardarUsuaris($usuaris, $arxiu) {
    $contenido = '';
    foreach ($usuaris as $usuari) {
        $contenido .= implode(':', $usuari) . "\n";
    }
    file_put_contents($arxiu, $contenido);
}

// Eliminar usuari
if (isset($_POST['eliminar'])) {
    $usuariEliminar = $_POST['eliminar'];
    file_put_contents("./usuaris/log.txt", "El usuari $usuariEliminar s'ha eliminat a les " . date("H:i:s") . "\n", FILE_APPEND);

    if (file_exists($arxiu)) {
        $lineas = file($arxiu, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        $usuaris = [];
        foreach ($lineas as $linea) {
            $datos = explode(':', $linea);
            if (count($datos) === 3 && $datos[0] !== $usuariEliminar) {
                $usuaris[] = $datos;
            }
        }
        guardarUsuaris($usuaris, $arxiu);
    }

    header("Location: " . $_SERVER['PHP_SELF']);
    exit();
}

// Editar usuari
if (isset($_POST['editar'])) {
    $usuariOriginal = $_POST['usuari_original'];
    if ($usuariOriginal !== 'admin') {
        $nouUsuari = trim($_POST['usuari']);
        $nouCorreo = trim($_POST['correo']);
        $novaContra = trim($_POST['contrasena']);

        if (file_exists($arxiu)) {
            $lineas = file($arxiu, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
            $usuaris = [];
            foreach ($lineas as $linea) {
                $datos = explode(':', $linea);
                if (count($datos) === 3) {
                    if ($datos[0] === $usuariOriginal) {
                        $usuaris[] = [$nouUsuari, $nouCorreo, $novaContra];
                    } else {
                        $usuaris[] = $datos;
                    }
                }
            }
            guardarUsuaris($usuaris, $arxiu);
        }
    }
}

// Carregar usuaris
if (file_exists($arxiu)) {
    $lineas = file($arxiu, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    foreach ($lineas as $linea) {
        $datos = explode(':', $linea);
        if (count($datos) === 3) { //Si són tres parts el array fet a partir de la linia
            $usuaris[] = $datos;
        }
    }
}

$estil = $_SESSION['estil'] ?? 'estils.css';
$seccio = $_GET['seccio'] ?? 'usuaris';
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestió administrativa</title>
    <link rel="stylesheet" href="./../../css/<?php echo htmlspecialchars($estil); ?>">
    <style>
        table { border-collapse: collapse; margin-right: 2.5%; margin-left: 2.5%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        button { padding: 5px 10px; margin: 2px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Gestió administrativa</h2>
    <nav>
        <a href="?apartat=admin&seccio=usuaris">Usuaris</a> |
        <a href="?apartat=admin&seccio=productes">Productes</a> |
        <a href="?apartat=admin&seccio=comandes">Comandes</a>
    </nav>
    <hr>

    <?php if ($seccio === 'usuaris'): ?>
        <h2>Llista de Usuaris</h2>
        <table>
            <tr>
                <th>Usuari</th>
                <th>Correu</th>
                <th>Contrasenya</th>
                <th>Accions</th>
            </tr>
            <?php foreach ($usuaris as $usuari): ?>
                <tr>
                    <td><?php echo htmlspecialchars($usuari[0]); ?></td>
                    <td><?php echo htmlspecialchars($usuari[1]); ?></td>
                    <td><?php echo htmlspecialchars($usuari[2]); ?></td>
                    <td>
                        <?php if ($usuari[0] !== 'admin'): ?>
                            <form method="POST" style="display:inline;">
                                <input type="hidden" name="usuari_original" value="<?php echo htmlspecialchars($usuari[0]); ?>">
                                <input type="text" name="usuari" value="<?php echo htmlspecialchars($usuari[0]); ?>" required>
                                <input type="email" name="correo" value="<?php echo htmlspecialchars($usuari[1]); ?>" required>
                                <input type="text" name="contrasena" value="<?php echo htmlspecialchars($usuari[2]); ?>" required>
                                <button type="submit" name="editar">Guardar</button>
                            </form>
                            <form method="POST" style="display:inline;">
                                <input type="hidden" name="eliminar" value="<?php echo htmlspecialchars($usuari[0]); ?>">
                                <button type="submit">Eliminar</button>
                            </form>
                        <?php endif; ?>
                    </td>
                </tr>
            <?php endforeach; ?>
        </table>
    <form method="GET" action="index.php">
    <input type="hidden" name="apartat" value="admin">
    <input type="hidden" name="seccio" value="usuaris">
    <input type="hidden" name="subseccio" value="log">
    <button type="submit">Mostrar log</button>
</form>
<?php 
include_once "./include/funcionsAdmin.php";
if (isset($_GET['subseccio']) && $_GET['subseccio'] === 'log') {
    mostraLog();
}
endif; ?>

<?php if ($seccio === 'productes'):
include_once "./include/funcionsAdmin.php"; 
gestionaProductes();
    ?>
<?php endif; ?>

<?php if ($seccio === 'comandes'):
    include_once "./include/funcionsAdmin.php";
    mostraComandes();

endif; ?>
