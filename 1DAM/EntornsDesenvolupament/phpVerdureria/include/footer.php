<?php
$estil = isset($_POST['estil']) ? ($_POST['estil']) : 'estils.css';
echo '<link rel="stylesheet" href="../css/<?php $estil?>"'; 
?>
<head>
</head>

<br><br><br><br><br> <!--Salts de linia per a veure correctament la pagina-->
    <footer>
        <p>IES Lluis Simarro Lacabra</p>
        <p>Desenvolupament d'aplicacions multiplataforma</p>
        <p>Curs 24/25</p>
    </footer>
</body>
</html>
