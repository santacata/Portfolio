<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

// Comprovem si l'usuari està identificat
if (!isset($_SESSION["email"])) {
    echo "<p style='color:red'>Has d'iniciar sessió per canviar la imatge de perfil.</p>";
    return;
}

// Processar el formulari
if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_FILES["imatge"])) {
    $fitxer = $_FILES["imatge"];

    // Comprovar errors
    if ($fitxer["error"] !== UPLOAD_ERR_OK) {
        $error = "Error en pujar la imatge.";
    } elseif ($fitxer["size"] > 400 * 1024) {
        $error = "Fitxer massa gran (màxim 400KB).";
    } else {
        // Validar extensió
        $extensio = strtolower(pathinfo($fitxer["name"], PATHINFO_EXTENSION)); //Pathinfo obté la extensió del fitxer
        $valides = ["jpg", "jpeg", "png", "gif"];
        if (!in_array($extensio, $valides)) {
            $error = "Tipus de fitxer no vàlid.";
        } else {
            // Eliminar imatges antigues
            $carpeta = "./images/usuaris/";
            foreach ($valides as $ext) {
                $camíAntic = $carpeta . $_SESSION["email"] . "." . $ext;
                if (file_exists($camíAntic)) {
                    unlink($camíAntic); //Es borra
                }
            }

            // Desa la nova
            $destí = $carpeta . $_SESSION["email"] . "." . $extensio;
            if (move_uploaded_file($fitxer["tmp_name"], $destí)) { //Ací la guarda a la carpeta amb el nom del usuari
                $missatge = "Imatge pujada correctament.";
            } else {
                $error = "No s'ha pogut desar la imatge.";
            }
        }
    }
}
?>

<h2>Canvia la teua imatge de perfil</h2>

<form action="" method="POST" enctype="multipart/form-data"> <!-- El enctype es posa sols quan vas a pujar arxius, i els envia a $_FILES -->
    <label for="imatge">Selecciona una imatge (jpg, jpeg, png, gif - màxim 400KB):</label><br>
    <input type="file" name="imatge" id="imatge" accept=".jpg, .jpeg, .png, .gif" required><br><br>

    <input type="submit" value="Pujar imatge">
    <a href="index.php?apartat=inici">Cancel·lar</a>
</form>

<?php
// Mostrar missatges
if (isset($error)) {
    echo "<p style='color:red'>" . htmlspecialchars($error) . "</p>";
}
if (isset($missatge)) {
    echo "<p style='color:green'>" . htmlspecialchars($missatge) . "</p>";
}
?>