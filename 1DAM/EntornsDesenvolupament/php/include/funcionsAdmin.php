<?php function mostraLog() {
    if (file_exists("./usuaris/log.txt")) {
        // Línies per pàgina
        $liniesPerPagina = 10;

        // Pàgina actual (per GET)
        $logPaginaActual = isset($_GET['paginaLog']) ? max(1, intval($_GET['paginaLog'])) : 1;

        // Llegim totes les línies
        $totesLesLinies = file("./usuaris/log.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES) ?: [];

        $totalLinies = count($totesLesLinies);
        $totalPagines = ceil($totalLinies / $liniesPerPagina);

        // Agafem només les línies per a la pàgina actual
        $inici = ($logPaginaActual - 1) * $liniesPerPagina;
        $liniesPagina = array_slice($totesLesLinies, $inici, $liniesPerPagina);

        // Mostrar taula
        echo "<table border='1'><tr><th>Log</th></tr>";
        foreach ($liniesPagina as $linea) {
            $clase = '';
            if (stripos($linea, 'eliminat') !== false) {
                $clase = 'log-eliminat';
            } elseif (stripos($linea, 'iniciat') !== false) {
                $clase = 'log-login-correcto';
            } elseif (stripos($linea, 'editat') !== false) {
                $clase = 'log-login-correcto';
            } elseif (stripos($linea, 'erroneament') !== false) {
                $clase = 'log-registro-fallido';
            } elseif (stripos($linea, 'desloguejat') !== false) {
                $clase = 'log-deslogin';
            } elseif (stripos($linea, 'coincidien') !== false) {
                $clase = 'log-coincidien';
            } elseif (stripos($linea, 'existia') !== false) {
                $clase = 'log-existia';
            } elseif (stripos($linea, 'registrat') !== false) {
                $clase = 'log-registrat';
            }
            echo "<tr class='$clase'><td>" . htmlspecialchars($linea) . "</td></tr>";
        }
        echo "</table>";

        // Mostrar la paginació
        echo "<div class='paginacio'>";
        if ($logPaginaActual > 1) {
            echo "<a href='?apartat=admin&seccio=usuaris&subseccio=log&paginaLog=1'>&laquo; Primera</a> ";
            echo "<a href='?apartat=admin&seccio=usuaris&subseccio=log&paginaLog=" . ($logPaginaActual - 1) . "'>&lsaquo; Anterior</a> ";
        }

        for ($i = 1; $i <= $totalPagines; $i++) {
            if ($i == $logPaginaActual) {
                echo "<strong>$i</strong> ";
            } else {
                echo "<a href='?apartat=admin&seccio=usuaris&subseccio=log&paginaLog=$i'>$i</a> ";
            }
        }

        if ($logPaginaActual < $totalPagines) {
            echo "<a href='?apartat=admin&seccio=usuaris&subseccio=log&paginaLog=" . ($logPaginaActual + 1) . "'>Següent &rsaquo;</a> ";
            echo "<a href='?apartat=admin&seccio=usuaris&subseccio=log&paginaLog=$totalPagines'>Última &raquo;</a>";
        }
        echo "</div>";
    } else {
        echo "<p>No s'ha trobat el fitxer de log.</p>";
    }
}

function gestionaProductes() {
    echo "<a href='?apartat=admin&seccio=productes&anyadir=true'>Afegir Productes</a>";

    // Si NO estamos afegint, mostrar el llistat
    if (!isset($_GET['anyadir'])) {
        $pagina = isset($_GET['pagina']) ? (int)$_GET['pagina'] : 1;
        $productesPerPagina = 6;
        $offset = ($pagina - 1) * $productesPerPagina;

        include_once "./include/configMySQL.php";

        // Comptar el total de productes
        $sqlTotal = "SELECT COUNT(*) as total FROM producte";
        $resultatTotal = $conn->query($sqlTotal);
        $filaTotal = $resultatTotal->fetch_assoc();
        $totalProductes = $filaTotal['total'];
        $totalPagines = ceil($totalProductes / $productesPerPagina);

        // Depuració
        echo "<div style='font-size: small; color: gray;'>Total productes: $totalProductes | Total pàgines: $totalPagines | Pàgina actual: $pagina</div>";

        // Obtenir els productes de la pàgina actual
        $sql = "SELECT id, nom, preu, imatge FROM producte LIMIT $productesPerPagina OFFSET $offset";
        $resultat = $conn->query($sql);

        if (isset($_GET['eliminat'])) {
            echo "<p style='color: green;'>Producte eliminat correctament</p>";
        }
        if (isset($_GET['editat'])) {
            echo "<p style='color: green;'>Producte editat correctament</p>";
        }

        echo "<h2>Llistat de productes</h2>";
        echo "<table class='taula-admin'>";
        echo "<tr><th>ID</th><th>Nom</th><th>Preu</th><th>Imatge</th><th>Accions</th></tr>";

        while ($fila = $resultat->fetch_assoc()) {
            $img = $fila['imatge'];
            $rutaImg = (!empty($img) && file_exists('images/' . $img)) ? $img : "sense_preferides.png"; //Si no pugem ninguna assigna la imatge per defecte

            echo "<tr>";
            echo "<td>{$fila['id']}</td>";
            echo "<td>{$fila['nom']}</td>";
            echo "<td>{$fila['preu']}</td>";
            echo "<td><img src='images/$rutaImg' alt='Producte' width='50'></td>";
            echo "<td>
                <a href='./include/eliminaProducteAdmin.php?id={$fila['id']}' onclick='return confirm(\"Segur que vols eliminar aquest producte?\")'>🗑️</a>
                <a href='./include/editarProducteAdmin.php?id={$fila['id']}' onclick='return confirm(\"Segur que vols editar aquest producte?\")'>📝</a>
            </td>";
            echo "</tr>";
        }

        echo "</table>";

        // Mostrar controls de pàginació
        if ($totalPagines > 1) {
            echo "<div class='paginacio'>";
            if ($pagina > 1) {
                echo "<a href='index.php?apartat=admin&seccio=productes&pagina=1'>&laquo; Primera</a> ";
                echo "<a href='index.php?apartat=admin&seccio=productes&pagina=" . ($pagina - 1) . "'>&lsaquo; Anterior</a> ";
            }

            for ($i = 1; $i <= $totalPagines; $i++) {
                if ($i == $pagina) {
                    echo "<strong>$i</strong> ";
                } else {
                    echo "<a href='index.php?apartat=admin&seccio=productes&pagina=$i'>$i</a> ";
                }
            }

            if ($pagina < $totalPagines) {
                echo "<a href='index.php?apartat=admin&seccio=productes&pagina=" . ($pagina + 1) . "'>Següent &rsaquo;</a> ";
                echo "<a href='index.php?apartat=admin&seccio=productes&pagina=$totalPagines'>Última &raquo;</a>";
            }
            echo "</div>";
        }
    } else {
        // Formulari d'afegir producte
        echo "<form action='index.php?apartat=admin&seccio=productes&anyadir=true' method='POST' enctype='multipart/form-data'>
        <h2>Afegir un producte</h2>
        <input type='text' name='nom' placeholder='Nom' required><br>
        <input type='text' name='descripcio' placeholder='Descripció' required><br>
        <input type='text' name='preu' placeholder='Preu' required><br>
        <label for='imatge'>Imatge (opcional):</label>
        <input type='file' name='imatge'><br>
        <input type='text' name='magrada' placeholder='Magrada' required><br>
        <input type='text' name='estoc' placeholder='Estoc' required><br>
        <input type='submit' value='Afegir'></form>
        <a href='index.php?apartat=admin&seccio=productes'>Tornar</a>";

        include_once "./include/configMySQL.php";
        if ($_POST) {
            $nom = $_POST['nom'] ?? "Defecte";
            $descripcio = $_POST['descripcio'] ?? "Defecte";
            $preu = $_POST['preu'] ?? "0.00";
            $magrada = $_POST['magrada'] ?? "0";
            $estoc = $_POST['estoc'] ?? "0";
            $data_afegit = date('Y-m-d');

            // Tractament de la imatge
            $imatge = '';
            if (isset($_FILES['imatge']) && $_FILES['imatge']['error'] == 0) {
                $imatge_tmp = $_FILES['imatge']['tmp_name'];
                $extensio = pathinfo($_FILES['imatge']['name'], PATHINFO_EXTENSION);
                $nom_imatge = $nom . '.' . $extensio;
                move_uploaded_file($imatge_tmp, "images/" . $nom_imatge);
                $imatge = $nom_imatge;
            } else {
                $imatge = 'sense_preferides.png';
            }

            // Inserir a la base de dades
            $stmt = $conn->prepare("INSERT INTO producte (nom, descripcio, preu, imatge, magrada, data_afegit, estoc) VALUES (?, ?, ?, ?, ?, ?, ?)");

            if ($stmt) {
                $stmt->bind_param("ssdsisi", $nom, $descripcio, $preu, $imatge, $magrada, $data_afegit, $estoc);
                
                if ($stmt->execute()) {
                    echo "<p style='color:green;'>Producte afegit correctament!</p>";
                } else {
                    echo "<p style='color:red;'>Error en afegir el producte, revisa les creedencials: " . $stmt->error . "</p>";
                }

                $stmt->close();
            }

        }
    }
}

function mostraComandes(){
    $pagina = isset($_GET['pagina']) ? (int)$_GET['pagina'] : 1;
    $productesPerPagina = 6;
    $offset = ($pagina - 1) * $productesPerPagina;

    include_once "./include/configMySQL.php";


    $sqlTotal = "SELECT COUNT(*) as total FROM comanda";
    $resultatTotal = $conn->query($sqlTotal);
    $filaTotal = $resultatTotal->fetch_assoc();
    $totalComandes = $filaTotal['total'];
    $totalPagines = ceil($totalComandes / $productesPerPagina);
    $sql = "SELECT id, usuari, productes, data
            FROM comanda ftotal
            LIMIT $productesPerPagina OFFSET $offset";
    $resultat = $conn->query($sql);

    echo "<h2>Llistat de comandes</h2>";
    echo "<table class='taula-admin'>";
    echo "<tr><th>ID</th><th>Usuari</th><th>Productes</th><th>Data</th></tr>";

    while ($fila = $resultat->fetch_assoc()) {
        echo "<tr>";
        echo "<td>{$fila['id']}</td>";
        echo "<td>{$fila['usuari']}</td>";
        echo "<td>{$fila['productes']}</td>";
        echo "<td>{$fila['data']}</td>";
        echo "</tr>";
    }

    echo "</table>";


    echo "<div class='paginacio'>";
    if ($pagina > 1) {
        echo "<a href='index.php?apartat=admin&seccio=comandes&pagina=1'>&laquo; Primera</a> ";
        echo "<a href='index.php?apartat=admin&seccio=comandes&pagina=" . ($pagina - 1) . "'>&lsaquo; Anterior</a> ";
    }

    for ($i = 1; $i <= $totalPagines; $i++) {
        if ($i == $pagina) {
            echo "<strong>$i</strong> ";
        } else {
            echo "<a href='index.php?apartat=admin&seccio=comandes&pagina=$i'>$i</a> ";
        }
    }

    if ($pagina < $totalPagines) {
        echo "<a href='index.php?apartat=admin&seccio=comandes&pagina=" . ($pagina + 1) . "'>Següent &rsaquo;</a> ";
        echo "<a href='index.php?apartat=admin&seccio=comandes&pagina=$totalPagines'>Última &raquo;</a>";
    }
    echo "</div>";
}

?>