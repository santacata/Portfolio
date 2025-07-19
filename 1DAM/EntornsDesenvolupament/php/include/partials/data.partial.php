<?php
//Configurar idioma español
setlocale(LC_TIME, "ca_ES.UTF-8", "ca_ES", "catalan"); // Configurar idioma español
// Mostrar la data actual
$any = (new DateTime())->format(' \d\e Y'); // Resultado: "de 2025"
$mesos = [
    1 => "Gener", "Febrer", "Març", "Abril", "Maig", "Juny",
    "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"
];
$mes = $mesos[date('n')];
$dies = [
    "Diumenge, ", "Dilluns, ", "Dimarts, ", "Dimecres, ", "Dijous, ", "Divendres, ", "Dissabte, ",
    
];
$dia = $dies[date(format: 'w')];
$numero= date('d');
$dataActual=$dia.$numero." de ".$mes.$any;
// Nom del fitxer actual
$nomFitxerActual = basename($_SERVER['PHP_SELF']);
// Nom del servidor
$nomServidor = $_SERVER['SERVER_NAME'];
?>
    <div id="data">
        <p style="margin: 0; font-size: 1rem;"><?= $dataActual ?></p>
    </div>
