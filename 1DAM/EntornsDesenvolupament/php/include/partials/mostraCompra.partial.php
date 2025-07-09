<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
require_once './include/entity/CarretCompra.php';
require_once './include/entity/Producte.php';

if (isset($_SESSION["carretCompra"])) {
    $carretCompra = unserialize($_SESSION["carretCompra"]);

    echo "<h2>Resum de la compra</h2>";
    $carretCompra->mostrarCarretCompra(); //Cridem al mètode per a mostrar esto sense poder eliminar

    if (isset($_SESSION["email"])) { //Posem un camp que sols estiga visible si estem registrats
        echo "<form method='post' action=''>";
        echo "<button type='submit' name='fesCompra'>Fes la compra</button>";
        echo "</form>";
    } else {
        echo "Si vols comprar registra't<br/>";
    }

    if (isset($_POST['fesCompra'])) { // Si enviem la variable fesCompra, ho escrivim a la BBDD
        // Connexió a la base de dades
        include_once './include/entity/CredencialsBD.php';

        // Establim la connexió amb MySQLi
        $conn = new mysqli($servidor, $usuari, $contrasenya, $basedades);

        // Comprovar connexió
        if ($conn->connect_error) {
            die("Error de connexió: " . $conn->connect_error);
        }

        $sql = "INSERT INTO comanda (usuari, productes) VALUES (?, ?)";
        $stmt = $conn->prepare($sql); // Prepara la consulta amb MySQLi

        if ($stmt) {
            // Obtenim l'ID de l'usuari
            $idUsuari = $carretCompra->getIdUsuari();
            $productesText = "";

            // Generem el text de productes
            foreach ($carretCompra->getProductes() as $producte) {
                $productesText .= $producte->getId() . ":" . $producte->getQuantitat() . ":" . $producte->getPreuUnitari() . ";";
            }
            $productesText = rtrim($productesText, ";"); // Elimina l'últim punt i coma

            // Enllacem els paràmetres amb MySQLi (utilitzant bind_param)
            $stmt->bind_param("ss", $idUsuari, $productesText); // Evita injeccions SQL

            // Executem la consulta
            if ($stmt->execute()) {
                echo "<p>✅ Comanda guardada correctament a la base de dades.</p>";
                unset($_SESSION['ultimProducte']); //Eliminem el ultim producte així no el afegeix al nou carret
                unset($_SESSION['carretCompra']); //Eliminem la variable
                unset($_SESSION['mostrar']);
                header('Location: http://localhost/dashboard/php/index.php?compra=true');
                
            } else {
                echo "<p>❌ Error en guardar la comanda: " . $stmt->error . "</p>";
            }

            $stmt->close();
        } else {
            echo "<p>❌ Error en preparar la consulta: " . $conn->error . "</p>";
        }

        $conn->close();
    }
}

