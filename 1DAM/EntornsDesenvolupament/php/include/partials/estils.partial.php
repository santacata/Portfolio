<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (isset($_POST['estil'])) {
    $estil=$_SESSION['estil']=$_POST['estil'];
}
echo "<link rel='stylesheet' href='css/$estil'>";
?>

<form method="POST" id="estils" action=""> <!-- Formulari per a canviar l'estil de la pàgina -->
<div class="selector">
    <p>Selecciona l'estil de la pàgina:</p>
    <div class="radio">
        <input type="radio" id="estil1" name="estil" value="estils3.css">
        <label for="estil1">Negre</label>
    </div>
    <div class="radio">
        <input type="radio" id="estil2" name="estil" value="estils2.css">
        <label for="estilsregistre2.css">Rosa</label>
    </div>
    <input type="radio" id="estilDefecte" name="estil" value="estils.css" checked hidden> <!--enviem un valor ocult-->
    <input type="submit" value="Enviar">
</div>
</form>