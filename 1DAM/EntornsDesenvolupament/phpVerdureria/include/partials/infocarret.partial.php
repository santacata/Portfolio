<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (isset($_GET['mostrar'])) {
    switch ($_GET['mostrar']) {
        case 'carret':
            include './include/partials/mostraCarret.partial.php';
            break;
        case 'compra':
            include './include/partials/mostraCompra.partial.php';
            break;
    }
} else {

// Incloem la connexió a la base de dades (correctament amb ruta relativa)
include './include/configMySQL.php';

// 🔁 Incloem les entitats abans de fer cap `unserialize()`
require_once './include/entity/CarretCompra.php';
require_once './include/entity/Producte.php';

// Si el valor que tenim no es pot unserialitzar, l’eliminem
if (isset($_SESSION["carretCompra"])) {
    $carretValida = @unserialize($_SESSION["carretCompra"]);
    if (!$carretValida || !($carretValida instanceof CarretCompra)) {
        unset($_SESSION["carretCompra"]);
    }
}

// Recuperem o creem el carret
if (isset($_SESSION["email"])) {
    if (isset($_SESSION["carretCompra"])) {
        $carretCompra = unserialize($_SESSION["carretCompra"]);
    } else {
        $carretCompra = new CarretCompra($_SESSION["email"]);
    }
    $carretCompra->setIdUsuari($_SESSION["email"]);
    $_SESSION["carretCompra"] = serialize($carretCompra);
} else {
    if (isset($_SESSION["carretCompra"])) {
        $carretCompra = unserialize($_SESSION["carretCompra"]);
    } else {
        $carretCompra = new CarretCompra(rand(100, 50000));
    }
    $_SESSION["carretCompra"] = serialize($carretCompra);
}

// Verifiquem si hi ha un producte en sessió
if (isset($_SESSION['idProducte']) && isset($_SESSION['quantitatProducte'])) {
    $id = $_SESSION['idProducte'];
    $quantitat = $_SESSION['quantitatProducte'];

    // Connexió amb MySQLi
    $conn = new mysqli($servidor, $usuari, $contrasenya, $basedades);

    // Comprovem la connexió
    if ($conn->connect_error) {
        die("Error de connexió: " . $conn->connect_error);
    }

    // Consulta per obtindre les dades del producte des de la BBDD
    $sql = "SELECT id, nom, preu, descripcio FROM producte WHERE id = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $id);
    $stmt->execute();
    $result = $stmt->get_result();
    $producte = $result->fetch_assoc();

    if ($producte) {
        $id = $producte["id"];
        $nom = $producte['nom'];
        $preuUnitari = $producte['preu'];
        $descripcio = $producte['descripcio'];
        $preuTotal = $preuUnitari * $quantitat;

        $quantitatAnterior = 0;
        if ($carretCompra->contéProducte($id)) {
            $quantitatAnterior = $carretCompra->getProducte($id)->getQuantitat();
        }

        $nouProducte = new Producte($id, $nom, $quantitat, $preuUnitari, $descripcio);
        $carretCompra->afegirProducte($nouProducte);
        $_SESSION["carretCompra"] = serialize($carretCompra);

        // 📊 Info final
        $quantitatTotalProducte = $quantitatAnterior + $quantitat;
        $totalProductesDiferents = $carretCompra->getQuantitatProductesDiferents();

        echo "<div class='infocarret'>";
        echo "<h3>Últim producte afegit</h3>";
        echo "<ul>";
        echo "<li><strong>ID:</strong> $id</li>";
        echo "<li><strong>Nom:</strong> $nom</li>";
        echo "<li><strong>Preu unitari:</strong> $preuUnitari €</li>";
        echo "<li><strong>Kgs afegits:</strong> $quantitat</li>";
        echo "<li><strong>Total d’aquest producte:</strong> $quantitatTotalProducte kgs</li>";
        echo "<li><strong>Total productes al carret:</strong> $totalProductesDiferents</li>";
        echo "<li><strong>Usuari:</strong> " . (isset($_SESSION['email']) ? $_SESSION['email'] : "No autentificat") . "</li>";
        echo "<li><strong>Total afegit:</strong> $preuTotal €</li>";
        echo "</ul>";
        echo "<div class='enllacos'>";
        echo "<a href='index.php?apartat=botiga&mostrar=carret'>🛒 Veure carret</a><br>";
        echo "<a href='index.php?apartat=botiga&mostrar=compra'>✅ Finalitzar compra</a><br>";
        echo "<a href='index.php?apartat=botiga'>🔙 Tornar a la botiga</a>";
        echo "</div>";
        echo "</div>";
    }

    $stmt->close();
    $conn->close();
}
}
?>
