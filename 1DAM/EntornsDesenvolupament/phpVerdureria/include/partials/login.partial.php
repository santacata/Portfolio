<?php
// Iniciar la sesión si no está activa
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

// Manejo del logout

    if (isset($_POST["logout"])) {
        $creedencial = $_SESSION["nom"] ?? 'Desconegut';
        $file = "./usuaris/log.txt"; // Ruta al fitxer on vols escriure
    
        $linea = "El usuari ".$creedencial." s'ha desloguejat a les ".date("H:i:s")."\n";
        file_put_contents($file, $linea, FILE_APPEND);
    
        unset($_SESSION["logout"]);
        session_destroy();
        header( 'Location: index.php');
    }


// Manejo del login
if ($_SERVER["REQUEST_METHOD"] == "POST" && !empty($_POST["email"]) && !empty($_POST["password"])) {
    $_SESSION["email"] = htmlspecialchars($_POST["email"]);
}
?>


<?php
if (isset($_SESSION['email'])) {
    $imatgePerfil = "./images/usuaris/";
    $extensions = ['.jpg', '.jpeg', '.png', '.gif'];
    $trobada = false;

    foreach ($extensions as $ext) {
        $ruta = $imatgePerfil . $_SESSION["email"] . $ext;
        if (file_exists($ruta)) {
            echo "<img src='$ruta' alt='Imatge de perfil' width='100'>";
            $trobada = true;
            break;
        }
    }

    if (!$trobada) {
        echo "<img src='./img/usuaris/defecte.png' alt='Imatge per defecte' width='100'>";
    }

    echo "<p>Benvingut/da, " . htmlspecialchars($_SESSION["email"]) . "!</p>";
    echo '<a href="index.php?apartat=inici&perfil=canvi">Canviar imatge de perfil</a>';
    echo '<form method="post" action=""><input type="submit" name="logout" value="Log Off"></form>';

} else {
    ?>
    <form class="login" method="post" action="./include/processaLogin.php" style="display:flex; align-items:center; justify-content: center;">
        <label for="email">Correu electrònic: </label>
        <input id="email" name="email" type="email" placeholder="Correu electrònic" required>
        <label for="password">Contrasenya: </label>
        <input id="password" name="password" type="password" placeholder="Contrasenya" required>
        <div class="buttons">
            <input type="submit" value="Login">
            <input type="reset" value="Esborrar">
        </div>
    </form>
    <?php
    if (isset($_SESSION["creedencialsIncorrectes"])) {
        echo '<p style="color: red;">Credencials incorrectes</p>';
        unset($_SESSION["creedencialsIncorrectes"]);
    }
}
?>

</body>
</html>
