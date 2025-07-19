<nav>
    <ul>
        <?php
        // Inici
        echo '<li>';
        if (isset($_GET['apartat']) && $_GET['apartat'] == "inici") {
            echo '<p class="apartatSeleccionat">Inici</p>';
        } else {
            echo '<a href="index.php?apartat=inici">Inici</a>';
        }
        echo '</li>';

        // Registre (sols si no està la sesió iniciada)
        if (!isset($_SESSION['email'])) {
            echo '<li>';
            if (isset($_GET['apartat']) && $_GET['apartat'] == "registre") {
                echo '<p class="apartatSeleccionat">Registre</p>';
            } else {
                echo '<a href="index.php?apartat=registre">Registre</a>';
            }
            echo '</li>';
        }

        // Contacte
        echo '<li>';
        if (isset($_GET['apartat']) && $_GET['apartat'] == "contacte") {
            echo '<p class="apartatSeleccionat">Contacte</p>';
        } else {
            echo '<a href="index.php?apartat=contacte">Contacte</a>';
        }
        echo '</li>';

        // Botiga
        echo '<li>';
        if (isset($_GET['apartat']) && $_GET['apartat'] == "botiga") {
            echo '<p class="apartatSeleccionat">Botiga</p>';
        } else {
            echo '<a href="index.php?apartat=botiga">Botiga</a>';
        }
        echo '</li>';

        // Administrar (sols per a admin)
        if (isset($_SESSION['email']) && $_SESSION['email'] == 'admin@dam.com') {
            echo '<li>';
            if (isset($_GET['apartat']) && $_GET['apartat'] == "admin") {
                echo '<p class="apartatSeleccionat">Administrar</p>';
            } else {
                echo '<a href="index.php?apartat=admin">Administrar</a>';
            }
            echo '</li>';
        }
        ?>
    </ul>
</nav>