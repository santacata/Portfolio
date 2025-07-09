<?php

function escriureLog($creedencial) {
    $file = '../usuaris/log.txt';

    if (!file_exists($file)) {
        $file='./usuaris/log.txt'; //Si no existeix li passem un altra ruta perquè està en un altre nivell
    }

    $handle = fopen($file, "r");
    if ($handle) {

        if (isset($_SESSION["registreCorrecte"])) {
            $creedencial = $_SESSION["nom"];

            $linea = "El usuari ".$creedencial." s'ha registrat correctament a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
        
            unset($_SESSION["registreCorrecte"]);
            exit; //Si no li posem exit executa tot el codi del php, i no ens interessa això
        }

        if (isset($_SESSION["editar"])) {

            $linea = "El producte ".$creedencial." ha sigut editat a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
        
            unset($_SESSION["editar"]);
            header("Location: ../index.php?apartat=admin&seccio=productes&editat=si");
            exit;
        }

        if (isset($_SESSION["eliminar"])) {

            $linea = "El producte ".$creedencial." ha sigut eliminat a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
        
            unset($_SESSION["eliminar"]);
            header("Location: ../index.php?apartat=admin&seccio=productes&eliminat=si");
            exit;
        }

        if (isset($_SESSION["logout"])) {
            $creedencial = $_SESSION["nom"] ?? 'Desconegut';

            $linea = "El usuari ".$creedencial." s'ha desloguejat a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
        
            unset($_SESSION["logout"]);
            session_destroy(); // Ara sí destruïm la sessió
            exit;
        }

        if (isset($_SESSION["contrasenyaNoIgual"])) {
            $linea = "S'ha intentat crear un usuari nou de ".$creedencial." però les contrasenyes no coincidien a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
            fclose($handle); //Tanquem per a que no consumisca recursos
            unset($_SESSION["contrasenyaNoIgual"]);
            die; //Per a que isca del metode
        }
        if (isset($_SESSION["emailExistente"])) {
            $linea = "S'ha intentat crear un usuari nou però ".$_SESSION["emailExistente"]." ja existia a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
            fclose($handle); //Tanquem per a que no consumisca recursos
            header("Location: ./../index.php"); //Redirigeix a la pàgina principal
        }
        if (isset($_SESSION["creedencialsIncorrectes"])) {
            $horaActual = date("H:i:s");
            $linea = "$creedencial ha intentat iniciar sessió erroneament a les $horaActual\n";
        
            // Leemos el archivo para ver si la última línea es igual
            $linies = file($file, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
            $ultimaLinea = end($linies);
        
            if (trim($ultimaLinea) !== trim($linea)) {
                file_put_contents($file, $linea, FILE_APPEND);
            }
        
            fclose($handle);
            header("Location: ./../index.php");
        }
        if (isset($_SESSION["email"])){
            $linea = "$creedencial ha iniciat sessió correctament a les ".date("H:i:s")."\n";
            file_put_contents($file, $linea, FILE_APPEND);
            fclose($handle); //Tanquem per a que no consumisca recursos
            header("Location: ./../index.php"); //Redirigeix a la pàgina principal
        }
    }
}
function mostraProductesBD($pagina = 1) {
    $productesPerPagina = 6;
    $offset = ($pagina - 1) * $productesPerPagina;
    
    include_once "configMySQL.php";



    // Comptar el total de productes
    $sqlTotal = "SELECT COUNT(*) as total FROM producte";
    $resultatTotal = $conn->query($sqlTotal);
    $filaTotal = $resultatTotal->fetch_assoc();
    $totalProductes = $filaTotal['total'];
    $totalPagines = ceil($totalProductes / $productesPerPagina);

    // Obtenir només els productes de la pàgina actual
    $sql = "SELECT * FROM producte LIMIT $productesPerPagina OFFSET $offset";
    $resultat = $conn->query($sql);

    if ($resultat->num_rows > 0) {
        echo "<div id='productes'>";
        while ($producte = $resultat->fetch_assoc()) {
            echo "<div class='producte'>";
            echo "<img src='images/{$producte['imatge']}' alt='Imatge de {$producte['nom']}' style='max-width: 200px;'>"; 
            echo "<h3>{$producte['nom']}</h3>";
            echo "<p>{$producte['preu']} €</p>";
            mostraFormulariProducte($producte['id']);
            echo "</div>";
        }
        echo "</div>";
    } else {
        echo "<p>No hi ha productes per mostrar.</p>";
    }

    // Mostrar controls de pàginació
    echo "<div class='paginacio'>";
    if ($pagina > 1) {
        echo "<a href='index.php?apartat=botiga&pagina=1'>&laquo; Primera</a> ";
        echo "<a href='index.php?apartat=botiga&pagina=" . ($pagina - 1) . "'>&lsaquo; Anterior</a> ";
    }

    for ($i = 1; $i <= $totalPagines; $i++) {
        if ($i == $pagina) {
            echo "<strong>$i</strong> ";
        } else {
            echo "<a href='index.php?apartat=botiga&pagina=$i'>$i</a> ";
        }
    }

    if ($pagina < $totalPagines) {
        echo "<a href='index.php?apartat=botiga&pagina=" . ($pagina + 1) . "'>Següent &rsaquo;</a> ";
        echo "<a href='index.php?apartat=botiga&pagina=$totalPagines'>Última &raquo;</a>";
    }
    echo "</div>";

    $conn->close();
}