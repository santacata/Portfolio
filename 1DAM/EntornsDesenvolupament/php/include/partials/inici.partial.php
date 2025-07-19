<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (!isset($_SESSION['estil'])) {
    $_SESSION['estil'] = 'estils.css';
}

$estil = $_SESSION['estil'];

echo "<link rel='stylesheet' href='css/$estil'>";

if (isset($_GET['compra'])) {
    echo "<p style='color: green;'>S'ha realitat la compra correctament</p>" ;
}
?>
<h2>Inici</h2>

<p>Benvingut al lloc web!</p>
<img src="images/welcome.jpg" alt="Benvingut" style="width:100%;max-width:400px;border-radius:8px;">
<?php include './include/partials/infocarret.partial.php'; ?>