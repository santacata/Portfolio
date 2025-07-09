<?php
if (!class_exists('Producte')) {
class Producte {
    private int $id;
    private string $nom;
    private float $quantitat;
    private float $preuUnitari;
    private string $descripcio;

    public function __construct(int $id, string $nom, float $quantitat, float $preuUnitari, string $descripcio) {
        $this->id = $id;
        $this->nom = $nom;
        $this->quantitat = $quantitat;
        $this->preuUnitari = $preuUnitari;
        $this->descripcio = $descripcio;
    }

    public function getId(): int {
        return $this->id;
    }

    public function setId(int $id): void {
        $this->id = $id;
    }

    public function getNom(): string {
        return $this->nom;
    }

    public function setNom(string $nom): void {
        $this->nom = $nom;
    }

    public function getQuantitat(): float {
        return $this->quantitat;
    }

    public function setQuantitat(float $quantitat): void {
        $this->quantitat = $quantitat;
    }

    public function getPreuUnitari(): float {
        return $this->preuUnitari;
    }

    public function setPreuUnitari(float $preuUnitari): void {
        $this->preuUnitari = $preuUnitari;
    }

    public function getDescripcio(): string {
        return $this->descripcio;
    }

    public function setDescripcio(string $descripcio): void {
        $this->descripcio = $descripcio;
    }
}
}
?>