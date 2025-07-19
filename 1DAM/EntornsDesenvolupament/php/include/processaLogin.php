<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = trim($_POST['email']);
    $password = trim($_POST['password']);
    
    $file = '../usuaris/passwd.txt'; // Asegura't de que la ruta siga correcta
    
    if (!file_exists($file)) {
        die("Error: No es pot accedir a la base de dades d'usuaris.");
    }
    
    $handle = fopen($file, "r");
    if ($handle) {
        while (($line = fgets($handle)) !== false) {
            include_once "./funcions.php";
            $parts = explode(":", trim($line));
            
            if (count($parts) >= 3) {
                $_SESSION['nom']=$nom=trim($parts[0]);
                $storedEmail = trim($parts[1]);
                $storedPassword = trim($parts[2]);

                if ($email === $storedEmail &&  password_verify ($password, $storedPassword) && $email=="admin@dam.com") {
                    $_SESSION["email"] = $email;
                    unset($_SESSION["creedencialsIncorrectes"]);
                    escriureLog(($nom));
                    fclose($handle);
                    header("Location: ../index.php?apartat=menu");
                    exit;
                }
                
                if ($email === $storedEmail && password_verify ($password, $storedPassword)) {
                    $_SESSION["email"] = $email;
                    unset($_SESSION["creedencialsIncorrectes"]);
                    escriureLog(($nom));
                    fclose($handle);
                    header("Location: ../index.php");
                    exit;
                }else{
                    $_SESSION["creedencialsIncorrectes"]=true;
                    escriureLog($email);
                }
            }
        }
        fclose($handle);
    }
} else {
    echo "Accés denegat.";
}
?>
