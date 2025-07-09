<?php
require_once './include/entity/Producte.php';

if (!class_exists('CarretCompra')) {
class CarretCompra {
    private string $idUsuari;
    private array $productes;

    public function __construct(string $idUsuari) {
        $this->idUsuari = $idUsuari;
        $this->productes = [];
    }

    public function getIdUsuari(): string {
        return $this->idUsuari;
    }

    public function setIdUsuari(string $idUsuari): void {
        $this->idUsuari = $idUsuari;
    }

    public function getProductes(): array {
        return $this->productes;
    }

    public function setProductes(array $productes): void {
        $this->productes = $productes;
    }

    public function getProducte(int $idProducte): ?Producte {
        foreach ($this->productes as $producte) {
            if ($producte->getId() === $idProducte) {
                return $producte;  // Si troba el producte, el retorna
            }
        }
        return null;  // Si no troba el producte, retorna null
    }

    public function afegirProducte(Producte $producteNou): void {
        $id = $producteNou->getId();
        foreach ($this->productes as $index => $p) {
            if ($p->getId() === $id) {
                // Ja existeix, sumem la quantitat
                $novaQuantitat = $p->getQuantitat() + $producteNou->getQuantitat();
                $p->setQuantitat($novaQuantitat);
                return;
            }
        }
        // Si no estava, l'afegim nou
        $this->productes[] = $producteNou;
    }
    public function eliminarProducte(int $id): void {
        foreach ($this->productes as $index => $p) {
            if ($p->getId() === $id) {
                unset($this->productes[$index]);
                $this->productes = array_values($this->productes); // Reindexar
                return;
            }
        }
    }
    
    public function contéProducte(int $idProducte): bool {
        foreach ($this->productes as $producte) {
            if ($producte->getId() === $idProducte) {
                return true;  // El producte ja està en el carret
            }
        }
        return false;  // El producte no està en el carret
    }
    
    public function canviarQuantitatProducte(int $id, int $novaQuantitat): void {
        foreach ($this->productes as $p) {
            if ($p->getId() === $id) {
                $p->setQuantitat($novaQuantitat);
                return;
            }
        }
    }
    
    public function mostrarCarret(): void {
        if (empty($this->productes)) {
            echo "<p>El carret està buit.</p>";
            return;
        }
    
        echo "<div id='productes'>";
    
        foreach ($this->productes as $p) {
            echo "<div class='producte'>";
                echo "<h3>" . htmlspecialchars($p->getNom()) . "</h3>";
                echo "<p><strong>ID:</strong> " . htmlspecialchars($p->getId()) . "</p>";
                echo "<p><strong>Kg:</strong> " . htmlspecialchars($p->getQuantitat()) . "</p>";
                echo "<p><strong>Preu unitari:</strong> " . htmlspecialchars($p->getPreuUnitari()) . " €</p>";
                echo "<p><strong>Descripció:</strong> " . nl2br(htmlspecialchars($p->getDescripcio())) . "</p>";
    
                echo "<div class='accions'>";
                    echo "<a class='btn eliminar' href='index.php?apartat=botiga&mostrar=carret&elimina=" . urlencode($p->getId()) . "'>🗑 Eliminar</a>";
    
                    echo "<form class='formulari-quantitat' method='post' action='index.php?apartat=botiga&mostrar=carret'>";
                        echo "<input type='hidden' name='idProducte' value='" . htmlspecialchars($p->getId()) . "'>";
                        echo "<label for='quantitat_" . $p->getId() . "'>Selecciona els kg a restar:</label>";
                        echo "<input type='number' id='quantitat_" . $p->getId() . "' name='quantitatProducte' value='" . htmlspecialchars($p->getQuantitat()) . "' min='0' step='any' required>";
                        echo "<button type='submit'>Modifica</button>";
                    echo "</form>";
                echo "</div>";
            echo "</div>";
        }
    
        echo "</div>";
    }
    

    function mostrarCarretCompra(){
            if (empty($this->productes)) {
                echo "El carret està buit.<br>";
                return;
            }
            echo "<div id='productes'>";
    
            foreach ($this->productes as $p) {
                echo "<div class='producte'>";
                echo "ID: " . $p->getId() . "<br>";
                echo "Nom: " . $p->getNom() . "<br>";
                echo "Quantitat: " . $p->getQuantitat() . "<br>";
                echo "Preu unitari: " . $p->getPreuUnitari() . " €<br>";
                echo "Descripció: " . $p->getDescripcio() . "<br><br>";
                echo "</div>";
            }
            echo "</div>";

            echo "Hi ha un total de ".$this->getQuantitatProductesDiferents(). " productes diferents.<br/>";
            echo "El preu de la comanda es ".$this->getPreuTotal()."€<br/>";
        
    }
    
    public function buidarCarret(): void {
        $this->productes = [];
    }

    public function getQuantitatProductesDiferents(): int {
        return count($this->productes);  // Retorna el nombre de productes diferents al carret
    }

    public function getPreuTotal(): float {
        $total = 0.0;
        foreach ($this->productes as $producte) {
            $total += $producte->getQuantitat() * $producte->getPreuUnitari();
        }
        return $total;
    }

    
}
}
?>