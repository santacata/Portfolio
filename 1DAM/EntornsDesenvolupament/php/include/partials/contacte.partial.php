<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (!isset($_SESSION['estil'])) {
    $_SESSION['estil'] = 'estils.css';
}

$estil = $_SESSION['estil'];

echo "<link rel='stylesheet' href='css/$estil'>";
?>
<h2>Contacte</h2>
<form class="formulari" method="post" action="index.php?apartat=processaContacte">
    <input type="email" name="email" placeholder="El teu correu" required>
    <br/>
    <textarea name="missatge" placeholder="Missatge"></textarea>
    <label for="puntuacio">Puntua la pàgina (1 a 5):</label>
    <input id="puntuacio" name="puntuacio" type="number" min="1" max="5">
    <label for="multiplicador">Multiplicador:</label>
    <input id="multiplicador" name="multiplicador" type="range" min="1" max="100" value="1" oninput="document.getElementById('sliderValue').innerText=this.value;">
    <span id="sliderValue">1</span>
    <div class="acceptar">
    <input type="submit" value="Enviar">
    <input type="reset" value="Esborrar">
    </div>
</form>
<?php include './include/partials/infocarret.partial.php'; ?>