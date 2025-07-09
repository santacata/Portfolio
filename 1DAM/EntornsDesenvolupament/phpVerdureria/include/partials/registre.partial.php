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
<h2>Registre</h2>
<form class="formulari" method="post" action="index.php?apartat=processaRegistre">
    <label for="nom">Nom*</label>
    <input id="nom" name="nom" placeholder="Nom" type="text"required>
    <label for="cognoms">Cognoms</label>
    <input id="cognoms" name="cognoms" placeholder="Cognoms" type="text">
    <label for="email">Correu electrònic*</label>
    <input id="email" name="emailNou" type="email" placeholder="Correu electrònic" required>
    <label for="password">Contrasenya*</label>
    <input id="password" name="passwordNova" type="password" placeholder="Contrasenya" required>
    <label for="confirm_oassword">Repeteix contrasenya**</label>
    <input type="password" name="confirm_password" id="confirm_password" placeholder="Repeteix contrasenya" required>
    <label for="poblacio">Selecciona la teua població*:</label>
    <select id="poblacio" name="poblacio" required>
        <option value="">-- Selecciona una opció --</option>
        <option value="Xàtiva">Xàtiva</option>
        <option value="Genovés">Genovés</option>
        <option value="Alzira">Alzira</option>
        <option value="Ontinyent">Ontinyent</option>
    </select>
    <p>Selecciona el teu horari:</p>
    <div class="radio">
    <label for="Mati">Mati</label>
    <input type="radio" name="horari" value="Vesprada">
    <label for="Vesprada">Vesprada</label>
    <input type="radio" name="horari" value="Vesprada">
    </div>
    <div class="selector">
    <p>Selecciona l'estil de la pàgina:</p>
    <div class="radio">
        <input type="radio" id="estil1" name="estil" value="estils.css" checked>
        <label for="estil1">Negre</label>
    </div>
    <div class="radio">
        <input type="radio" id="estil2" name="estil" value="estils2.css">
        <label for="estil2">Rosa</label>
    </div>
    </div>
    <br/>
    <label>Selecciona les teues fruites o verdures preferides:</label>
    <div id="fruites">
        <div class="checkbox">
        <input type="checkbox" name="preferides[]" value="Poma">
        <label for="Poma">Poma</label>
        </div>
        <br>
        <div class="checkbox">
        <input type="checkbox" name="preferides[]" value="Plàtan">
        <label for="Plàtan">Plàtan</label>
        </div>
        <br>
        <div class="checkbox">
        <input type="checkbox" name="preferides[]" value="Pastanaga">
        <label for="Pastanaga">Pastanaga</label>
        </div>
        <br>
        <div class="checkbox">
        <input type="checkbox" name="preferides[]" value="Tomata">
        <label for="Tomata">Tomata</label>
        </div>
        <br>
        <div class="checkbox">
        <input type="checkbox" name="preferides[]" value="Enciam">
        <label for="Enciam">Enciam</label>
        </div>
    </div>
    <div class="checkbox">
    <input id="accepto" type="checkbox" name="accepta" required> 
    <label for="accepto">Accepto les condicions*</label>
    </div>
    <div class="buttons">
        <input type="submit" value="Registrar">
        <input type="reset" value="Esborrar">
    </div>
</form>
<?php include './include/partials/infocarret.partial.php'; ?>